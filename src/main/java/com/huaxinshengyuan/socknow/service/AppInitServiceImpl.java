package com.huaxinshengyuan.socknow.service;

import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.fieldaccess.DynamicProperties;
import org.springframework.data.neo4j.fieldaccess.DynamicPropertiesContainer;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.Author;
import com.huaxinshengyuan.socknow.domain.Contact;
import com.huaxinshengyuan.socknow.domain.Group;
import com.huaxinshengyuan.socknow.domain.Keyword;
import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.enums.AuthorType;
import com.huaxinshengyuan.socknow.domain.enums.Field;
import com.huaxinshengyuan.socknow.domain.enums.Permission;
import com.huaxinshengyuan.socknow.domain.enums.Role;
import com.huaxinshengyuan.socknow.domain.enums.UserType;
import com.huaxinshengyuan.socknow.domain.index.FieldIndex;
import com.huaxinshengyuan.socknow.repo.AuthorRepository;
import com.huaxinshengyuan.socknow.repo.ContactRepository;
import com.huaxinshengyuan.socknow.repo.GroupRepository;
import com.huaxinshengyuan.socknow.repo.KeywordRepository;
import com.huaxinshengyuan.socknow.repo.UserRepository;
@Service("appInitService")
@Transactional
public class AppInitServiceImpl implements AppInitService {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GroupService groupService;
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private PublicationService publicationService;
	@Autowired private AuthorRepository authorRepository;
	@Autowired private ContactRepository contactRepository;
	@Autowired private KeywordRepository keywordRepository;

	@Autowired private KeywordService keywordService;
	@Override @Transactional
	public void initDb() {
		createUsersAndGroups();
		createKeywords();
		createAuthors();
		createPubls();
	}
	@Transactional
	public void createUsersAndGroups() {

		// Create Hongtao's family
		Group hongtaoGroup = new Group("hongtao_family", Role.ROLE_ADMIN);
		groupService.save(hongtaoGroup);

		User hongtao = new User("hongtao", "Hongtao Ren", "hongtao",
				Role.ROLE_ADMIN, Role.ROLE_USER);
		userService.register(hongtao);
		userService.joinInGroup(hongtao, hongtaoGroup, UserType.CREATOR);
		User yangyang = new User("yangyang", "Haoyang Ren", "yangyang", Role.ROLE_USER);
		userService.register(yangyang);

		userService.joinInGroup(yangyang, hongtaoGroup, UserType.USER);
		User yifang = new User("yifang", "Yifang Shi", "yifang", Role.ROLE_USER);
		userService.register(yifang);

		userService.joinInGroup(yifang, hongtaoGroup, UserType.USER);

		// Create Tieju's lab
		Group tiejuLab = new Group("tieju_lab", Role.ROLE_USER);
		groupService.save(tiejuLab);

		User tieju = new User("tieju", "Tieju Ma", "tieju", Role.ROLE_ADMIN,
				Role.ROLE_USER);
		userService.register(tieju);
		userService.joinInGroup(tieju, tiejuLab, UserType.CREATOR);
		User hongbin = new User("hongbin", "Hongbin Yan", "hongbin",
				Role.ROLE_USER);
		userService.register(hongbin);
		userService.joinInGroup(hongbin, tiejuLab, UserType.USER);

		// join Tieju's lab
		userService.joinInGroup(hongtao, tiejuLab, UserType.USER);
		// friends

		userService.makeFriends(yifang, hongtao);
		userService.makeFriends(yangyang, hongtao);
		userService.makeFriends(yangyang, tieju);
		userService.makeFriends(yangyang, yifang);

	}
	@Transactional
	public void createAuthors()
	{
		
		Contact hongtaoContact = new Contact("renh@iiasa.ac.at", "+43-2236-807.499", "Rosasgasse 18 1120,  Vienna, Austria", "...");
		contactRepository.save(hongtaoContact);
		Author hongtao = new Author("Hongtao", "Ren", "IIASA.IME");
		hongtao.setOtherFirstName("宏涛");
		hongtao.setOtherLastName("任");
		hongtao.setContact(hongtaoContact);
		authorRepository.save(hongtao);
		Author tieju = new Author("Tieju", "Ma", "ECUST");
		hongtao.setOtherFirstName("铁驹");
		hongtao.setOtherLastName("马");
		authorRepository.save(tieju);
		
	}
	@Transactional
	public void createKeywords()
	{
		keywordRepository.save(new Keyword("Onotolgy"));
		keywordRepository.save(new Keyword("本体"));
		keywordRepository.save(new Keyword("knowledge science"));
		keywordRepository.save(new Keyword("knowledge engineering"));
		keywordRepository.save(new Keyword("software engineering"));
	
		Keyword ono = keywordRepository.findByPropertyValue("keyword", "Onotolgy");
		Keyword ono_cn = keywordRepository.findByPropertyValue("keyword", "本体");
		
		Keyword kno = keywordRepository.findByPropertyValue("keyword", "knowledge science");
		Keyword kno_e = keywordRepository.findByPropertyValue("keyword", "knowledge engineering");
		
		keywordService.addSimmilarity(ono, ono_cn, 1f);
		keywordService.addSimmilarity(kno, kno_e, 0.7f);
		
	}
	@Transactional
	public void createPubls() {

		User hongtao = userRepository.findByPropertyValue(FieldIndex.LOGIN,
				"hongtao");
		User yangyang = userRepository.findByPropertyValue(FieldIndex.LOGIN,
				"yangyang");
		Group tiejuLab = groupRepository.findByPropertyValue(
				"name", "tieju_lab");
		Author hongtaoA = authorRepository.findByPropertyValue("firstName", "Hongtao");
		Author tiejuA = authorRepository.findByPropertyValue("firstName", "Tieju");
		// upload some publications
		Publication onto_con = new Publication();
		onto_con.setName("renh:2012_1");
		onto_con.setTitle("Ontology construction and its applications in local research communities");
		onto_con.setCreated(new Date());
		onto_con.setUser(hongtao);
		onto_con.setAbs("Ontology engineering has been widely used for divers purposes in different communitie and numbers of apptoaches have been reported for developing ontologies; however, ...");

		DynamicProperties onto_dyn = new DynamicPropertiesContainer();
		onto_dyn.setProperty(Field.pages.name(), "pp.279-317");
		onto_dyn.setProperty(Field.year.name(), "2012");
		onto_dyn.setProperty(Field.journal.name(),
				"Modeling for decision support in network-based service");
		onto_con.setDyn(onto_dyn);
		publicationService.save(onto_con);
		publicationService.addAuthor(onto_con, hongtaoA, 1, AuthorType.Author, true);
		publicationService.addAuthor(onto_con, tiejuA, 2, AuthorType.Author, true);
		
		
		Keyword ono = keywordRepository.findByPropertyValue("keyword", "Onotolgy");
		Keyword kno = keywordRepository.findByPropertyValue("keyword", "knowledge science");
		publicationService.addKeyword(onto_con, ono, 1, 5);
		publicationService.addKeyword(onto_con, kno, 2, 3);
		
		userService.accessPublication(yangyang, onto_con, Permission.ALL);
		groupService.accessPublication(tiejuLab, onto_con, Permission.READ);
	}


	
}

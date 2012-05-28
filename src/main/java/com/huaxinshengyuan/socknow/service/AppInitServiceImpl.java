package com.huaxinshengyuan.socknow.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.fieldaccess.DynamicProperties;
import org.springframework.data.neo4j.fieldaccess.DynamicPropertiesContainer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.Group;
import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.enums.Fields;
import com.huaxinshengyuan.socknow.domain.enums.Permission;
import com.huaxinshengyuan.socknow.domain.enums.Role;
import com.huaxinshengyuan.socknow.domain.enums.UserType;



@Service("appInitService") @Transactional
public class AppInitServiceImpl implements AppInitService {

	@Autowired UserService userService;
	@Autowired GroupService groupService;
	@Autowired PublicationService publicationService;
	
	@Override
	public void init() {
		
		
		//Create Hongtao's family
		Group hongtaoGroup = new Group("hongtao_family", Role.ROLE_ADMIN);
		groupService.save(hongtaoGroup);
		
		User hongtao = new User("hongtao", "Hongtao Ren", "hongtao", Role.ROLE_ADMIN, Role.ROLE_USER);
		userService.register(hongtao);
		userService.joinInGroup(hongtao, hongtaoGroup, UserType.CREATOR);
		
		User yangyang = new User("yangyang", "Haoyang Ren", "yangyang", Role.ROLE_USER);
		userService.register(yangyang);
		userService.joinInGroup(yangyang, hongtaoGroup, UserType.USER);
		
		User yifang = new User("yifang", "Yifang Shi", "yifang", Role.ROLE_USER);
		userService.register(yifang);
		userService.joinInGroup(yifang, hongtaoGroup, UserType.USER);
			
		
		//Create Tieju's lab
		Group tiejuLab = new Group("tieju_lab", Role.ROLE_USER);
		groupService.save(tiejuLab);
		
		
		User tieju = new User("tieju", "Tieju Ma", "tieju", Role.ROLE_ADMIN, Role.ROLE_USER);
		userService.register(tieju);
		userService.joinInGroup(tieju, tiejuLab, UserType.CREATOR);
		
		User hongbin = new User("hongbin", "Hongbin Yan", "hongbin", Role.ROLE_USER);
		userService.register(hongbin);
		userService.joinInGroup(hongbin, tiejuLab, UserType.USER);
		
		//join Tieju's lab
		userService.joinInGroup(hongtao, tiejuLab, UserType.USER);
		
		//upload some publications
		Publication onto_con = new Publication();
		onto_con.setBibtexId("renh:2012_1");
		onto_con.setTitle("Ontology construction and its applications in local research communities");
		onto_con.setCreated(new Date());
		onto_con.setUser(hongtao);
		onto_con.setAbs("Ontology engineering has been widely used for divers purposes in different communitie and numbers of apptoaches have been reported for developing ontologies; however, ...");
		
		DynamicProperties onto_dyn = new DynamicPropertiesContainer();
		onto_dyn.setProperty(Fields.pages.name(), "pp.279-317");
		onto_dyn.setProperty(Fields.year.name(), "2012");
		onto_dyn.setProperty(Fields.journal.name(), "Modeling for decision support in network-based service");
		onto_con.setDynamicProperties(onto_dyn);
		publicationService.save(onto_con);
		
		
		userService.accessPublication(yangyang, onto_con, Permission.ALL);
		groupService.accessPublication(tiejuLab, onto_con, Permission.READ);
		
	}

}

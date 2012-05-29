package com.huaxinshengyuan.socknow.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.index.FieldIndex;
import com.huaxinshengyuan.socknow.repo.PublicationRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/socknow-test-context.xml"})
public class PublicationRepositoryTest {

    @Autowired PublicationRepository publicationRepository;
	private Logger log = LoggerFactory.getLogger(this.getClass());
  
	@Test
    public void testPublRepo() {


    	for(Publication p:publicationRepository.findAllByQuery(FieldIndex.PUBL_FULL_INDEX, "abs","engineering"))
    	{
    		log.debug("p: " + p.getTitle() + ", per: " +p.getId()) ;
    	}
    	
    }


}

package com.huaxinshengyuan.socknow.test;

import java.io.IOException;
import java.util.List;


import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huaxinshengyuan.socknow.domain.oxm.Field;
import com.huaxinshengyuan.socknow.service.EntryConfigService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/socknow-test-context.xml"})
public class PublicationEntryConfigTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntryConfigService entryConfigService;

	@Test
	public void testListFields() throws IOException, ConfigurationException {

		List<Field> fields = entryConfigService.getFieldList(2);
		for (Field field : fields) {
			log.debug("lable is" + field.getLabel() + ",field is: "
					+ field.getName() + ",field type: "
					+ field.getType() + ", required: "
					+ field.getRequired() + ", maxLegnth: "
					+ field.getMaxLength());
		}

	}

}

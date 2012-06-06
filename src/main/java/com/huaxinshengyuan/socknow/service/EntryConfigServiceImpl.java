package com.huaxinshengyuan.socknow.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.DefaultExpressionEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxinshengyuan.socknow.domain.oxm.Field;

@Service("entryConfigService")
public class EntryConfigServiceImpl implements EntryConfigService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private String filePath =this.getClass().getResource("/").getPath()+"entries.xml";

	private XMLConfiguration entryConfig;
/*
	public EntryConfigServiceImpl(String filePath)
			throws ConfigurationException {
		  setupConfiguration(this.getClass().getResource("/").getPath()+filePath);
	}
*/
	public List<Field> getFieldList(int entryNo) throws ConfigurationException {
		setupConfiguration();
		entryNo--;
		List fields = getFields(entryNo);
		List<Field> fieldList = new ArrayList<Field>(0);
		int fieldNo = 0;
		String tag;
		String lbl;
		Boolean required;
		String type;
		Integer maxLength = 0;
		log.debug("paring .xml starting.........");
		for (Iterator iterFields = fields.iterator(); iterFields.hasNext(); fieldNo++) {
			iterFields.next();
			String name = (String) entryConfig.getProperty("entry{"
					+ entryNo + "}/field{" + fieldNo + "}@name");

			String req = (String) entryConfig.getProperty("entry{" + entryNo
					+ "}/field{" + fieldNo + "}@required");

			if (req == null || req.equalsIgnoreCase("false")) {
				required = false;
			} else {
				required = true;
			}

			lbl = (String) entryConfig.getProperty("entry{" + entryNo
					+ "}/field{" + fieldNo + "}@lbl");
			if (lbl == null || lbl.isEmpty()) {
				lbl = name;
				String firstletter = lbl.substring(0, 1);
				String remainder = lbl.substring(1);
				lbl = firstletter.toUpperCase() + remainder;
			}

			tag = (String) entryConfig.getProperty("entry{" + entryNo
					+ "}/field{" + fieldNo + "}@tag");
			if (tag == null || tag.isEmpty()) {
				tag = name;
			}

			type = (String) entryConfig.getProperty("entry{" + entryNo
					+ "}/field{" + fieldNo + "}@type");
			if (type == null) {
				type = "text";
			}
			String length = (String) entryConfig.getProperty("entry{" + entryNo
					+ "}/field{" + fieldNo + "}@maxLength");
			if (length != null) {
				maxLength = Integer.parseInt(length);
			}

			String idTag = (String) entryConfig.getProperty("entry{" + entryNo
					+ "}/field{" + fieldNo + "}@idTag");
			
			Field field = new Field();
			field.setIdTag(Integer.parseInt(idTag));
			field.setName(name);
			field.setType(type);
			field.setLabel(lbl);
			field.setTag(tag);
			field.setRequired(required);
			field.setMaxLength(maxLength);
			fieldList.add(field);

		}
		return fieldList;

	}
	private void setupConfiguration()
			throws ConfigurationException {

		if (entryConfig != null)
			return;

		entryConfig = new XMLConfiguration();

		//log.debug("Loading entries.xml...");
		entryConfig.setFileName(filePath);
		entryConfig.load();

		DefaultExpressionEngine engine = new DefaultExpressionEngine();

		// Use a slash as property delimiter
		engine.setPropertyDelimiter("/");
		// Indices should be provided in curly brackets
		engine.setIndexStart("{");
		engine.setIndexEnd("}");
		// For attributes use simply a @
		engine.setAttributeStart("@");
		engine.setAttributeEnd(null);
		// A Backslash is used for escaping property delimiters
		engine.setEscapedDelimiter("\\/");

		entryConfig.setDefaultExpressionEngine(engine);

	}

	private int findEntryByName(String name) {
		List entries = entryConfig.configurationsAt("entry");
		int entryNo = 0;
		for (Iterator entry = entries.iterator(); entry.hasNext(); entryNo++) {
			entry.next();
			String entryName = (String) entryConfig.getProperty("entry{"
					+ entryNo + "}@name");

			if (!entryName.equalsIgnoreCase(name))
				continue;

			return entryNo;
		}
		return -1;
	}

	private List getFields(String entryName) {
		int entryNo = findEntryByName(entryName);
		return getFields(entryNo);
	}

	private List getFields(int entryNo) {
		List fields = entryConfig.configurationsAt("entry{" + entryNo
				+ "}/field");
		return fields;
	}


	
	public XMLConfiguration getEntryConfig() {
		return entryConfig;
	}

	public void setXMLCongiguration(XMLConfiguration entryConfig) {
		this.entryConfig = entryConfig;
	}

}

package com.huaxinshengyuan.socknow.service;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;

import com.huaxinshengyuan.socknow.domain.oxm.Field;
import com.huaxinshengyuan.socknow.domain.oxm.PublicationEntry;

public interface EntryConfigService {

	public List<Field> getFieldList(int entryNo) throws ConfigurationException;
    public PublicationEntry find(int entryNo) throws ConfigurationException;
}

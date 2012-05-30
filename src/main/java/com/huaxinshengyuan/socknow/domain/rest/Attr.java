package com.huaxinshengyuan.socknow.domain.rest;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="attributes")
public class Attr {
	private String id;
	private String name;
	private Collection<OEntity> values;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<OEntity> getValues() {
		return values;
	}
	public void setValues(Collection<OEntity> values) {
		this.values = values;
	}

}

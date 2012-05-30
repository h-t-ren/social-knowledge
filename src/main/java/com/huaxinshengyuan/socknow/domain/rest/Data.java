package com.huaxinshengyuan.socknow.domain.rest;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="data")
public class Data {
	private long id;
	private String name;
	private Collection<Attr> attributes;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Attr> getAttributes() {
		return attributes;
	}
	public void setAttributes(Collection<Attr> attributes) {
		this.attributes = attributes;
	}

}

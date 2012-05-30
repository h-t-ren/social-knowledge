package com.huaxinshengyuan.socknow.domain.rest;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="entity")
public class Entity {
	
	private String details_html;
	private Data data;
	public String getDetails_html() {
		return details_html;
	}
	public void setDetails_html(String details_html) {
		this.details_html = details_html;
	}
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}

}

package com.huaxinshengyuan.socknow.domain.oxm;

import java.util.List;



public class PublicationEntry {
	
	private String publicationType;
	private List<Field> field;


	public void setField(List<Field> field) {
		this.field = field;
	}


	public List<Field> getField() {
		return field;
	}


	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}


	public String getPublicationType() {
		return publicationType;
	}



}

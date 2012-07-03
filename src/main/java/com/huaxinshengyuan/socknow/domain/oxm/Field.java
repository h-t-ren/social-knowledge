package com.huaxinshengyuan.socknow.domain.oxm;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Field implements Serializable {

	private String tag;
	private String name;
	private String type;
	private Integer maxLength;
	private Boolean required;
	private String label;
	private String value;
	
	public Field()
	{
		
	}

	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	public Boolean getRequired() {
		return required;
	}
	public void setRequired(Boolean required) {
		this.required = required;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}

}

package com.huaxinshengyuan.socknow.domain.oxm;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="entries")
public class PublicationEntries {

	private List<PublicationEntry> entry;

	public void setEntry(List<PublicationEntry> entry) {
		this.entry = entry;
	}

	public List<PublicationEntry> getEntry() {
		return entry;
	}

	

}

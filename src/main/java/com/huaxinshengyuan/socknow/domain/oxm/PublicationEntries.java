package com.huaxinshengyuan.socknow.domain.oxm;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name="entries")
public class PublicationEntries implements Serializable{

	private List<PublicationEntry> entry;

	public void setEntry(List<PublicationEntry> entry) {
		this.entry = entry;
	}

	public List<PublicationEntry> getEntry() {
		return entry;
	}

	

}

package com.mithun.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Author {

	private String authorName;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}

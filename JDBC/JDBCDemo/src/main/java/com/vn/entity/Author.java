package com.vn.entity;

import java.io.Serializable;

public class Author implements Serializable {

	private static final long serialVersionUID = 2754426018554187418L;

	private Integer id;

	private String authorName;

	private String authorAddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorAddress() {
		return authorAddress;
	}

	public void setAuthorAddress(String authorAddress) {
		this.authorAddress = authorAddress;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", authorName=" + authorName + ", authorAddress=" + authorAddress + "]";
	}

}

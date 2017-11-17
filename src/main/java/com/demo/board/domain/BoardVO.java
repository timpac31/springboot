package com.demo.board.domain;

import com.demo.util.StringUtil;

public class BoardVO {
	private int seq;
	private int re_gr;
	private int re_level;
	private int re_sort;
	private String name;
	private String email;
	private String homepage;
	private String title;
	private String filename;
	private String type;
	private long filesize;
	private String passwd;
	private String content;
	private String nowdate;
	private int dn;
	private int acs;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getRe_gr() {
		return re_gr;
	}
	public void setRe_gr(int re_gr) {
		this.re_gr = re_gr;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public int getRe_sort() {
		return re_sort;
	}
	public void setRe_sort(int re_sort) {
		this.re_sort = re_sort;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getContent() {		
		return content;
	}
	public String getContentHtml() {
		return StringUtil.LineToBr(content);
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNowdate() {
		return nowdate;
	}
	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}
	public int getDn() {
		return dn;
	}
	public void setDn(int dn) {
		this.dn = dn;
	}
	public int getAcs() {
		return acs;
	}
	public void setAcs(int acs) {
		this.acs = acs;
	}
	
	
}

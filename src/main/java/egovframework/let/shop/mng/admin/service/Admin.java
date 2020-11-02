package egovframework.let.shop.mng.admin.service;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Admin implements Serializable{
	
	private String a_id;
	private String a_pass;
	private String a_email;
	private String a_name;
	private String a_moddate;
	private String a_regdate;
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_pass() {
		return a_pass;
	}
	public void setA_pass(String a_pass) {
		this.a_pass = a_pass;
	}
	public String getA_email() {
		return a_email;
	}
	public void setA_email(String a_email) {
		this.a_email = a_email;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_moddate() {
		return a_moddate;
	}
	public void setA_moddate(String a_moddate) {
		this.a_moddate = a_moddate;
	}
	public String getA_regdate() {
		return a_regdate;
	}
	public void setA_regdate(String a_regdate) {
		this.a_regdate = a_regdate;
	}
	
	
	
	
}
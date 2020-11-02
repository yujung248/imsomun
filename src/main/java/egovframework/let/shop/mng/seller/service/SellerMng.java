package egovframework.let.shop.mng.seller.service;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class SellerMng {

	private String s_id;
	private String s_idx;
	private String s_nickname;
	private String s_pass;
	private String s_email;
	private String s_photo;
	private MultipartFile file_name;
	private String s_status;
	private String s_phone;
	private String s_addr;
	private String addr1;
	private String addr2;
	private String s_gender;
	private Date s_moddate;
	private Date s_regdate;
	private Date s_birth;
	private String s_account_n;
	private String s_account;
	
	
	
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_idx() {
		return s_idx;
	}
	public void setS_idx(String s_idx) {
		this.s_idx = s_idx;
	}
	public String getS_nickname() {
		return s_nickname;
	}
	public void setS_nickname(String s_nickname) {
		this.s_nickname = s_nickname;
	}
	public String getS_pass() {
		return s_pass;
	}
	public void setS_pass(String s_pass) {
		this.s_pass = s_pass;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getS_photo() {
		return s_photo;
	}
	public MultipartFile getFile_name() {
		return file_name;
	}
	public void setFile_name(MultipartFile file_name) {
		this.file_name = file_name;
	}
	public void setS_photo(String s_photo) {
		this.s_photo = s_photo;
	}
	public String getS_status() {
		return s_status;
	}
	public void setS_status(String s_status) {
		this.s_status = s_status;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	public String getS_addr() {
		return s_addr;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public void setS_addr(String s_addr) {
		this.s_addr = s_addr;
	}
	public String getS_gender() {
		return s_gender;
	}
	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}
	public Date getS_moddate() {
		return s_moddate;
	}
	public void setS_moddate(Date s_moddate) {
		this.s_moddate = s_moddate;
	}
	public Date getS_regdate() {
		return s_regdate;
	}
	public void setS_regdate(Date s_regdate) {
		this.s_regdate = s_regdate;
	}
	public Date getS_birth() {
		return s_birth;
	}
	public void setS_birth(Date s_birth) {
		this.s_birth = s_birth;
	}
	public String getS_account() {
		return s_account;
	}
	public String getS_account_n() {
		return s_account_n;
	}
	public void setS_account_n(String s_account_n) {
		this.s_account_n = s_account_n;
	}
	public void setS_account(String s_account) {
		this.s_account = s_account;
	}
}

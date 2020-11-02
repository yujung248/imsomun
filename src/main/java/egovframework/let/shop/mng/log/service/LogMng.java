package egovframework.let.shop.mng.log.service;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LogMng implements Serializable {
	
	private int 	log_idx;  // 등록 번호
	private String 	s_id;	  // 판매자 아이디
	private String 	sns_idx;  // 구매자 아이디
	private String  nickname;
	private String 	ac_page;	 
	private String 	ac_spec;	 
	private String	log_ip;
	private String 	log_date; // 등록일
	
	public int getLog_idx() {
		return log_idx;
	}
	public void setLog_idx(int log_idx) {
		this.log_idx = log_idx;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getSns_idx() {
		return sns_idx;
	}
	public void setSns_idx(String sns_idx) {
		this.sns_idx = sns_idx;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAc_page() {
		return ac_page;
	}
	public void setAc_page(String ac_page) {
		this.ac_page = ac_page;
	}
	public String getAc_spec() {
		return ac_spec;
	}
	public void setAc_spec(String ac_spec) {
		this.ac_spec = ac_spec;
	}
	public String getLog_ip() {
		return log_ip;
	}
	public void setLog_ip(String log_ip) {
		this.log_ip = log_ip;
	}
	public String getLog_date() {
		return log_date;
	}
	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}
	
	
	
}

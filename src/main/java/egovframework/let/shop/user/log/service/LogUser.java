package egovframework.let.shop.user.log.service;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class LogUser implements Serializable {
	
	private int 	log_idx;
	private String 	s_id;
	private int 	sns_idx;
	private String 	log_ip;
	private Date 	log_date;
	
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
	public int getSns_idx() {
		return sns_idx;
	}
	public void setSns_idx(int sns_idx) {
		this.sns_idx = sns_idx;
	}
	public String getLog_ip() {
		return log_ip;
	}
	public void setLog_ip(String log_ip) {
		this.log_ip = log_ip;
	}
	public Date getLog_date() {
		return log_date;
	}
	public void setLog_date(Date log_date) {
		this.log_date = log_date;
	}

}

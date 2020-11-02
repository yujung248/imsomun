package egovframework.let.shop.user.basket.service;

import java.util.Date;

public class BasketUser {

	private int ba_idx = 0;
	private int sns_idx = 0;
	private String s_id;
	private int ba_q = 0;
	private Date ba_reg_date;
	private int p_idx = 0;
	
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public int getBa_idx() {
		return ba_idx;
	}
	public void setBa_idx(int ba_idx) {
		this.ba_idx = ba_idx;
	}
	public int getSns_idx() {
		return sns_idx;
	}
	public void setSns_idx(int sns_idx) {
		this.sns_idx = sns_idx;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public int getBa_q() {
		return ba_q;
	}
	public void setBa_q(int ba_q) {
		this.ba_q = ba_q;
	}
	public Date getBa_reg_date() {
		return ba_reg_date;
	}
	public void setBa_reg_date(Date ba_reg_date) {
		this.ba_reg_date = ba_reg_date;
	}
	
	
}

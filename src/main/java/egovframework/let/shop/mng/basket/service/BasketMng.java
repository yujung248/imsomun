package egovframework.let.shop.mng.basket.service;

import java.util.Date;

public class BasketMng {
	private int ba_idx;
	private int sns_idx;
	private int p_idx;
	private String s_id;

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	private int ba_q;
	private Date ba_reg_date;

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

	public int getP_idx() {
		return p_idx;
	}

	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
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

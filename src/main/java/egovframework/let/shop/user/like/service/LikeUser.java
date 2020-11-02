package egovframework.let.shop.user.like.service;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class LikeUser implements Serializable{

	private int p_idx;
	private int sns_idx;
	private String s_id;
	private Date l_regdate;
	private int l_idx;
	private String p_name;
	private String p_image;
	
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_image() {
		return p_image;
	}
	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
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
	public Date getL_regdate() {
		return l_regdate;
	}
	public void setL_regdate(Date l_regdate) {
		this.l_regdate = l_regdate;
	}
	public int getL_idx() {
		return l_idx;
	}
	public void setL_idx(int l_idx) {
		this.l_idx = l_idx;
	}
	
}

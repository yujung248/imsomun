package egovframework.let.shop.user.review.service;

public class ReviewUser {
	private String s_id;
	private int sns_idx;
	private int r_idx;
	private int p_idx;
	private String r_content;
	private String r_regdate;
	private String r_delyn;
	private int r_div;
	private int sns_score;
	private int seller_score;
	private String s_nickname;
	private String nickname;
	private String p_name;

	private String original_file_name;
	private String stored_file_name;
	private long file_size;

	public String getStored_file_name() {
		return stored_file_name;
	}

	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	public String getOriginal_file_name() {
		return original_file_name;
	}

	public void setOriginal_file_name(String original_file_name) {
		this.original_file_name = original_file_name;
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

	public int getR_idx() {
		return r_idx;
	}

	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}

	public int getP_idx() {
		return p_idx;
	}

	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_regdate() {
		return r_regdate;
	}

	public void setR_regdate(String r_regdate) {
		this.r_regdate = r_regdate;
	}

	public String getR_delyn() {
		return r_delyn;
	}

	public void setR_delyn(String r_delyn) {
		this.r_delyn = r_delyn;
	}

	public int getR_div() {
		return r_div;
	}

	public void setR_div(int r_div) {
		this.r_div = r_div;
	}

	public int getSns_score() {
		return sns_score;
	}

	public void setSns_score(int sns_score) {
		this.sns_score = sns_score;
	}

	public int getSeller_score() {
		return seller_score;
	}

	public void setSeller_score(int seller_score) {
		this.seller_score = seller_score;
	}

	public String getS_nickname() {
		return s_nickname;
	}

	public void setS_nickname(String s_nickname) {
		this.s_nickname = s_nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

}

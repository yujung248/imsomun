package egovframework.let.shop.user.deal.service;

import java.sql.Date;

public class DealUser {
	// Deal 거래
	private String s_id;  // 판매자 아이디
	private int sns_idx;  // 구매자 아이디
	private int d_idx;  // 거래 번호
	private int p_idx;  // 상품번호
	private String d_ing;  // 거래 진행 상태
	private int d_q;  // 거래 수량
	private Date d_regdate;  // 거래 등록일
	private Date d_edate;  // 거래 수락일
	private String d_request;  // 배송 요청사항
	

	// Product 상품
	// private int p_idx; 테이블 중복값 생략 // 상품번호
	// private String s_id; 테이블 중복값 생략 // 판매자 아이디
	private String p_name;  // 상품명 
	private int p_price;  // 가격
	private Date p_regdate;  // 등록 날짜
	private Date p_moddate;  // 업데이트된 날짜
	private String p_image;  // 메인 제품 사진
	private String p_content;  // 제품 내용
	private String p_tage;  // 분류(해시태그)
	private Date p_sdate;  // 판매시작일
	private Date p_edate;  // 판매종료일
	private String p_status;  // 상태
	private String a_id;  // 운영자 아이디
	private String p_q;  // 재고수량

	// snsprofile 구매자
	//private int sns_idx;
	private String userid; // 구매자 아이디
	private String snscode;  // sns 종류
	private String nickname;  // 닉네임
	private String email;  // 이메일
	private Date reg_date;  // 등록일
	private String del_yn;  // 구매자 상태여부
	
	// seller 판매자
	//private String s_id;  // 판매자 아이디
	private String s_nickname;  // 닉네임
	private String s_pass;  // 비밀번호
	private String s_email;  // 이메일
	private String s_photo;  // 판매자 사진
	private String s_status;  // 판매자 상태여부
	private String s_phone;  // 핸드폰 번호
	private String s_addr;  // 주소
	private String s_gender;  // 성별
	private Date s_moddate;  // 수정일
	private Date s_regdate;  // 등록일
	private Date s_birth;  // 생년월일
	private String s_account;  // 계좌번호
	private String s_account_n;  // 계좌은행	

	// 후기 review
	//private String s_id;  // 판매자 아이디
	//private int sns_idx;  // 구매자 아이디
	private int r_idx;  // 후기 번호
	//private int p_idx;  // 상품 번호
	private String r_content;  // 후기 내용
	private Date r_regdate;  // 작성 일자
	private String r_delyn;  // 삭제여부
	private int r_div;  // 판매구매구분
	private int sns_score;  // 구매자 리뷰 평점
	private int seller_score;  // 판매자 리뷰 평점

	//참조 참고용
	private int rn;  // 거래 순번용
	
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getD_request() {
		return d_request;
	}
	public void setD_request(String d_request) {
		this.d_request = d_request;
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
	public int getD_idx() {
		return d_idx;
	}
	public void setD_idx(int d_idx) {
		this.d_idx = d_idx;
	}
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public String getD_ing() {
		return d_ing;
	}
	public void setD_ing(String d_ing) {
		this.d_ing = d_ing;
	}
	public int getD_q() {
		return d_q;
	}
	public void setD_q(int d_q) {
		this.d_q = d_q;
	}
	public Date getD_regdate() {
		return d_regdate;
	}
	public void setD_regdate(Date d_regdate) {
		this.d_regdate = d_regdate;
	}
	public Date getD_edate() {
		return d_edate;
	}
	public void setD_edate(Date d_edate) {
		this.d_edate = d_edate;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public Date getP_regdate() {
		return p_regdate;
	}
	public void setP_regdate(Date p_regdate) {
		this.p_regdate = p_regdate;
	}
	public Date getP_moddate() {
		return p_moddate;
	}
	public void setP_moddate(Date p_moddate) {
		this.p_moddate = p_moddate;
	}
	public String getP_image() {
		return p_image;
	}
	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_tage() {
		return p_tage;
	}
	public void setP_tage(String p_tage) {
		this.p_tage = p_tage;
	}
	public Date getP_sdate() {
		return p_sdate;
	}
	public void setP_sdate(Date p_sdate) {
		this.p_sdate = p_sdate;
	}
	public Date getP_edate() {
		return p_edate;
	}
	public void setP_edate(Date p_edate) {
		this.p_edate = p_edate;
	}
	public String getP_status() {
		return p_status;
	}
	public void setP_status(String p_status) {
		this.p_status = p_status;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getP_q() {
		return p_q;
	}
	public void setP_q(String p_q) {
		this.p_q = p_q;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSnscode() {
		return snscode;
	}
	public void setSnscode(String snscode) {
		this.snscode = snscode;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
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
	public void setS_account(String s_account) {
		this.s_account = s_account;
	}
	public int getR_idx() {
		return r_idx;
	}
	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public Date getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(Date r_regdate) {
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
	public String getS_account_n() {
		return s_account_n;
	}
	public void setS_account_n(String s_account_n) {
		this.s_account_n = s_account_n;
	}
	
	
}

package egovframework.let.shop.user.main.service;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 게시물에 대한 데이터 처리 모델 클래스
 * 
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009.03.06
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.06  이삼섭          최초 생성
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 * 
 *      </pre>
 */
@SuppressWarnings("serial")
public class UserMain implements Serializable {

	private int p_idx;
	private String s_id;
	private String p_name;
	private int p_price;
	private String p_regdate;
	private String p_moddate;
	private String p_image;
	private String p_content;
	private String p_tage;
	private String p_sdate;
	private String p_edate;
	private String p_status;
	private String p_q;
	private String a_id;
	private int count;
	List<Integer> count1;
	private String keyword;
	
	

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Integer> getCount1() {
		return count1;
	}

	public void setCount1(List<Integer> count1) {
		this.count1 = count1;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
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

	public String getP_regdate() {
		return p_regdate;
	}

	public void setP_regdate(String p_regdate) {
		this.p_regdate = p_regdate;
	}

	public String getP_moddate() {
		return p_moddate;
	}

	public void setP_moddate(String p_moddate) {
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

	public String getP_sdate() {
		return p_sdate;
	}

	public void setP_sdate(String p_sdate) {
		this.p_sdate = p_sdate;
	}

	public String getP_edate() {
		return p_edate;
	}

	public void setP_edate(String p_edate) {
		this.p_edate = p_edate;
	}


	public String getP_status() {
		return p_status;
	}

	public void setP_status(String p_status) {
		this.p_status = p_status;
	}

	public String getP_q() {
		return p_q;
	}

	public void setP_q(String p_q) {
		this.p_q = p_q;
	}

	public int getP_idx() {
		return p_idx;
	}

	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}

	/**
	 * toString 메소드를 대치한다.
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

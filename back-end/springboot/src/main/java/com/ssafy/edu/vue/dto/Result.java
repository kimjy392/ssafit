package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4181277851270015884L;
	
	private int result_id;
	private int member_id;
	private int video_id;
	private int excellent;
	private int great;
	private int good;
	private int bad;
	private String datetime;
	
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(int result_id, int member_id, int video_id, int excellent, int great, int good, int bad,
			String datetime) {
		super();
		this.result_id = result_id;
		this.member_id = member_id;
		this.video_id = video_id;
		this.excellent = excellent;
		this.great = great;
		this.good = good;
		this.bad = bad;
		this.datetime = datetime;
	}

	public Result(int member_id, int video_id, int excellent, int great, int good, int bad) {
		super();
		this.member_id = member_id;
		this.video_id = video_id;
		this.excellent = excellent;
		this.great = great;
		this.good = good;
		this.bad = bad;
	}

	public Result(int excellent, int great, int good, int bad) {
		super();
		this.excellent = excellent;
		this.great = great;
		this.good = good;
		this.bad = bad;
	}

	public int getResult_id() {
		return result_id;
	}

	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public int getExcellent() {
		return excellent;
	}

	public void setExcellent(int excellent) {
		this.excellent = excellent;
	}

	public int getGreat() {
		return great;
	}

	public void setGreat(int great) {
		this.great = great;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Result [result_id=" + result_id + ", member_id=" + member_id + ", video_id=" + video_id + ", excellent="
				+ excellent + ", great=" + great + ", good=" + good + ", bad=" + bad + ", datetime=" + datetime + "]";
	}
	
	

}

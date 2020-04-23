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
	private float accuracy;
	private int point;
	private String datetime;
	
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(int result_id, int member_id, int video_id, float accuracy, int point, String datetime) {
		super();
		this.result_id = result_id;
		this.member_id = member_id;
		this.video_id = video_id;
		this.accuracy = accuracy;
		this.point = point;
		this.datetime = datetime;
	}
	
	

	public Result(int member_id, int video_id, float accuracy, int point, String datetime) {
		super();
		this.member_id = member_id;
		this.video_id = video_id;
		this.accuracy = accuracy;
		this.point = point;
		this.datetime = datetime;
	}

	public Result(int member_id, int video_id, float accuracy, int point) {
		super();
		this.member_id = member_id;
		this.video_id = video_id;
		this.accuracy = accuracy;
		this.point = point;
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

	public float getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
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
		return "Result [result_id=" + result_id + ", member_id=" + member_id + ", video_id=" + video_id + ", accuracy="
				+ accuracy + ", point=" + point + ", datetime=" + datetime + "]";
	}

	
	

}

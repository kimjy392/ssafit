package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class VideoPoint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4632544424095338452L;
	
	
	private int video_id;
	private int first_stop;
	private int second_stop;
	private int excellent;
	private int great;
	private int good;
	
	public VideoPoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoPoint(int video_id, int first_stop, int second_stop, int excellent, int great, int good) {
		super();
		this.video_id = video_id;
		this.first_stop = first_stop;
		this.second_stop = second_stop;
		this.excellent = excellent;
		this.great = great;
		this.good = good;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public int getFirst_stop() {
		return first_stop;
	}

	public void setFirst_stop(int first_stop) {
		this.first_stop = first_stop;
	}

	public int getSecond_stop() {
		return second_stop;
	}

	public void setSecond_stop(int second_stop) {
		this.second_stop = second_stop;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "VideoPoint [video_id=" + video_id + ", first_stop=" + first_stop + ", second_stop=" + second_stop
				+ ", excellent=" + excellent + ", great=" + great + ", good=" + good + "]";
	}

	

}

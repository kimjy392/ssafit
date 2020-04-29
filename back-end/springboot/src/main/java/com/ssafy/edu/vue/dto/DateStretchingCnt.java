package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class DateStretchingCnt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6665817688128318556L;
	
	private int count;
	private String date;
	
	public DateStretchingCnt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateStretchingCnt(int count, String date) {
		super();
		this.count = count;
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DayStretchingCnt [count=" + count + ", date=" + date + "]";
	}

	

}

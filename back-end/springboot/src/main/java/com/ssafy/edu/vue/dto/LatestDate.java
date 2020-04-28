package com.ssafy.edu.vue.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LatestDate implements Serializable, Comparable<LatestDate> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6665817688128318556L;
	
	private int video_id;
	private int memberid;
	private String date;
	
	public LatestDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LatestDate(int video_id, int memberid) {
		super();
		this.video_id = video_id;
		this.memberid = memberid;
	}
	

	public LatestDate(int video_id, String date) {
		super();
		this.video_id = video_id;
		this.date = date;
	}

	public LatestDate(int video_id, int memberid, String date) {
		super();
		this.video_id = video_id;
		this.memberid = memberid;
		this.date = date;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
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
		return "LatestDate [video_id=" + video_id + ", memberid=" + memberid + ", date=" + date + "]";
	}

	@Override
	public int compareTo(LatestDate o) {
		try {
			Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(this.date);
			Date date2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(o.date);
			int compare = date1.compareTo(date2);
			if (compare>0) {
				return -1;
			} else if (compare<0) {
				return 1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return 0;
	}

		

}

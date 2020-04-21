package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1873309448094545080L;
	/**
	 * 
	 */
	

	private int video_id;
	private String title;
	private String file;
	private String thumbnail;
	
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(int video_id, String title, String file, String thumbnail) {
		super();
		this.video_id = video_id;
		this.title = title;
		this.file = file;
		this.thumbnail = thumbnail;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", title=" + title + ", file=" + file + ", thumbnail=" + thumbnail + "]";
	}

	
	

}

package com.ssafy.edu.vue.dto;

import java.io.Serializable;
import java.util.List;

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
	private String description;
	private List<String> part;
	private int time;
	
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Video(int video_id, String title, String file, String thumbnail, String description, List<String> part,
			int time) {
		super();
		this.video_id = video_id;
		this.title = title;
		this.file = file;
		this.thumbnail = thumbnail;
		this.description = description;
		this.part = part;
		this.time = time;
	}

	public Video(int video_id, String title, String file, String thumbnail, String description, int time) {
		super();
		this.video_id = video_id;
		this.title = title;
		this.file = file;
		this.thumbnail = thumbnail;
		this.description = description;
		this.time = time;
	}

	public Video(int video_id, String title, String file, String thumbnail, String description) {
		super();
		this.video_id = video_id;
		this.title = title;
		this.file = file;
		this.thumbnail = thumbnail;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getPart() {
		return part;
	}

	public void setPart(List<String> part) {
		this.part = part;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", title=" + title + ", file=" + file + ", thumbnail=" + thumbnail
				+ ", description=" + description + ", part=" + part + "]";
	}

	
	
	
	

}

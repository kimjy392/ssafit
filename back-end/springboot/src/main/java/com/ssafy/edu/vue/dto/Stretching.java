package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class Stretching implements Serializable {

	private static final long serialVersionUID = 471758301426159730L;

	private int stretching_id;
	private int part_id;
	private String title;
	private String file;
	
	public Stretching() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stretching(int stretching_id, int part_id, String title, String file) {
		super();
		this.stretching_id = stretching_id;
		this.part_id = part_id;
		this.title = title;
		this.file = file;
	}

	public Stretching(String title, String file) {
		super();
		this.title = title;
		this.file = file;
	}

	public int getStretching_id() {
		return stretching_id;
	}

	public void setStretching_id(int stretching_id) {
		this.stretching_id = stretching_id;
	}

	public int getPart_id() {
		return part_id;
	}

	public void setPart_id(int part_id) {
		this.part_id = part_id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Stretching [stretching_id=" + stretching_id + ", part_id=" + part_id + ", title=" + title + ", file="
				+ file + "]";
	}

	

}

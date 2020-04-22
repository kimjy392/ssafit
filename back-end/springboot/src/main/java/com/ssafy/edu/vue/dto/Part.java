package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class Part implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9019837063240927463L;
	/**
	 * 
	 */
	

	private int part_id;
	private String name;
	
	public Part() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Part(int part_id, String name) {
		super();
		this.part_id = part_id;
		this.name = name;
	}

	public int getPart_id() {
		return part_id;
	}

	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Part [part_id=" + part_id + ", name=" + name + "]";
	}

	

}

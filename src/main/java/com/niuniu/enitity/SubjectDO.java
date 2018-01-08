package com.niuniu.enitity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class SubjectDO implements Serializable {

	private static final long serialVersionUID = -5051607588689973114L;

	private Integer id;
	
	private String name;
	
	private Integer status;
	
	private Integer courseCount;
	
	private Integer videoCount;
	
	private Timestamp gmtCreate;
	
	private Timestamp gmtModified;
	
	public SubjectDO() {
		super();
	}

	public SubjectDO(Integer id, String name, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
	

	


	public SubjectDO(Integer id, String name, Timestamp gmtCreate) {
		super();
		this.id = id;
		this.name = name;
		this.gmtCreate = gmtCreate;
	}

	

	public SubjectDO(Integer id, String name, Integer status, Integer courseCount, Integer videoCount,
			Timestamp gmtCreate, Timestamp gmtModified) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.courseCount = courseCount;
		this.videoCount = videoCount;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
	}

	

	@Override
	public String toString() {
		return "SubjectDO [id=" + id + ", name=" + name + ", status=" + status + ", courseCount=" + courseCount
				+ ", videoCount=" + videoCount + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	

	public Timestamp getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Timestamp getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Timestamp gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCourseCount() {
		return courseCount;
	}

	public void setCourseCount(Integer courseCount) {
		this.courseCount = courseCount;
	}

	public Integer getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(Integer videoCount) {
		this.videoCount = videoCount;
	}
}

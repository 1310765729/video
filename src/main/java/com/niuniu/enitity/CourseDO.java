package com.niuniu.enitity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class CourseDO implements Serializable {

	private static final long serialVersionUID = -9039877972371453963L;

	private Integer id;
	
	private String name;

	private String describe;
	
	private Integer subjectId;
	
	private String subjectName;
	
	private Integer status;

	private SubjectDO subject;
	
	private Date createTime;
	
	

	
	
	

	


	@Override
	public String toString() {
		return "CourseDO [id=" + id + ", name=" + name + ", describe=" + describe + ", subjectId=" + subjectId
				+ ", subjectName=" + subjectName + ", status=" + status + ", subject=" + subject + ", createTime="
				+ createTime + "]";
	}



	public CourseDO() {
		super();
	}



	public CourseDO(Integer id, String name, String describe, Integer subjectId, Integer status, SubjectDO subject,
			Timestamp createTime) {
		super();
		this.id = id;
		this.name = name;
		this.describe = describe;
		this.subjectId = subjectId;
		this.status = status;
		this.subject = subject;
		this.createTime = createTime;
	}



	

	
	

	public String getSubjectName() {
		return subjectName;
	}



	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}



	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public SubjectDO getSubject() {
		return subject;
	}

	public void setSubject(SubjectDO subject) {
		this.subject = subject;
	}
}

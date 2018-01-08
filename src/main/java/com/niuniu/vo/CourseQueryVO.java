package com.niuniu.vo;

public class CourseQueryVO extends QueryVO{
	private Integer subjectId;

	@Override
	public String toString() {
		return "CourseQueryVO [subjectId=" + subjectId + "]";
	}

	public CourseQueryVO() {
		super();
	}

	public CourseQueryVO(Integer subjectId) {
		super();
		this.subjectId = subjectId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	
	
}

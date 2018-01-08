package com.niuniu.vo;

public class VideoQueryVO extends QueryVO{
	private Integer courseId;
	private Integer speakerId;
	private Integer videoId;
	@Override
	public String toString() {
		return "VideoQueryVO [courseId=" + courseId + ", speakerId=" + speakerId + "]";
	}
	
	public VideoQueryVO() {
		super();
	}

	public VideoQueryVO(Integer courseId, Integer speakerId) {
		super();
		this.courseId = courseId;
		this.speakerId = speakerId;
	}
	
	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(Integer speakerId) {
		this.speakerId = speakerId;
	}
	
	

}

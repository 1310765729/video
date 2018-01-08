package com.niuniu.dao;

import com.niuniu.enitity.VideoDO;

public interface VideoDao extends BaseDao<VideoDO> {
	void updateCourseIdNull(String[] courseIds);
	
	void updateSpeakerIdNull(String[] speakerIds);
	
	
}

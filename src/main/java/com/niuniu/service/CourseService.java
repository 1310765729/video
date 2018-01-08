package com.niuniu.service;

import com.niuniu.enitity.CourseDO;

public interface CourseService extends BaseService<CourseDO> {
	void removeSome(String[] idArray);
}

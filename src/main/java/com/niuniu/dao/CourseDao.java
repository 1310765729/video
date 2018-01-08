package com.niuniu.dao;

import com.niuniu.enitity.CourseDO;

public interface CourseDao extends BaseDao<CourseDO> {
	void updateSubjectIdNull(String[] subjectIds);
}

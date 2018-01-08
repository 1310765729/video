package com.niuniu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niuniu.dao.CourseDao;
import com.niuniu.dao.VideoDao;
import com.niuniu.enitity.CourseDO;
import com.niuniu.service.CourseService;
@Service
public class CourseServiceImpl extends BaseServiceImpl<CourseDO,CourseDao> implements CourseService {

	
	

	@Autowired
	private VideoDao videoDao;
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public void removeObject(String ids[]) {
		
		// 删除课程
		super.removeObject(ids);
		
		// 置空视频中的 course_id
		videoDao.updateCourseIdNull(ids);
	}

	public CourseDO getById(int id) {
		
		return courseDao.getById(id);
	}

	public void delete(int id) {
		courseDao.delete(id);
		
	}

	public void removeSome(String[] id) {
		courseDao.removeObject(id);
		
	}

	

	
	

	
	
}

package com.niuniu.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niuniu.dao.CourseDao;
import com.niuniu.dao.SubjectDao;
import com.niuniu.enitity.SubjectDO;
import com.niuniu.service.SubjectService;
@Service
public class SubjectServiceImpl extends BaseServiceImpl<SubjectDO, SubjectDao> implements SubjectService {

	
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private SubjectDao subjectDao;
	
	@Override
	public void removeObject(String ids[]) {

		// 删除学科
		super.removeObject(ids);
		
		// 置空课程表中的 subject_id
		courseDao.updateSubjectIdNull(ids);
	}

	public SubjectDO getById(int id) {
		
		return subjectDao.getById(id);
	}

	public void delete(int id) {
		subjectDao.delete(id);
		
		
	}

	public void removeSome(String[] id) {
		subjectDao.removeObject(id);
		
	}

	

	

	

	
}

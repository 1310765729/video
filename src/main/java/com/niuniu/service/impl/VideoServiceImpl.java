package com.niuniu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niuniu.dao.VideoDao;
import com.niuniu.enitity.VideoDO;
import com.niuniu.service.VideoService;
@Service
public class VideoServiceImpl extends BaseServiceImpl<VideoDO, VideoDao> implements VideoService {
	
	@Autowired
	private VideoDao videoDao;
	public VideoDO getById(int id) {
		System.out.println(videoDao.getById(id));
		return videoDao.getById(id);
	}
	public void delete(int id) {
		videoDao.delete(id);
		
	}
	public void removeSome(String[] id) {
		videoDao.removeObject(id);
		
	}

	
	
	

	

}

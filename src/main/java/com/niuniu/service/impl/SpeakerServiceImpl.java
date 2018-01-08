package com.niuniu.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niuniu.dao.SpeakerDao;
import com.niuniu.dao.VideoDao;
import com.niuniu.enitity.SpeakerDO;
import com.niuniu.service.SpeakerService;
@Service
public class SpeakerServiceImpl extends BaseServiceImpl<SpeakerDO,SpeakerDao> implements SpeakerService {

	
	@Autowired
	private VideoDao videoDao;
	@Autowired
	private SpeakerDao speakerDao;
	@Override
	public void removeObject(String ids[]) {
		
		// 删除讲师信息
		super.removeObject(ids);
		
		// 置空视频表中的 speaker_id
		videoDao.updateSpeakerIdNull(ids);
	}

	public SpeakerDO getById(int id) {
		return speakerDao.getById(id);
	}

	public void delete(int id) {
		speakerDao.delete(id);
		
	}

	public void removeSome(String[] id) {
		speakerDao.removeObject(id);
		
	}

	

	


	

}

package com.niuniu.service;

import com.niuniu.enitity.SpeakerDO;

public interface SpeakerService extends BaseService<SpeakerDO> {
	void removeSome(String[] idArray);
}

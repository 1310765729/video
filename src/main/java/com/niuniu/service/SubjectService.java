package com.niuniu.service;

import com.niuniu.enitity.SubjectDO;

public interface SubjectService extends BaseService<SubjectDO> {

	void removeSome(String[] idArray);

}

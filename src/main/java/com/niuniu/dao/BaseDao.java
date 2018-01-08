package com.niuniu.dao;

import java.util.List;

import com.niuniu.enitity.VideoDO;
import com.niuniu.vo.QueryVO;

public interface BaseDao<T> {
	List<T> listObject();
	
	List<T> listObjectByQuery(QueryVO queryVO);
	
	T getById(int id);
	
	int countObjectByQuery(QueryVO queryVO);
	
	void insertObject(T object);
	
	void updateObject(T object);
	
	void removeObject(String[] ids);
	
	void delete(int id);
	
	
	
}

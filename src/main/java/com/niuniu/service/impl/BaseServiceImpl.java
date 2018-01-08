package com.niuniu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.niuniu.dao.BaseDao;
import com.niuniu.dto.BaseListDTO;
import com.niuniu.enitity.CourseDO;
import com.niuniu.service.BaseService;
import com.niuniu.vo.QueryVO;

public abstract class BaseServiceImpl<T,D extends BaseDao<T>> implements BaseService<T> {
	@Autowired
	private D dao;
	public List<T> listObject(){
		return dao.listObject();
		
	}
	public BaseListDTO<T> listObject(QueryVO queryVO){
		BaseListDTO<T> dto=new BaseListDTO<T>();
		
		int count=dao.countObjectByQuery(queryVO);
		dto.setCount(count);
		
		if(count!=0){
			
			if(queryVO.getOffset()<0){
				queryVO.setOffset(0);
			}else{
				int lastOffset=(count/queryVO.getLimit())*queryVO.getLimit();
				if(queryVO.getOffset()>lastOffset){
					queryVO.setOffset(lastOffset);
					
				}
			}
			List<T> rows=dao.listObjectByQuery(queryVO);
			dto.setRows(rows);
			
		}
		
		return dto;
	}

	public void insertObject(T object) {

		dao.insertObject(object);
	}

	public void removeObject(String ids[]) {
				
		dao.removeObject(ids);
	}

	public void updateObject(T object) {
		
		dao.updateObject(object);
	}
	
	
	
	
	
	
	
	
}

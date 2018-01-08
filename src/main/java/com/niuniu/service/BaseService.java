package com.niuniu.service;

import java.util.List;

import com.niuniu.dto.BaseListDTO;
import com.niuniu.enitity.VideoDO;
import com.niuniu.vo.QueryVO;

public interface BaseService<T> {
		List<T> listObject();
	//查询全部,可以是根据搜索框搜索,也可以查询全部,可以排序
		BaseListDTO<T> listObject(QueryVO queryVO);
		//int countObject(QueryVO queryVO);
		//获取单个video
		//T getVideo(VideoListQueryVO queryVO);
		//增加
		T getById(int id);
		void insertObject(T object);
		void removeObject(String[] ids);
		//修改
		void updateObject(T object);
		
		void delete(int id);
		
		
		
}

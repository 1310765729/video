package com.niuniu.dto;

import java.util.List;


public class BaseListDTO<T> {
	private Integer count;
	
	private List<T> rows;

	

	@Override
	public String toString() {
		return "VideoListDTO [count=" + count + ", rows=" + rows + "]";
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	

	
	
}

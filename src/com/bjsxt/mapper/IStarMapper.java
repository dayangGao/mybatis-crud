package com.bjsxt.mapper;

import com.bjsxt.pojo.Star;

import java.util.List;

public interface IStarMapper {
	//新增,获取刚插入的记录的id
	void getInsertId(Star star);


	//新增
	void insertStar(Star star);
	

	//删除
	void deleteStarById(Integer id);
	
	//更新
	void updateStarById(Star star);
	
	//查询所有
	List<Star> selectAllStars();
	
	//根据OID查询对应对象
	Star selectStarById(Integer id);
	
	//模糊查询
	List<Star> selectByName(String name);
}

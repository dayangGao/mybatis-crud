package com.bjsxt.test;

import com.bjsxt.mapper.IStarMapper;
import com.bjsxt.mapper.impl.StarMapperImpl;
import com.bjsxt.pojo.Star;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StarTest {
	private IStarMapper starMapper;
	@Before //加上该注解方法会在@Test方法执行之前执行
	public void before(){
		starMapper = new StarMapperImpl();
	}
	@Test
	public void save(){
		Star star = new Star("xiaolin", 20, 99.8);
		System.out.println(star);
		starMapper.insertStar(star);
		System.out.println(star);
	}
	@Test
	public void getInsertId(){
		Star star = new Star("白居易", 20, 99.8);
		System.out.println("======\t"+star);
		starMapper.getInsertId(star);
		System.out.println(star);
	}
	@Test
	public void delete(){
		starMapper.deleteStarById(12);
	}
	@Test
	public void update(){
		final Star star = new Star("刘昊然", 22, 99.9);
		star.setId(13);
		starMapper.updateStarById(star);
	}
	@Test
	public void selectAllStars(){
		List<Star> stars = starMapper.selectAllStars();
		for (Star star : stars) {
			System.out.println(star);
		}
	}
	@Test
	public void selectStarById(){
		final Star star = starMapper.selectStarById(13);
		System.out.println(star);
	}
	@Test
	public void selectByName(){
		List<Star> stars = starMapper.selectByName("刘");
		for (Star star : stars) {
			
			System.out.println(star);
		}
	}
}

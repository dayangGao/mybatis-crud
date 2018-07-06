package com.bjsxt.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSession sqlSession;
	private static SqlSessionFactory sqlSessionFactory;

	//获取SQLSession对象
	public static  SqlSession getSqlSession(){
		try {
			//1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
			if (sqlSessionFactory==null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

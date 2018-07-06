package com.bjsxt.mapper.impl;

import com.bjsxt.mapper.IStarMapper;
import com.bjsxt.pojo.Star;
import com.bjsxt.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StarMapperImpl implements IStarMapper {
    @Override
    public void getInsertId(Star star) {
        //1.获取SQLSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        if (sqlSession != null) {
            //2.操作数据
            int aa = sqlSession.insert("getInsertId", star);
            System.out.println("----->\t" + aa);
            //3.提交事务
            sqlSession.commit();
            //4.关闭SQLSession
            sqlSession.close();
        }
    }

    private List<Star> stars;
    private Star star;

    //新增
    @Override
    public void insertStar(Star star) {
        //1.获取SQLSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        if (sqlSession != null) {
            //2.操作数据
            sqlSession.insert("test.insertStar", star);
            //3.提交事务
            sqlSession.commit();
            //4.关闭SQLSession
            sqlSession.close();
        }
    }

    //删除
    @Override
    public void deleteStarById(Integer id) {
        //1.获取SQLSession对象
        final SqlSession sqlSession = MybatisUtil.getSqlSession();
        if (sqlSession != null) {
            //2.操作数据
            sqlSession.delete("deleteStarById", id);
            //3.提交事务
            sqlSession.commit();
            //4.关闭SQLSession
            sqlSession.close();
        }
    }

    //更新
    @Override
    public void updateStarById(Star star) {
        //1.获取SQLSession对象
        final SqlSession sqlSession = MybatisUtil.getSqlSession();
        if (sqlSession != null) {
            //2.操作数据
            sqlSession.update("updateStar", star);
            //3.提交事务
            sqlSession.commit();
            //4.关闭SQLSession
            sqlSession.close();
        }
    }

    //查询所有

    @Override
    public List<Star> selectAllStars() {
        //1.获取SQLSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        if (sqlSession != null) {
            stars = sqlSession.selectList("selectAllStars");
            //3.提交事务
            sqlSession.commit();
            //4.关闭SQLSession
            sqlSession.close();
        }
        return stars;
    }

    //根据OID查询对应对象
    @Override
    public Star selectStarById(Integer id) {
        //1.获取SQLSession对象
        final SqlSession sqlSession = MybatisUtil.getSqlSession();
        if (sqlSession != null) {
            star = sqlSession.selectOne("selectStarById", id);
            //3.提交事务
            sqlSession.commit();
            //4.关闭SQLSession
            sqlSession.close();
        }
        return star;
    }

    //模糊查询
    @Override
    public List<Star> selectByName(String name) {
        //1.获取SQLSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        if (sqlSession != null) {
            stars = sqlSession.selectList("selectByName", name);
            //3.提交事务
            sqlSession.commit();
            //4.关闭SQLSession
            sqlSession.close();
        }
        return stars;
    }

    //新增,获取刚插入的记录的id

}

package com.zjgt.p2p.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zjgt.p2p.article.dao.ArticleMapper;
 

/**
 * @FileName:ArticleServiceImpl.java
 * @Function:TODO
 * @date:2014年12月17日 下午2:30:17
 * @author zhouyi
 * @since jdk1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:applicationContext-mybatis.xml" })
public class ArticleTest {

	 @Autowired
	 private ArticleMapper articleMapper;
 
//	@Test
	public void articleTest() {
		System.out.println("aaaaaaaaaaa"+Math.round(Math.random()*1000000)+"aaaaaaaa");
	}

}

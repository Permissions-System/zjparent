package com.zjgt.p2p.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zjgt.p2p.report.model.MsgInfo;
import com.zjgt.p2p.report.model.Msglog; 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:applicationContext-mybatis.xml" ,"classpath:spring.xml" })
public class sendMessagesTest {
	
	/*@Autowired
	private SendMessagesService sendMessagesService;
	
	@Test
	public void add(){
		try{
			System.out.println("strat");
			MsgInfo msgInfo = new MsgInfo ();
			msgInfo.setStatus(2);
			msgInfo.setType(1);
			msgInfo.setMsgtype(2);
			msgInfo.setSenddate(new Date());
			msgInfo.setServtype(1);
			msgInfo.setServno("123456");
			msgInfo.setServdesc("111");
			msgInfo.setTitle("msg title");
			msgInfo.setMobile("13816947328");
			msgInfo.setUsername("kaiyun");
			msgInfo.setUserid(100L);
			msgInfo.setCreatedate(new Date());
			msgInfo.setContent("msg content");
			sendMessagesService.insertMessagesInfo(msgInfo);
			
			Msglog msgLog = new Msglog();
			msgLog.setStatus(2);
			msgLog.setType(1);
			msgLog.setMsgtype(2);
			msgLog.setSenddate(new Date());
			msgLog.setServtype(1);
			msgLog.setServno("123456");
			msgLog.setServdesc("111");
			msgLog.setTitle("msg title");
			msgLog.setMobile("13816947328");
			msgLog.setUsername("kaiyun");
			msgLog.setUserid(100L);
			msgLog.setCreatedate(new Date());
			msgLog.setContent("msg content");
			sendMessagesService.insertMessagesLog(msgLog);
			System.out.println("end");
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
}


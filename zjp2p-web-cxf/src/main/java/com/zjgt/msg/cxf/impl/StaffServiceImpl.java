package com.zjgt.msg.cxf.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zjgt.msg.cxf.StaffServive;
import com.zjgt.p2p.base.domain.Staff;
import com.zjgt.p2p.base.service.IStaffAccountService;

/**
 * @author tfj
 * 2015年1月7日
 * WS 接口实现
 */
@Component
@WebService//(endpointInterface = "com.zjgt.sms.service.StaffServive",serviceName="StaffServive")
public class StaffServiceImpl implements StaffServive{

	@Autowired
	private IStaffAccountService staffAccountService;
	
	@Override
	public String selectByChannelCode(String ChannelCode)
	{
		return staffAccountService.selectByChannelCode(ChannelCode).getName();
		//return null;
	}


}
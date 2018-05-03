package com.zjgt.msg.cxf.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zjgt.msg.cxf.StaffLoginServive;
import com.zjgt.p2p.base.domain.Staff;
import com.zjgt.p2p.base.service.IStaffAccountService;

/**
 * @author tfj
 * 2015年1月7日
 * WS 接口实现
 */
@Component
@WebService
public class StaffLoginServiceImpl implements StaffLoginServive{

	@Autowired
	private IStaffAccountService staffAccountService;

	@Override
	public String isStaffLogin(String identNo, String pwd)
	{
		String jsonStr = null;
		Map<String, String> resultMap = new HashMap<String, String>();
		
		//0登入成功、1用户名为空、2密码为空、3用户名错误、4密码错误
		resultMap = staffAccountService.selectByIdentNoAndPwd(identNo, pwd);
		
        jsonStr = JSONObject.fromObject(resultMap).toString();
        //System.out.println("jsonObject2：" + jsonStr);
		
		return jsonStr ;
		
	}
	


}
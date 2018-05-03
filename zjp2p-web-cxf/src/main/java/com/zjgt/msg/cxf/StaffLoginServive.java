package com.zjgt.msg.cxf;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.zjgt.p2p.base.domain.Staff;

/**
 * @author tfj
 * 2015年1月7日
 * WS 接口:根据用户名、密码检索商户是否登入
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface StaffLoginServive 
{
	public String isStaffLogin(@WebParam(name = "identNo") String identNo,@WebParam(name = "pwd") String pwd);
}



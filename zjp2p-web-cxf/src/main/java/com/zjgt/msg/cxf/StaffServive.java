package com.zjgt.msg.cxf;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.zjgt.p2p.base.domain.Staff;

/**
 * @author tfj
 * 2015年1月7日
 * WS 接口
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface StaffServive {
	public String selectByChannelCode(@WebParam(name = "ChannelCode") String ChannelCode);
}



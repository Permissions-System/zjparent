package com.zjgt.p2p.fuyou;

import java.util.List;

import com.fuiou.data.QueryCzTxReq;
import com.fuiou.data.QueryCzTxRspData;
import com.fuiou.data.QueryCzTxRspDetailData;
import com.fuiou.data.QueryTxnReqData;
import com.fuiou.data.QueryTxnRspData;
import com.fuiou.service.FuiouService;

public class FuYouTest
{

	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		FuiouService fuiouService = new FuiouService();
		
		String mchnt_cd = "0002900F0339996"; //商户代码
		String mchnt_txn_ssn = "91032ASD068843809999";//流水号
		String busi_tp = "PW11";//交易类型 PW11 充值, PWTX 提现
		String start_time = "2015-10-08 00:00:00";//起始时间
		String end_time = "2015-10-08 23:59:59";//截止时间
		
		String cust_no = "15192005123";//用户
		String page_no = "1";//页码(默认为1)
		String page_size = "10";//每页条数(默认值:10;最大值:100;)
		String txn_st = "1";//交易状态（1 交易成功2 交易失败）
		String signature = busi_tp+"|"+cust_no+"|"+end_time+"|"+mchnt_cd+"|"+mchnt_txn_ssn+"|"+page_no+"|"+page_size+"|"+start_time+"|"+txn_st ;//签名数据
				
		//QueryTxnReqData:请求参数列表
		QueryCzTxReq queryCzTxReq = new QueryCzTxReq();
		queryCzTxReq.setMchnt_cd(mchnt_cd);				//(M)富友分配给各合作商户的唯一识别码
		queryCzTxReq.setMchnt_txn_ssn(mchnt_txn_ssn);	//(M)商户网站产生的一个唯一的流水号，该流水号应该在相当长的时间内不重复。富友通过流水号来唯一确认一笔交易的重复性。
		queryCzTxReq.setBusi_tp(busi_tp);		    	//(M)PW11 充值, PWTX 提现
		queryCzTxReq.setStart_time(start_time);			//(M)起始充值完成时间 格式：yyyy-MM-dd HH:mm:ss
		queryCzTxReq.setEnd_time(end_time);				//(M)截止充值完成时间 格式：yyyy-MM-dd HH:mm:ss
		queryCzTxReq.setSignature(signature);			//(M)按参数名字母排序后的值用“|”线连接起来的明文，然后用rsa签名的值(签名明文：busi_tp+"|"+cust_no+"|"+end_time+"|"+mchnt_cd+"|"+mchnt_txn_ssn+"|"+page_no+"|"+page_size+"|"+start_time+"|"+txn_st)
		queryCzTxReq.setCust_no(cust_no);
		queryCzTxReq.setPage_no(page_no);
		queryCzTxReq.setPage_size(page_size);
		queryCzTxReq.setTxn_st(txn_st);		
		
		try
		{
			//充值提现查询接口 接口请求方法: FuiouService.querycztx
			QueryCzTxRspData rsp = fuiouService.querycztx(queryCzTxReq);
			
			String rspCode = rsp.getResp_code();//获取相应状态码
			
			System.out.println(rsp.getTotal_number());//获取总记录数
			
			/*List<QueryCzTxRspDetailData> rspList = rsp.getResults();
			System.out.println(
					
					"响应码"+"\t"+
					"商户代码"+"\t"+
					"流水号"+"\t"+
					"总记录数"+"\t"+
					"充值提现日期"+"\t"+
					"充值提现时分"+"\t"+
					"充值提现流水"+"\t"+
					"充值提现金额"+"\t"+
					"用户名用"+"\t"+
					"用户名称"+"\t"+
					"返回码"+"\t"+
					"返回码描述"
						
			);
			for(QueryCzTxRspDetailData rspObj : rspList)
			{
			}*/
			/*响应码	resp_code
			商户代码	mchnt_cd
			流水号	mchnt_txn_ssn
			业务类型	busi_tp
			总记录数	total_number
			扩展类型	ext_tp
			充值提现日期	txn_date
			充值提现时分	txn_time
			充值提现流水	mchnt_ssn
			充值提现金额	txn_amt
			用户虚拟账户	fuiou_acct_no
			用户名用	cust_no
			用户名称	artif_nm
			备注	remark
			返回码	txn_rsp_cd
			返回码描述	rsp_cd_desc
			签名数据	signature*/

			System.out.println(rspCode);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}

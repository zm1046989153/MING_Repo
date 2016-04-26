package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @Description:确认收获哦接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-26 14:51:00
 */
public class ConfirmReceive {
	/*
	 * @Descrption:确认收货接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_SALE_CONFIRMRECEIVE
	 *        ctmUsrKey 用户ID
	 *        billCodes 订单号
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-26 14:52:00
	 * @Update History:无
	 */
	public Document confirmReceive(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
			String billCodes)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("billCodes",billCodes);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 * @Description:获取订单详情接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-18 9:50:00
 */
public class GetOrdText {
	/*
	 * @Descrption:获取订单详情接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_SALE_GETORDTEXT
	 *        ctmUsrKey 用户ID
	 *        billCode 订单号
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-18 9:50:00
	 * @Update History:无
	 */
	public Document getOrdText(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
			String billCode)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("billCode",billCode);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @Description:获取支付地址接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-20 15:10:00
 */
public class GetPayUrl {
	/*
	 * @Descrption:获取支付地址接口
	 * @Param:URL标签
	 *        access_token
	 *        ctmUsrKey 用户ID
	 *        billCodeJson 订单编码
	 *        paymentWayCode 支付方式编码
	 *        paymentTypeCode 支付类型编码
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-20 15:10:00
	 * @Update History:无
	 */
	public Document getPayUrl(String URL,
			String access_token,
			String ctmUsrKey,
			String billCodeJson,
			String paymentWayCode,
			String paymentTypeCode)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("billCodeJson",billCodeJson);
			conn.data("paymentWayCode",paymentWayCode);
			conn.data("paymentTypeCode",paymentTypeCode);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

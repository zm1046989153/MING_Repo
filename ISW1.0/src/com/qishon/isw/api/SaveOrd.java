package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 * @Description:提交订单数据接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-19 13:15:00
 */
public class SaveOrd {
	/*
	 * @Descrption:提交订单数据接口
	 * @Param:URL标签
	 *        interfaceCode SP_SALE_SAVEORD
	 *        ctmUsrKey 用户ID
	 *        sourceCode 来源
	 *        masCartTempHdKey 购物车中间表ID
	 *        shipPingKey 配送方式ID
	 *        receiptWayCode 收货方式
	 *        addressKey 地址KEY
	 *        masPartDtSkuKey SKUID
	 *        qty 数量
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-19 13:16:00
	 * @Update History:2016-04-25 9:24:00
	 */
	public Document saveOrd(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
			String sourceCode,
			String masCartTempHdKey,
			String shipPingKey,
			String receiptWayCode,
			String addressKey,
			String masPartDtSkuKey,
			String qty)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("sourceCode",sourceCode);
			conn.data("masCartTempHdKey",masCartTempHdKey);
			conn.data("shipPingKey",shipPingKey);
			conn.data("receiptWayCode",receiptWayCode);	
			conn.data("addressKey",addressKey);
			conn.data("masPartDtSkuKey",masPartDtSkuKey);
			conn.data("qty",qty);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

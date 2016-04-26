package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 * @Description:提交结算接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-25 17:48:00
 */
public class SaveCartTemp {
	/*
	 * @Descrption:提交结算接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_SAVECARTTEMP
	 *        ctmUsrKey 用户ID
	 *        cartKeys 购物车key，直接购买时传空
	 *        masPartDtSkuKey SKUID
	 *        amount 数量
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-25 17:48:00
	 * @Update History:无
	 */
	public Document saveCartTemp(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
		    String cartKeys,
		    String masPartDtSkuKey,
		    String amount)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("cartKeys",cartKeys);
			conn.data("masPartDtSkuKey",masPartDtSkuKey);
			conn.data("amount",amount);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

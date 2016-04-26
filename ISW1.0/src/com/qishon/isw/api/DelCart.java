package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @Description:删除购物车接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-26 10:15:00
 */
public class DelCart {
	/*
	 * @Descrption:删除购物车接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_DELCART
	 *        ctmUsrKey 用户ID
	 *        cartKeys 购物车key
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-26 10:15:00
	 * @Update History:无
	 */
	public Document delCart(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
			String cartKeys)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("cartKeys",cartKeys);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

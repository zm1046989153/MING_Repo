package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @Description:查询购物车列表接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-25 15:12:00
 */
public class GetCartList {
	/*
	 * @Descrption:查询购物车列表接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_GETCARTLIST
	 *        ctmUsrKey 用户ID
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-25 15:12:00
	 * @Update History:无
	 */
	public Document getCartList(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

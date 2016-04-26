package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 * @Description:获取结算页面信息接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-25 18:00:00
 */
public class GetCartTemp {
	/*
	 * @Descrption:获取结算页面信息接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_GETCARTTEMP
	 *        ctmUsrKey 用户ID
	 *        cartKeys 购物车key，直接购买时传空
	 *        masCartTempHdKey 购物车中间表ID
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-25 18:00:00
	 * @Update History:无
	 */
	public Document getCartTemp(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
		    String masCartTempHdKey)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("masCartTempHdKey",masCartTempHdKey);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

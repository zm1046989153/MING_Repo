package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @Description:获取配送方式接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-20 9:53:00
 */
public class GetShipping {
	/*
	 * @Descrption:获取配送方式接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_STM_GETSHIPPING
	 *        ctmUsrKey 用户ID
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-20 9:54:00
	 * @Update History:无
	 */
	public Document getShipping(String URL,
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

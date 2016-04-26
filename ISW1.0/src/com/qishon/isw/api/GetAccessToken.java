package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @Description:授权码接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-12 13:28:00
 */
public class GetAccessToken {
	/*
	 * @Descrption:获取授权码接口
	 * @Param:URL标签
	 *        clientId 客户端的key
	 *        requestTime 客户端的请求时间
	 *        chksum 加密后的字段串
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-12 13:28:00
	 * @Update History:无
	 */
	public Document getAccessToken(String URL,String clientId,String requestTime,String chksum)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("clientId",clientId);
			conn.data("requestTime",requestTime);
			conn.data("chksum",chksum);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

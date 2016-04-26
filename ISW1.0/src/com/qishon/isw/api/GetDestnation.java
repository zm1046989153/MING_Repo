package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @Description:获取地区信息接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-20 10:17:00
 */
public class GetDestnation {
	/*
	 * @Descrption:获取地区信息接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_STM_GETDESTNATION
	 *        ctmUsrKey 用户ID
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-20 10:17:00
	 * @Update History:无
	 */
	public Document getDestnation(String URL,
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

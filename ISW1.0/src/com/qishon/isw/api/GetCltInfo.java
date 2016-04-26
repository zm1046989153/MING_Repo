package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 * @Description:获取收藏夹信息接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-13 18:44:00
 */
public class GetCltInfo {
	/*
	 * @Descrption:获取收藏夹信息接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_GETCLTINFO
	 *        ctmUsrKey 用户ID
	 *        cltTypeCode 收藏类型:店铺,商品,不传为获取全部
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-13 18:44:00
	 * @Update History:无
	 */
	public Document getCltInfo(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
		    String cltTypeCode)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("cltTypeCode",cltTypeCode);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

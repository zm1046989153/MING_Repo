package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 * @Description:保存收藏夹信息接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-12 19:35:00
 */
public class SaveCltInfo {
	/*
	 * @Descrption:保存收藏夹信息接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_SAVECLTINFO
	 *        ctmUsrKey 用户ID
	 *        partCode 商品货号
	 *        cltTypeCode 收藏类型:店铺,商品
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-12 19:50:00
	 * @Update History:无
	 */
	public Document saveCltInfo(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
		    String partCode,
		    String cltTypeCode)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("partCode",partCode);
			conn.data("cltTypeCode",cltTypeCode);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

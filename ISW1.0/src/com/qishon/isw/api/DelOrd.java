package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 * @Description:取消/删除/还原订单接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-19 14:14:00
 */
public class DelOrd {
	/*
	 * @Descrption:取消/删除/还原订单接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_SALE_DELORD
	 *        ctmUsrKey 用户ID
	 *        billCode 订单编号
	 *        flag 取消/删除/还原标示 1: 取消，2：删除,3:还原
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-19 17:18:00
	 * @Update History:无
	 */
	public Document delOrd(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
		    String billCode,
		    String flag)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("billCode",billCode);
			conn.data("flag",flag);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @Description:获取订单列表接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-12 19:35:00
 */
public class GetOrdList {
	/*
	 * @Descrption:获取订单列表接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_SALE_GETORDLIST
	 *        ctmUsrKey 用户ID
	 *        searchCode 订单状态
	 *        orderTypeCode 订单类型
	 *        pageSize 条数
	 *        pageNo 查询页
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-12 19:50:00
	 * @Update History:2016-04-25 10:29:00
	 */
	public Document getOrdList(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
			String searchCode,
			String orderTypeCode,
			String pageSize,
			String pageNo)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("searchCode",searchCode);
			conn.data("orderTypeCode",orderTypeCode);
			conn.data("pageSize",pageSize);
			conn.data("pageNo",pageNo);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

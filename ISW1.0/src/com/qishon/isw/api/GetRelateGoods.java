package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 * @Description:获取商品的关联购买商品接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-26 14:57:00
 */
public class GetRelateGoods {
	/*
	 * @Descrption:获取商品的关联购买商品接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_SALE_GETRELATEGOODS
	 *        ctmUsrKey 用户ID
	 *        goodsCode 商品货号
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-26 14:58:00
	 * @Update History:无
	 */
	public Document getRelateGoods(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
			String goodsCode)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("goodsCode",goodsCode);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

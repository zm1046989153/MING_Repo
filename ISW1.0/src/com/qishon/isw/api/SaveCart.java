package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 * @Description:保存和更新购物车信息接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-25 15:27:00
 */
public class SaveCart {
	/*
	 * @Descrption:保存和更新购物车信息接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_SAVECART
	 *        ctmUsrKey 用户ID
	 *        cartKey 修改时需传购物车key,保存时为空
	 *        goodsCode 平台商品编码
	 *        masPartDtSkuKey SKUID
	 *        amount 数量
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-25 15:29:00
	 * @Update History:无
	 */
	public Document saveCart(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
			String cartKey,
		    String goodsCode,
		    String masPartDtSkuKey,
		    String amount)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("cartKey",cartKey);
			conn.data("goodsCode",goodsCode);
			conn.data("masPartDtSkuKey",masPartDtSkuKey);
			conn.data("amount",amount);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

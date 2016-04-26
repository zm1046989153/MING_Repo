package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @Description:提交商品咨询接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-20 11:24:00
 */
public class SaveGoodsConsult {
	/*
	 * @Descrption:提交商品咨询接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_CSM_SAVEGOODSCONSULT
	 *        ctmUsrKey 用户ID
	 *        goodsCode 平台商品编码
	 *        conSultInfo 咨询内容
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-20 11:24:00
	 * @Update History:无
	 */
	public Document saveGoodsConsult(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
			String goodsCode,
			String conSultInfo)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("goodsCode",goodsCode);
			conn.data("conSultInfo",conSultInfo);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

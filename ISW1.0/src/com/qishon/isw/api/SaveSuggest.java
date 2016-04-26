package com.qishon.isw.api;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @Description:提交意见建议接口
 * @Author:Jiang.MeiYing
 * @Time:2016-04-20 11:44:00
 */
public class SaveSuggest {
	/*
	 * @Descrption:提交意见建议接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_CSM_SAVEGOODSCONSULT
	 *        ctmUsrKey 用户ID
	 *        suggestInfo 建议内容
	 *        satisfactionAde 满意度等级
	 *        saticFactionAde 满意度等级
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-20 11:24:00
	 * @Update History:无
	 */
	public Document saveSuggest(String URL,
			String access_token,
			String interfaceCode,
			String ctmUsrKey,
			String suggestInfo,
			//String saticFactionAde,
			String satisfactionAde)
	{
		Document doc=null;
		try{
			Connection conn=Jsoup.connect(URL);
			conn.timeout(10000);
			conn.data("access_token",access_token);
			conn.data("interfaceCode",interfaceCode);
			conn.data("ctmUsrKey",ctmUsrKey);
			conn.data("suggestInfo",suggestInfo);
			conn.data("satisfactionAde",satisfactionAde);
			conn.ignoreContentType(true);
			doc=conn.post();
		}catch(IOException e){
			e.printStackTrace();			
		}
		return doc;
	}
}

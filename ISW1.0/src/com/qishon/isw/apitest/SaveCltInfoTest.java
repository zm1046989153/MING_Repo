package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.SaveCltInfo;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

import java.io.IOException;
import java.util.Map;

/*
 * @Descrption:保存商品收藏夹信息测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-13 19:05:00
 */
public class SaveCltInfoTest {
	SaveCltInfo mypost=new SaveCltInfo();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData1(){
		return new Object[][]{
//			发送正确的请求参数，验证响应码和返回信息，通过获取收藏信息接口验证商品收藏成功信息		
			{"SP_MAS_SAVECLTINFO",
				"1069310",
				"SY20150927",
				"D_CLT_GOOD",
				"200"},
		};
	}
	
	/*
	 * @Descrption:保存商品收藏夹信息测试
	 * @Param:URL标签
	 *        interfaceCode SP_MAS_SAVECLTINFO
	 *        ctmUsrKey 用户ID
	 *        partCode 商品货号
	 *        cltTypeCode 收藏类型
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-13 19:05:00
	 * @Update History:2016-04-25 11:06:00
	 */
	@Test(dataProvider="testdata1")
	public void saveCltInfoTest(String interfaceCode,
			String ctmUsrKey,
		    String partCode,
		    String cltTypeCode,
		    String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken =(fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.saveCltInfo(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
			    partCode,
			    cltTypeCode);
		System.out.println(doc);
		String doc1 = doc.body().html();
		final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}
}

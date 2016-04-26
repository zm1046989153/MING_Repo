package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.GetCltInfo;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

import java.io.IOException;
import java.util.Map;

/*
 * @Descrption:获取收藏夹信息测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-17 18:44:00
 */
public class GetCltInfoTest {
	GetCltInfo mypost=new GetCltInfo();
	private String URL=Common.gURL;
	
	
	@DataProvider(name="testdata1")
	public Object[][]TestData1(){
		return new Object[][]{	
//			发送正确的请求参数，验证响应码和返回信息	
			{"SP_MAS_GETCLTINFO",
				"1069310",
				"D_CLT_GOOD",
				"200"},
		};
	}
	
	/*
	 * @Descrption:获取收藏夹信息测试
	 * @Param:URL标签
	 *        interfaceCode SP_MAS_GETCLTINFO
	 *        access_token
	 *        ctmUsrKey 用户ID
	 *        cltTypeCode 收藏类型:店铺,商品,不传为获取全部
	 * @Return:无
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-17 18:44:00
	 * @Update History:2016-04-25 11:09:00
	 */
	@Test(dataProvider = "testdata1")
	public void getCltInfoTest(String interfaceCode,
			String ctmUsrKey,
		    String cltTypeCode,
		    String expectation) throws IOException{
		Document doc = null;
		FileIO fio = new FileIO();
		String accessToken = null;
		String str = null;
		accessToken =(fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.getCltInfo(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
			    cltTypeCode);
		System.out.println(doc);
		String doc1 = doc.body().html();
		final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}
}

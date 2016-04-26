package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.GetCartTemp;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Descrption:获取结算页面信息测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-25 18:02:00
 */
public class GetCartTempTest {
	GetCartTemp mypost=new GetCartTemp();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData1(){
		return new Object[][]{
//			通过购物车购买，发送正确的请求参数，验证响应码和返回信息，是否正确返回提交结算接口中的相应的商品信息
			{"SP_MAS_GETCARTTEMP",
				"1069310",
				"1002255",
				"200"},
			
//			直接购买，发送正确的请求参数，验证响应码和返回信息，是否正确返回提交结算接口中的相应的商品信息
			{"SP_MAS_GETCARTTEMP",
				"1069310",
				"1002257",
				"200"},
		};
	}
			
	
	/*
	 * @Descrption:获取结算页面信息测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_GETCARTTEMP
	 *        ctmUsrKey 用户ID
	 *        masCartTempHdKey masCartTempHdKey
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-25 18:03:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void saveCartTempTest(String interfaceCode,
			String ctmUsrKey,
			String masCartTempHdKey,
		    String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.getCartTemp(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				masCartTempHdKey);
		System.out.println(doc);
		String doc1 = doc.body().html();
		final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}
}

package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.GetShipping;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

//import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Description:获取配送方式测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-20 9:55:00
 */
public class GetShippingTest{
	GetShipping mypost=new GetShipping();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{
//			发送正确的请求参数，验证响应码和返回信息		
			{"SP_STM_GETSHIPPING",
				"1069310",
				"200"},
		};
	}
	
	/*
	 * @Descrption:获取配送方式测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_STM_GETSHIPPING
	 *        ctmUsrKey 用户ID
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-20 9:56:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void getShippingTest(String interfaceCode,
			String ctmUsrKey,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.getShipping(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey);
		System.out.println(doc);
		String doc1 = doc.body().html();
	    final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}

}

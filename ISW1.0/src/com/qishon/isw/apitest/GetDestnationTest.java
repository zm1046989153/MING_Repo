package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.GetDestnation;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

//import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Description:获取地区信息测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-20 10:19:00
 */
public class GetDestnationTest {
	GetDestnation mypost=new GetDestnation();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{
//			发送正确的请求参数，验证响应码和返回信息		
			{"SP_STM_GETDESTNATION",
				"1069310",
				"200"},
		};
	}
	
	/*
	 * @Descrption:获取地区信息测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_STM_GETDESTNATION
	 *        ctmUsrKey 用户ID
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-20 10:19:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void getDestnationTest(String interfaceCode,
			String ctmUsrKey,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.getDestnation(URL,
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

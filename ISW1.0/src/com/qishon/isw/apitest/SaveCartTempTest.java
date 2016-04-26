package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.SaveCartTemp;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Descrption:提交结算测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-19 10:29:00
 */
public class SaveCartTempTest {
	SaveCartTemp mypost=new SaveCartTemp();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData1(){
		return new Object[][]{
//			cartKeys非空，masPartDtSkuKey空，amount空，发送正确的请求参数，验证响应码和返回信息，将返回的masCartTempHdKey传入获取结算页面接口验证是否能正确返回信息
			{"SP_MAS_SAVECARTTEMP",
				"1069310",
				"1062847",
				"",
				"",
				"200"},
			
//			cartKeys空，masPartDtSkuKey非空，amount非空，发送正确的请求参数，验证响应码和返回信息，将返回的masCartTempHdKey传入获取结算页面接口验证是否能正确返回信息
			{"SP_MAS_SAVECARTTEMP",
				"1069310",
				"",
				"1002784",
				"1",
				"200"},
		};
	}
			
	
	/*
	 * @Descrption:提交结算测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_SAVECARTTEMP
	 *        ctmUsrKey 用户ID
	 *        cartKeys 购物车key，直接购买时传空
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-19 11:30:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void saveCartTempTest(String interfaceCode,
			String ctmUsrKey,
			String cartKeys,
			String masPartDtSkuKey,
			String amount,
		    String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		String str2 = null;
		FileIO fio = new FileIO();
		File fe = fio.createFile("masCartTempHdKey.txt");
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.saveCartTemp(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				cartKeys,
				masPartDtSkuKey,
				amount);
		System.out.println(doc);
		String doc1 = doc.body().html();
		final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		str2 =(((Map<String, Object>)((Map<String, Object>)map.get("result")).get("info")).get("masCartTempHdKey")).toString();
		fio.writeFile(str2, fe);
		Assert.assertEquals(str, expectation);
	}
}

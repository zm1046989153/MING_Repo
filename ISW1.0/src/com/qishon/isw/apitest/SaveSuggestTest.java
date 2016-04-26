package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.SaveSuggest;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

//import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Description:提交意见建议测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-20 11:27:00
 */
public class SaveSuggestTest {
	SaveSuggest mypost=new SaveSuggest();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{
//			发送正确的请求参数，验证响应码和返回信息		
			{"SP_CSM_SAVESUGGEST",
				"1069310",
				"产品丰富点",
				"1",
				"200"},
		};
	}
	
	/*
	 * @Descrption:提交意见建议测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_CSM_SAVESUGGEST
	 *        ctmUsrKey 用户ID
	 *        suggestInfo 建议内容
	 *        satisfactionAde 满意度等级
	 *        saticFactionAde 满意度等级
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-20 11:51:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void saveSuggestTest(String interfaceCode,
			String ctmUsrKey,
			String suggestInfo,
			String satisfactionAde,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.saveSuggest(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				suggestInfo,
				satisfactionAde);
		System.out.println(doc);
		String doc1 = doc.body().html();
	    final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}

}

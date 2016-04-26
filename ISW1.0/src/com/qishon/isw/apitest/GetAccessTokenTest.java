package com.qishon.isw.apitest;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;

import java.io.File;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.JsonToMap;
import com.qishon.isw.common.FileIO;

import com.qishon.isw.api.GetAccessToken;

/*
 * @Description:测试获取授权码
 * @Author:li.lin
 * @Time:2016-04-12 09:46:27
 */
public class GetAccessTokenTest {
	private static final String URL = Common.gBaseUrl + "access_token";

	@DataProvider(name="data")
	public Object[][] data(){
		return new Object[][]{
			{"testKey",
				"1454136383835",
				"9801efe1733349983047bead6893f0ef"}
			};
	}	  

    /*
     * @Description:发送正确的请求参数，验证响应码和返回信息
     * @Param:clientId 客户端key
	 *        requestTime 请求时间
	 *        chksum 校验码
	 * @Return:无
	 * @Author:li.lin
	 * @Time:2016-04-12 09:50:12
	 * @Update History:无
     */
    @Test(dataProvider="data")
    public void getAccessTokenTest(String clientId,String requestTime,String chksum) throws IOException {
    	GetAccessToken gat = new GetAccessToken();
    	FileIO fio = new FileIO();
		Document doc = null;
		String str = null;
		String AccessToken = null;
		File fe = fio.createFile("AccessToken.txt");
		doc=gat.getAccessToken(URL, clientId, requestTime, chksum);
		AssertJUnit.assertTrue(doc.toString().contains("86400"));
		System.out.println(doc);
	    String doc1 = doc.body().html();
	    //System.out.println(doc1);
		final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = (((Map<String, Object>)((Map<String, Object>)map.get("result")).get("info")).get("accessToken")).toString();
		fio.writeFile(str, fe);
		AccessToken=fio.readFile("e:/Temp/AccessToken.txt");
		//System.out.println(AccessToken);
	  }  
}

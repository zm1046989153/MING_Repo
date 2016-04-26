package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.GetOrdText;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

import java.io.IOException;
import java.util.Map;

/*
 * @Description:获取订单详情测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-18 9:54:00
 */
public class GetOrdTextTest {
	GetOrdText mypost=new GetOrdText();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{
//			发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，核对表数据，sale_ord_hd，sale_ord_dt
			{"SP_SALE_GETORDTEXT",
				"1069310",
				"QSSHOP0120160425000148",
				"200"},
		};
	}
	
	@Test(dataProvider="testdata1")
	public void getOrdTextTest(String interfaceCode,
			String ctmUsrKey,
			String billCode,
			String expectation) throws IOException{
		Document doc=null;
		FileIO fio = new FileIO();
		String accessToken = null;
		String str = null;
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.getOrdText(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				billCode);
		System.out.println(doc);
		String body=doc.getElementsByTag("body").text();
		String doc1 = doc.body().html();
		final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}

}

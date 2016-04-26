package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.GetPayUrl;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

//import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Description:获取支付地址测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-20 15:14:00
 */
public class GetPayUrlTest {
	GetPayUrl mypost=new GetPayUrl();
	//private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{
//			发送正确的请求参数，验证响应码和返回信息		
			{"http://192.168.1.36:9090/ISS20/rest/api/shoppingPay/getQRCodeOrPayUrl",
				"1069310",
				"['QSSHOP0120160425000148']",
				"D_ALIPAY",
				"D_FULL",
				"200"},
			
//			发送不正确的billCodeJson格式，验证响应码和返回信息
			{"http://192.168.1.36:9090/ISS20/rest/api/shoppingPay/getQRCodeOrPayUrl",
				"1069310",
				"['QSSHOP0120160419000129'",
				"D_ALIPAY",
				"D_FULL",
				"4000"},
		};
	}
	
	/*
	 * @Descrption:获取支付地址测试
	 * @Param:URL标签
	 *        access_token
	 *        ctmUsrKey 用户ID
	 *        billCodeJson 订单编码
	 *        paymentWayCode 支付方式编码
	 *        paymentTypeCode 支付类型编码
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-20 15:15:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void getPayUrlTest(String URL,
			String ctmUsrKey,
			String billCodeJson,
			String paymentWayCode,
			String paymentTypeCode,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.getPayUrl(URL,
				accessToken,
				ctmUsrKey,
				billCodeJson,
				paymentWayCode,
				paymentTypeCode);
		System.out.println(doc);
		String doc1 = doc.body().html();
		//System.out.println(doc1);
	    final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}
}

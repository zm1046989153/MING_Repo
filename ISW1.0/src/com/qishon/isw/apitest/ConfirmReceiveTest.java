package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.ConfirmReceive;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

//import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Description:确认收货测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-26 14:53:00
 */
public class ConfirmReceiveTest {
	ConfirmReceive mypost=new ConfirmReceive();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{
//			发送正确的请求参数，验证响应码和返回信息，通过获取订单详情接口，验证订单状态是否变为已签收
			{"SP_SALE_CONFIRMRECEIVE",
				"1069310",
				"QSSHOP0120160425000148",
				"200"},
		};
	}
	
	/*
	 * @Descrption:确认收货车测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_SALE_CONFIRMRECEIVE
	 *        ctmUsrKey 用户ID
	 *        billCodes 订单号
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-26 14:55:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void getDestnationTest(String interfaceCode,
			String ctmUsrKey,
			String billCodes,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.confirmReceive(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				billCodes);		
		System.out.println(doc);		
		String doc1 = doc.body().html();
	    final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}

}

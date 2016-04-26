package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.SaveOrd;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Description:提交订单数据测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-19 13:32:00
 */
@Test(priority=3)
public class SaveOrdTest {
	SaveOrd mypost=new SaveOrd();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{
//			立即购买提交订单，发送正确的请求参数，验证响应码和返回信息,核对数据库表的数据：sale_ord_hd，amout_needpay应付金额的逻辑计算是否正确
			{"SP_SALE_SAVEORD",
				"1069310",
				"D_ONLINE",
				"",
				"1001561",
				"D_RECEIPT_EMS",
				"1001568",
				"1002784",
				"1",
				"200"},
			
//			加入购物车提交订单，发送正确的请求参数，验证响应码和返回信息,核对数据库表的数据：sale_ord_hd，amout_needpay应付金额的逻辑计算是否正确
			{"SP_SALE_SAVEORD",
				"1069310",
				"D_ONLINE",
				"1002201",
				"1001561",
				"D_RECEIPT_EMS",
				"1001568",
				"",
				"",
				"200"},
		};
	}
	
	/*
	 * @Descrption:提交订单数据测试
	 * @Param:URL标签
	 *        interfaceCode SP_SALE_SAVEORD
	 *        ctmUsrKey 用户ID
	 *        sourceCode 来源
	 *        masCartTempHdKey 购物车中间表ID
	 *        shipPingKey 配送方式ID
	 *        receiptWayCode 收货方式
	 *        addressKey 地址KEY
	 *        masPartDtSkuKey SKUID
	 *        qty 数量
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-19 13:34:00
	 * @Update History:2016-04-25 9:27:00
	 */
	@Test(dataProvider="testdata1")
	public void saveOrdTest(String interfaceCode,
			String ctmUsrKey,
			String sourceCode,
			String masCartTempHdKey,
			String shipPingKey,
			String receiptWayCode,
			String addressKey,
			String masPartDtSkuKey,
			String qty,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		String str2 = null;
		//String masCartTempHdKey = null;
		FileIO fio = new FileIO();
		File fe = fio.createFile("billCodes.txt");
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		//masCartTempHdKey = (fio.readFile("e:/Temp/masCartTempHdKey.txt")).trim();
		doc=mypost.saveOrd(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				sourceCode,
				masCartTempHdKey,
				shipPingKey,
				receiptWayCode,
				addressKey,
				masPartDtSkuKey,
				qty);
		System.out.println(doc);
		String doc1 = doc.body().html();
		System.out.println(doc1);
	    final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		str2 =(((Map<String, Object>)((Map<String, Object>)map.get("result")).get("info")).get("billCodes")).toString();
		fio.writeFile(str2, fe);
		Assert.assertEquals(str, expectation);
	}

}

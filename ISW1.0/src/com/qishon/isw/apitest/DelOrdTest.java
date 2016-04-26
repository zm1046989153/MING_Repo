package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.DelOrd;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Description:取消/删除/还原订单测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-19 17:19:00
 */
public class DelOrdTest {
	DelOrd mypost=new DelOrd();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{
//			flag=1,发送正确的请求参数（订单非货到付款且订单状态是未付款），验证响应码和返回信息，验证表sale_ord_hd中ordstatuskey是否正确更新为取消订单的值，通过获取订单详情的接口，验证订单状态是否正确更新
			{"SP_SALE_DELORD",
				"1069310",
				"QSSHOP0120160425000147",
				"1",
				"200"},
			
//			flag=2,发送合法的billCode（订单状态：已签收、取消订单、退货成功、退款成功），验证响应码和返回信息，验证表sale_ord_hd中deltime是否正确生成，且订单列表接口返回的信息中没有删除的订单数据
			{"SP_SALE_DELORD",
					"1069310",
					"QSSHOP0120160425000147",
					"2",
					"200"},
			
//			flag=3，发送正确的请求参数，验证响应码和返回信息（针对已删除的订单进行还原），通过获取订单列表验证是否能找到该订单数据
			{"SP_SALE_DELORD",
						"1069310",
						"QSSHOP0120160425000147",
						"3",
						"200"},
		};
	}
	
	/*
	 * @Descrption:取消/删除/还原订单接口
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_SALE_DELORD
	 *        ctmUsrKey 用户ID
	 *        billCode 订单编号
	 *        flag 取消/删除/还原标示 1: 取消，2：删除,3:还原
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-19 17:23:00
	 * @Update History:2016-04-259 11:04:00
	 */
	@Test(dataProvider="testdata1")
	public void saveOrdTest(String interfaceCode,
			String ctmUsrKey,
			String billCode,
			String flag,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.delOrd(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				billCode,
				flag);
		System.out.println(doc);
		String doc1 = doc.body().html();
		System.out.println(doc1);
	    final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}

}

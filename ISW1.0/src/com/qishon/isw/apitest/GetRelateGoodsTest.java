package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.GetRelateGoods;
import com.qishon.isw.apitest.GetAccessTokenTest;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

import java.io.IOException;
import java.util.Map;

/*
 * @Description:获取商品的关联购买商品测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-26 14:58:00
 */
public class GetRelateGoodsTest {
	GetRelateGoods mypost=new GetRelateGoods();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{	
//			发送正确的请求参数，验证响应码和返回信息
			{"SP_SALE_GETRELATEGOODS",
				"1069310",
				"SY20150927",
				"200"}, 
		};
	}
	
     /*
	 * @Descrption:获取商品的关联购买商品测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_SALE_GETRELATEGOODS
	 *        ctmUsrKey 用户ID
	 *        goodsCode 商品货号
	 * @Return:无
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-26 14:593:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void getRelateGoodsTest(String interfaceCode,
			String ctmUsrKey,
			String goodsCode,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken =(fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.getRelateGoods(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				goodsCode);
		System.out.println(doc);
	    String doc1 = doc.body().html();
		final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}

}

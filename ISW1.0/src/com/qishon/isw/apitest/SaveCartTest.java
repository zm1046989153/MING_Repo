package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.SaveCart;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Descrption:保存和更新购物车信息测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-19 10:55:00
 */
public class SaveCartTest {
	SaveCart mypost=new SaveCart();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData1(){
		return new Object[][]{
//			游客发送正确的请求参数，验证响应码和返回信息，通过查询购物车列表接口，确认商品是否成功加入购物车
			{"SP_MAS_SAVECART",
				"",
				"",
				"MAN51163184",
				"1002784",
				"1",
				"200"},
			
//			会员发送正确的请求参数，验证响应码和返回信息，通过查询购物车列表接口，确认商品是否成功加入购物车		
			{"SP_MAS_SAVECART",
				"1069310",
				"",
				"MAN51163184",
				"1002784",
				"1",
				"200"},
			
//			会员发送正确的请求参数，验证响应码和返回信息，通过查询购物车列表接口，确认相应cartKey的购物车信息是否更新成功
			{"SP_MAS_SAVECART",
				"1069310",
				"1062756",
				"MAN51163184",
				"1002784",
				"1",
				"200"},
		};
	}
			
	
	/*
	 * @Descrption:保存和更新购物车信息测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_SAVECART
	 *        ctmUsrKey 用户ID
	 *        cartKey 修改时需传购物车key,保存时为空
	 *        goodsCode 平台商品编码
	 *        masPartDtSkuKey SKUID
	 *        amount 数量
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-25 15:30:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void saveCartTest(String interfaceCode,
			String ctmUsrKey,
			String cartKey,
		    String goodsCode,
		    String masPartDtSkuKey,
		    String amount,
		    String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		String str2 = null;
		FileIO fio = new FileIO();
		File fe = fio.createFile("cartKey.txt");
		accessToken =(fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.saveCart(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				cartKey,
				goodsCode,
				masPartDtSkuKey,
				amount);
		 System.out.println(doc);
		 String doc1 = doc.body().html();
		 final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		 str = ((Map<String, Object>)map.get("result")).get("code").toString();
		 str2 =(((Map<String, Object>)((Map<String, Object>)map.get("result")).get("info")).get("cartKey")).toString();
		 System.out.println(str2);
		 fio.writeFile(str2, fe);
		 Assert.assertEquals(str, expectation);
	}
}

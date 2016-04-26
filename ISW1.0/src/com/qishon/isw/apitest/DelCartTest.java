package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.DelCart;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

//import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Description:删除购物车测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-26 10:17:00
 */
public class DelCartTest {
	DelCart mypost=new DelCart();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{
//			发送正确的请求参数，验证响应码和返回信息，通过查询购物车列表接口，验证已删除的cartKeys是否已不存在
			{"SP_MAS_DELCART",
				"1069310",
				"1062756",
				"200"},
		};
	}
	
	/*
	 * @Descrption:删除购物车测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_MAS_DELCART
	 *        ctmUsrKey 用户ID
	 *        cartKeys 购物车key
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-26 10:19:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void getDestnationTest(String interfaceCode,
			String ctmUsrKey,
			String cartKeys,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.delCart(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				cartKeys);		
		System.out.println(doc);		
		String doc1 = doc.body().html();
	    final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}

}

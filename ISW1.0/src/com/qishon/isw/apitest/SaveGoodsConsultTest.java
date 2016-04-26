package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.SaveGoodsConsult;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

//import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
 * @Description:提交商品咨询测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-20 11:27:00
 */
public class SaveGoodsConsultTest {
	SaveGoodsConsult mypost=new SaveGoodsConsult();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{
//			发送正确的请求参数，验证响应码和返回信息		
			{"SP_CSM_SAVEGOODSCONSULT",
				"1069310",
				"MAN51163184",
				"修身吗？",
				"200"},
		};
	}
	
	/*
	 * @Descrption:提交商品咨询测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_CSM_SAVEGOODSCONSULT
	 *        ctmUsrKey 用户ID
	 *        goodsCode 平台商品编码
	 *        conSultInfo 咨询内容
	 * @Return:doc对象
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-20 11:27:00
	 * @Update History:无
	 */
	@Test(dataProvider="testdata1")
	public void saveGoodsConsultTest(String interfaceCode,
			String ctmUsrKey,
			String goodsCode,
			String conSultInfo,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken = (fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.saveGoodsConsult(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				goodsCode,
				conSultInfo);
		System.out.println(doc);
		String doc1 = doc.body().html();
	    final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}

}

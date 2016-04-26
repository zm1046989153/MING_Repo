package com.qishon.isw.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.jsoup.nodes.Document;

import com.qishon.isw.api.GetOrdList;
import com.qishon.isw.apitest.GetAccessTokenTest;
import com.qishon.isw.common.Common;
import com.qishon.isw.common.FileIO;
import com.qishon.isw.common.JsonToMap;

import java.io.IOException;
import java.util.Map;

/*
 * @Description:获取订单列表测试
 * @Author:Jiang.MeiYing
 * @Time:2016-04-15 14:35:00
 */
public class GetOrdListTest {
	GetOrdList mypost=new GetOrdList();
	private String URL=Common.gURL;
	
	@DataProvider(name="testdata1")
	public Object[][]TestData(){
		return new Object[][]{	
//			订单分类=所有，订单类型=空，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出所有订单类型的所有订单，是否按照订单时间降序排序，相关表sale_ord_hd		
			{"SP_SALE_GETORDLIST",
				"1069310",
				"D_ORDSALL",
				"",
				"",
				"",
				"200"}, 
			
//			订单分类=所有，订单类型=普通，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出普通订单类型的所有订单，是否按照订单时间降序排序，相关表sale_ord_hd
			{"SP_SALE_GETORDLIST",
					"1069310",
					"D_ORDSALL",
					"D_ORDNOMAL",
					"",
					"",
					"200"}, 
				
//			订单分类=待付款，订单类型=空，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出所有订单类型的待付款订单，是否按照订单时间降序排序，相关表sale_ord_hd			{"SP_SALE_GETORDLIS",
			{"SP_SALE_GETORDLIST",
						"1069310",
						"D_ORDSPAYING",
						"",
						"",
						"",
						"200"}, 
			
//			订单分类=待付款，订单类型=普通，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否查询普通类型订单的待付款订单，是否按照订单时间降序排序，相关表sale_ord_hd
			{"SP_SALE_GETORDLIST",
			"1069310",
			"D_ORDSPAYING",
			"D_ORDNOMAL",
			"",
			"",
			"200"}, 
				
//			订单状态=待发货，订单类型=空，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出所有订单类型的待发货订单，是否按照订单时间降序排序，相关表sale_ord_hd			{"SP_SALE_GETORDLIST",
			{"SP_SALE_GETORDLIST",
			"1069310",
			"D_ORDSSHIPPING",
			"",
			"",
			"",
			"200"}, 
				
//			订单状态=待发货，订单类型=普通，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出普通订单类型的待发货订单，是否按照订单时间降序排序，相关表sale_ord_hd			{"SP_SALE_GETORDLIST",
			{"SP_SALE_GETORDLIST",
			"1069310",
			"D_ORDSSHIPPING",
			"D_ORDNOMAL",
			"",
			"",
			"200"}, 
			
//			订单状态=待收货，订单类型=空，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出所有订单类型的待收货订单，是否按照订单时间降序排序，相关表sale_ord_hd			{"SP_SALE_GETORDLIST",
			{"SP_SALE_GETORDLIST",
			"1069310",
			"D_ORDSDELIVERY",
			"",
			"",
			"",
			"200"}, 
			
//			订单状态=待收货，订单类型=普通，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出普通订单类型的待收货订单，是否按照订单时间降序排序，相关表sale_ord_hd			{"SP_SALE_GETORDLIST",
			{"SP_SALE_GETORDLIST",
			"1069310",
			"D_ORDSDELIVERY",
			"D_ORDNOMAL",
			"",
			"",
			"200"}, 
			
//			订单分类=待评价，订单类型=空，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出所有订单类型的待评价订单，是否按照订单时间降序排序，相关表sale_ord_hd			{"SP_SALE_GETORDLIST",
			{"SP_SALE_GETORDLIST",
			"1069310",
			"D_ORDSSHIPPING",
			"D_ORDNOMAL",
			"",
			"",
			"200"}, 
			
//			订单状态=待评价，订单类型=普通，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出普通订单类型的待评价订单，是否按照订单时间降序排序，相关表sale_ord_hd			
			{"SP_SALE_GETORDLIST",
			"1069310",
			"D_ORDSCOMMENTING",
			"D_ORDNOMAL",
			"",
			"",
			"200"},
			
//			订单分类=退款，订单类型=空，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出所有订单类型的退款订单，是否按照订单时间降序排序，相关表sale_ord_hd
			{"SP_SALE_GETORDLIST",
				"1069310",
				"D_ORDRETURN",
				"",
				"",
				"",
				"200"},
			
//			订单分类=退款，订单类型=普通，pageSize=空，pageNo=空，发送正确的请求参数，验证响应码和返回信息，验证数据查询是否正确，是否返回第1页的20条记录，是否查询出普通订单类型的退款订单，是否按照订单时间降序排序，相关表sale_ord_hd
			{"SP_SALE_GETORDLIST",
					"1069310",
					"D_ORDRETURN",
					"D_ORDNOMAL",
					"",
					"",
					"200"},
		};
	}
				
			
	
     /*
	 * @Descrption:获取订单列表测试
	 * @Param:URL标签
	 *        access_token
	 *        interfaceCode SP_SALE_GETORDLIST
	 *        ctmUsrKey 用户ID
	 *        searchCode 订单状态 
	 *        orderTypeCode 订单类型
	 *        pageSize 条数
	 *        pageNo 查询页  
	 * @Return:无
	 * @Author:Jiang.MeiYing
	 * @Time:2016-04-15 14:38:00
	 * @Update History:2016-04-25 10:32:00
	 */
	@Test(dataProvider="testdata1")
	public void getOrdListTest(String interfaceCode,
			String ctmUsrKey,
			String searchCode,
			String orderTypeCode,
			String pageSize,
			String pageNo,
			String expectation) throws IOException{
		Document doc=null;
		String accessToken = null;
		String str = null;
		FileIO fio = new FileIO();
		accessToken =(fio.readFile("e:/Temp/AccessToken.txt")).trim();
		doc=mypost.getOrdList(URL,
				accessToken,
				interfaceCode,
				ctmUsrKey,
				searchCode,
				orderTypeCode,
				pageSize,
				pageNo);
		System.out.println(doc);
	    String doc1 = doc.body().html();
		final Map<String, Object> map = JsonToMap.getMapFromJsonObjStr(doc1);
		str = ((Map<String, Object>)map.get("result")).get("code").toString();
		Assert.assertEquals(str, expectation);
	}

}

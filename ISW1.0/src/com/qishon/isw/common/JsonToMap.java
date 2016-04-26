package com.qishon.isw.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONStringer;

/*
 * @Description:Json格式转换为Map
 * @Author:li.lin
 * @Time:2016-04-12 19:23:16
 */
public class JsonToMap {
	/*
	 * @Description:Json格式转换为Map
	 * @Param:jsonObjStr Json字符串
	 * @Return:map
	 * @Author:li.lin
	 * @Time:2016-04-12 19:24:37
	 * @Update History:无
	 */
	public static Map<String,Object> getMapFromJsonObjStr(String jsonObjStr) {
		final JSONObject jsonObject = JSONObject.fromObject(jsonObjStr);
        final Map<String, Object> map = new HashMap<String, Object>(); 
        final Iterator<String> it = jsonObject.keys();
        while (it.hasNext()) {
        	final String key = it.next();   
            map.put(key, jsonObject.get(key));
        }  
        return map;   
	}
}


package cn.linzs.controller;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/** 
* @ClassName: BaseController 
* @Description: 父控制器，提供一些Controller的公共方法
* @author Lin 
* @date 2016年6月3日 上午11:50:33 
*  
*/
public abstract class BaseController {
	
	@Value("${pageNum}")
	protected Integer pageNum;
	@Value("${pageSize}")
	protected Integer pageSize;
	
	/**
	 * 将请求中的参数解析为Map
	 * @param request
	 * @return
	 * */
	protected Map<String, Object> parseRequestMap(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, String[]> originMap = request.getParameterMap();
		
		Set<String> keys = originMap.keySet();
		for(String key : keys) {
			String[] value = originMap.get(key);
			if(value.length == 1 && !"".equals(value[0])) {
				resultMap.put(key, value[0]);
			} else if(value.length > 1) {
				resultMap.put(key, value);
			}
			
		}
		
		return resultMap;
	}
	
	/**
	 * 将请求中的参数解析为分页需要的Map
	 * @param requestMap
	 * @return
	 * */
	@SuppressWarnings("unchecked")
	protected Map<String, Object> parsePageMap(Map<String, Object> requestMap) {
		
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		List<Map<String, Object>> pageData = (List<Map<String, Object>>) requestMap.get("pageData");
		Map<String, Object> orderColumns = (LinkedHashMap<String, Object>) requestMap.get("orderColumns");
		Map<String, Object> searchMap = (Map<String, Object>) requestMap.get("search") != null ? (HashMap<String, Object>) requestMap.get("search") : new HashMap<String, Object>();

		paramsMap.putAll(searchMap);
		for(Map<String, Object> tempMap : pageData) {
			paramsMap.put(tempMap.get("name").toString(), tempMap.get("value"));
		}
		
		int pageNum = paramsMap.get("iDisplayStart") != null ? Integer.valueOf(paramsMap.get("iDisplayStart").toString()) : 0;
		int pageSize = paramsMap.get("iDisplayLength") != null ? Integer.valueOf(paramsMap.get("iDisplayLength").toString()) : 0;
		pageNum = pageNum == 0 ? this.pageNum : pageNum;
		pageSize = pageSize == 0 ? this.pageSize : pageSize;
		
		paramsMap.put("pageNum", pageNum);
		paramsMap.put("pageSize", pageSize);
		paramsMap.put("orderColumns", orderColumns);
		
		return paramsMap;
	}
	
	/**
	 * 构造表格需要的JSON数据
	 * @param paramsMap
	 * @param data
	 * @return
	 * */
	protected <T> Map<String, Object> buildTableData(Map<String, Object> paramsMap, List<T> data) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("sEcho", Integer.valueOf(paramsMap.get("sEcho").toString()));
		dataMap.put("iTotalRecords", data.size());
		dataMap.put("iTotalDisplayRecords", data.size());
		dataMap.put("aaData", data);

		return dataMap;
	}
	
}
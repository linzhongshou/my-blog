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
	protected Map<String, Object> parsePageMap(Map<String, Object> requestMap) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();

		int pageNum = paramsMap.get("pageNum") != null ? Integer.valueOf(paramsMap.get("pageNum").toString()) : this.pageNum;
		int pageSize = paramsMap.get("pageSize") != null ? Integer.valueOf(paramsMap.get("pageSize").toString()) : this.pageSize;

		pageNum = pageNum == 0 ? this.pageNum : pageNum;
		pageSize = pageSize == 0 ? this.pageSize : pageSize;

		paramsMap.put("pageNum", pageNum);
		paramsMap.put("pageSize", pageSize);

		return paramsMap;
	}
	
}
package cn.linzs.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by root on 17-7-6.
 */
@RestController
@RequestMapping("/blog")
public class BlogController extends BaseController {

    @RequestMapping("/page")
    public Map<String, Object> page(@RequestBody Map<String, Object> requestMap) {
        List<Map<String, Object>> page = new ArrayList<>();
        for(int i=1; i <= 10; i++) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", i);
            data.put("title", "a" + i);
            data.put("content", UUID.randomUUID().toString());
            data.put("date", new Date());

            page.add(data);
        }

        Map<String, Object> paramsMap = parsePageMap(requestMap);

//        Page<SysUser> page = userService.findByPage(paramsMap,
//                Integer.valueOf(paramsMap.get("pageNum").toString()),
//                Integer.valueOf(paramsMap.get("pageSize").toString()));

        Map<String, Object> jsonMap = buildTableData(paramsMap, page);
        return jsonMap;
    }
}

package com.grateful.demo.frameWork.common;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * DESC:
 * USER: C.HE
 * DATE: 2018/10/24 13:53
 * VERSION: 0.0.1
 */
public class BaseController {

    /**
     * 计算分页数据
     * start从几行开始
     * limit到几行结束
     * page当前第几页
     * rows每页多少行
     * @param search
     * @return
     */
    private Search getStartAndLimit(Search search) {
        //params中只有"sort"："createTime"和"order"："desc"键值对，因此params.getAsInteger("page");的返回值为null
        int page = Integer.valueOf((String)search.get("page"));//首次点击公告管理的话page=1
        int rows = Integer.valueOf((String)search.get("rows"));//首次点击公告管理的话rows=10
        search.put("start",page * rows - rows);//start=0；
        search.put("limit",rows);//limit=10   原来是：page*rows，page*rows is changged to rows by hechuan at 20170417
        System.out.println("search的值为："+search);
        return search;
    }

    /**
     * 将请求参数封装为Dto，即：将request中的键值对以键值对的方式放入dto中
     *
     * @param request
     * @return
     */
    public Search getParamsAsSearch(HttpServletRequest request) {
        Search search = new Search();
        Map map = request.getParameterMap();
        //迭代键
        Iterator keyIterator = (Iterator) map.keySet().iterator();
        while (keyIterator.hasNext()) {
            //拿到当前迭代的key
            String key = (String) keyIterator.next();
            //拿到当前key对应的值
            String value = ((String[]) (map.get(key)))[0];
            //将键值对存放到dto中
            search.put(key, value);
        }
        return getStartAndLimit(search);
    }
}

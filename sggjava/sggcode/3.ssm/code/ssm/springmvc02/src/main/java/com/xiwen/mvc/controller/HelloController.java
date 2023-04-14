package com.xiwen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/14 -09:32
 * @Version: 1.0
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

//    @RequestMapping("/toIndexPage")
//    public ModelAndView toIndexPage(ModelAndView mv) {
//        mv.setViewName("index");
//        return mv;
//    }


    @RequestMapping("/mvTest")
    public ModelAndView mvTest(ModelAndView mv) {
        mv.addObject("requestKey", "requestModelAndViewValue");
        mv.setViewName("result");
        return mv;
    }

    /**
     * 如何添加请求域的共享数据
     *      添加形参Map/Model/ModelMap
     *          因为不管设置哪种类型，传进来的都是同一个类型
     * 返回值是String
     *      返回逻辑视图
     *
     * 原理：如果采用第二种方式，最终SpringMVC还是会将你的返回值和形参，组装成ModelAndView
     */
    @RequestMapping("/strMapTest")
    public String mapTest(Map map) {
        map.put("requestKey", "requestMapValue");
        return "result";
    }

    @RequestMapping("/strModelMapTest")
    public String ModelMapTest(ModelMap map) {
        map.addAttribute("requestKey", "requestModelMapValue");
        return "result";
    }

    @RequestMapping("/strModelTest")
    public String ModelTest(Model map) {
        map.addAttribute("requestKey", "requestModelValue");
        return "result";
    }
}

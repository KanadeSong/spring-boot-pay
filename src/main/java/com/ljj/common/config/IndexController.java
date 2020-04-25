package com.ljj.common.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * IndexController
 * </p>
 *
 * @author LeeJack
 * @date Created in 2020/4/26 1:36
 */
@Controller
public class IndexController {

    /**
     * 页面跳转
     *
     * @param url
     * @return
     */
    @RequestMapping("{url}.shtml")
    public String page(@PathVariable("url") String url) {
        return url;
    }

    /**
     * 页面跳转（一级目录）
     *
     * @param module
     * @param url
     * @return
     */
    @RequestMapping("{module}/{url}.shtml")
    public String page(@PathVariable("module") String module, @PathVariable("url") String url) {
        return module + "/" + url;
    }

    /**
     * 页面跳转（二级目录）
     * @param module
     * @param sub
     * @param url
     * @return
     */
    @RequestMapping("{module}/{sub}/{url}.shtml")
    public String page(@PathVariable("module") String module, @PathVariable("sub") String sub,
                       @PathVariable("url") String url) {
        return module + "/" + sub + "/" + url;
    }
}

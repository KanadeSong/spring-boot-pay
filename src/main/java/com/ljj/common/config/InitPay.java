package com.ljj.common.config;

import com.alipay.demo.trade.config.Configs;
import com.ljj.modules.unionpay.util.SDKConfig;
import com.ljj.modules.weixinpay.util.ConfigUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @CLassName InitPay
 * @Description 启动加载支付宝、微信以及银联相关参数配置
 * @Author LeeJack
 * @Date 2019/4/18/018 20:57
 * @Version 1.0
 */
@Component
public class InitPay implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        //初始化 支付宝-微信-银联相关参数,涉及机密,此文件不会提交,请自行配置相关参数并加载
        //支付宝
        Configs.init("zfbinfo.properties");
        //微信
        ConfigUtil.init("wxinfo.properties");
        //银联
        SDKConfig.getConfig().loadPropertiesFromSrc();
    }
}

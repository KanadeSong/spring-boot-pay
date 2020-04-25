package com.ljj.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @CLassName CommonUtil
 * @Author LeeJack
 * @Date 2019/4/18/018 20:48
 * @Version 1.0
 */
public class CommonUtil {

    /**
     *
     * @Description: 除法
     * @Param [arg1, arg2]
     * @return java.math.BigDecimal
     * @author LeeJack
     * @Date 20:48 2019/4/18/018
     */
    public static BigDecimal divide(String arg1, String arg2) {
        if (StringUtils.isEmpty(arg1)) {
            arg1 = "0.0";
        }
        if (StringUtils.isEmpty(arg2)) {
            arg2 = "0.0";
        }
        BigDecimal big3 = new BigDecimal("0.00");
        if (Double.parseDouble(arg2) != 0) {
            BigDecimal big1 = new BigDecimal(arg1);
            BigDecimal big2 = new BigDecimal(arg2);
            big3 = big1.divide(big2, 2, BigDecimal.ROUND_HALF_EVEN);
        }
        return big3;
    }

    /**
     *
     * @Description: 乘法
     * @Param [arg1, arg2]
     * @return java.math.BigDecimal
     * @author LeeJack
     * @Date 20:49 2019/4/18/018
     */
    public static BigDecimal mul(String arg1, String arg2) {
        if (StringUtils.isEmpty(arg1)) {
            arg1 = "0.0";
        }
        if (StringUtils.isEmpty(arg2)) {
            arg2 = "0.0";
        }
        BigDecimal big1 = new BigDecimal(arg1);
        BigDecimal big2 = new BigDecimal(arg2);
        BigDecimal big3 = big1.multiply(big2);
        return big3;
    }

    /**
     *
     * @Description: 减法
     * @Param [arg1, arg2]
     * @return java.math.BigDecimal
     * @author LeeJack
     * @Date 20:49 2019/4/18/018
     */
    public static BigDecimal sub(String arg1, String arg2) {
        if (StringUtils.isEmpty(arg1)) {
            arg1 = "0.0";
        }
        if (StringUtils.isEmpty(arg2)) {
            arg2 = "0.0";
        }
        BigDecimal big1 = new BigDecimal(arg1);
        BigDecimal big2 = new BigDecimal(arg2);
        BigDecimal big3 = big1.subtract(big2);
        return big3;
    }

    /**
     *
     * @Description: 加法
     * @Param [arg1, arg2]
     * @return java.math.BigDecimal
     * @author LeeJack
     * @Date 20:49 2019/4/18/018
     */
    public static BigDecimal add(String arg1, String arg2) {
        if (StringUtils.isEmpty(arg1)) {
            arg1 = "0.0";
        }
        if (StringUtils.isEmpty(arg2)) {
            arg2 = "0.0";
        }
        BigDecimal big1 = new BigDecimal(arg1);
        BigDecimal big2 = new BigDecimal(arg2);
        BigDecimal big3 = big1.add(big2);
        return big3;
    }

    /**
     *
     * @Description: 加法2
     * @Param [arg1, arg2]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:50 2019/4/18/018
     */
    public static String add2(String arg1, String arg2) {
        if (StringUtils.isEmpty(arg1)) {
            arg1 = "0.0";
        }
        if (StringUtils.isEmpty(arg2)) {
            arg2 = "0.0";
        }
        BigDecimal big1 = new BigDecimal(arg1);
        BigDecimal big2 = new BigDecimal(arg2);
        BigDecimal big3 = big1.add(big2);
        return big3.toString();
    }

    /**
     *
     * @Description: 四舍五入保留N位小数 先四舍五入在使用double值自动去零
     * @Param [arg, scare]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:50 2019/4/18/018
     */
    public static String setScare(BigDecimal arg, int scare) {
        BigDecimal bl = arg.setScale(scare, BigDecimal.ROUND_HALF_UP);
        return String.valueOf(bl.doubleValue());
    }


    public static double setDifScare(double arg) {
        BigDecimal bd = new BigDecimal(arg);
        BigDecimal bl = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return Double.parseDouble(bl.toString());
    }

    /**
     *
     * @Description: 四舍五入保留两位小数 先四舍五入在使用double值自动去零
     * @Param [arg]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:50 2019/4/18/018
     */
    public static String setDifScare(String arg) {
        BigDecimal bd = new BigDecimal(arg);
        BigDecimal bl = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bl.toString();
    }

    /**
     *
     * @Description: 四舍五入保留N位小数 先四舍五入在使用double值自动去零（传参String类型）
     * @Param [arg, i]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:51 2019/4/18/018
     */
    public static String setDifScare(String arg, int i) {
        BigDecimal bd = new BigDecimal(arg);
        BigDecimal bl = bd.setScale(i, BigDecimal.ROUND_HALF_UP);
        return bl.toString();
    }

    /**
     *
     * @Description: 转化成百分数 先四舍五入在使用double值自动去零
     * @Param [arg]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:51 2019/4/18/018
     */
    public static String setFenScare(BigDecimal arg) {
        BigDecimal bl = arg.setScale(3, BigDecimal.ROUND_HALF_UP);
        String scare = String.valueOf(mul(bl.toString(), "100").doubleValue());
        String fenScare = scare + "%";
        return fenScare;
    }

    /**
     *
     * @Description: 使用java正则表达式去掉多余的.与0
     * @Param [s]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:51 2019/4/18/018
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");// 去掉多余的0
            s = s.replaceAll("[.]$", "");// 如最后一位是.则去掉
        }
        return s;
    }
}

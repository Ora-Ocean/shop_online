package com.soft2242.shop_online.constant;

public class APIConstant {
    /**
     * 请求头 认证名称
     */
    public final static String AUTHORIZATION = "Authorization";

    /**
     * token 加密密钥
     */
    public static String JWT_SECRET = "shopApi";

    /**
     * redis 存 token 键名
     */
    public static String APP_NAME = "shopApi";

    /**
     * 默认头像
     */
    public static String DEFAULT_AVATAR = "https://ycshang123.oss-cn-hangzhou.aliyuncs.com/cover%20%282%29.png\n";
    /**
     * APP_ID
     */
    public static String APP_ID = "wxa2824062f5b4c04b";
    /**
     * APP_SECRET
     */
    public static String APP_SECRET = "418f7a1688fa146c9090552d3f5a87d1";
    /**
     * 微信调用api接口返回错误code
     */
    public static String WX_ERR_CODE = "errcode";
    /**
     * 微信调用api接口获取openid
     */
    public static String WX_OPENID = "openid";

    /**
     * token 过期时间 15天
     */
    public static long APP_TOKEN_EXPIRE_TIME = 15 * 24 * 3600L;

}
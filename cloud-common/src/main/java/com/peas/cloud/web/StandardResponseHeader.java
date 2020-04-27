package com.peas.cloud.web;

/**
 * 标准响应头
 */
public class StandardResponseHeader {

    public static final ResponseHeader SUCCESS = ResponseHeader.newInstance(200, "成功");

    public static final ResponseHeader ERROR = ResponseHeader.newInstance(500, "系统繁忙,请稍后再试");

    public static final ResponseHeader ERROR_TOCKEN = ResponseHeader.newInstance(105001, "token错误");

    public static final ResponseHeader ERROR_TOCKEN_EXPIRE = ResponseHeader.newInstance(105002, "token失效");

    public static final ResponseHeader ERROR_SIGN = ResponseHeader.newInstance(105010, "签名错误");

    public static final ResponseHeader USER_NOT_EXISTS = ResponseHeader.newInstance(105021, "用户不存在");

    public static final ResponseHeader USER_REGISTERED = ResponseHeader.newInstance(105022, "用户已注册");


    public static final ResponseHeader SIGN_ERROR = ResponseHeader.newInstance(105024, "参数签名错误");

    public static final ResponseHeader REQ_PARAM_ERROR = ResponseHeader.newInstance(105025, "请求参数有误");

    public static final ResponseHeader MCH_NO_EXIETS = ResponseHeader.newInstance(105026, "商户不存在");

    public static final ResponseHeader MCH_STATUS_IS_ERROR = ResponseHeader.newInstance(105027, "商户状态异常");

    public static final ResponseHeader MCH_NO_TRADE_INFO = ResponseHeader.newInstance(105028, "此订单不存在");

    public static final ResponseHeader MCH_TRADE_IS_EXIETS = ResponseHeader.newInstance(105029, "重复订单");

    public static final ResponseHeader MCH_BANK_IS_NOT_EXIETS = ResponseHeader.newInstance(105030, "非有效签约关系");

    public static final ResponseHeader BANK_NOT_SUPPORT = ResponseHeader.newInstance(105031, "暂不支持该银行卡");

    public static final ResponseHeader USER_BANK_LIMIT_ERROR = ResponseHeader.newInstance(105032, "查询限额信息失败");




}

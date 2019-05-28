package com.karat.cn.common.enumeration;

/**
 * 系统使用的字符串
 * @author 开发
 *
 */
public class StaticKey {

	/**
	 * 逗号分隔符
	 */
	public static final String SPLITDOT = ",";
	/**
	 * 加密方式
	 */
	public static String ALGORITHMNAME = "MD5";
	/**
	 * 前台用户登录创建的session名称
	 */
	public static String MEMBER_SESSION_KEY = "member";
	/**
	 * 后台用户登录创建的session用户名称
	 */
	public static String BACK_USER_SESSION_KEY = "admin";
	/**
	 * 用户的可操作的方法权限
	 */
	public static String USERROLEFUNCTION = "userrolefunction";
	/**
	 * 后台用户登录创建的session_key
	 */
	public static String BACK_SESSION_KEY = "sessionKey";
	/**
	 * 权限异常标记
	 */
	public static String AUTHORITYEXCEPTION = "authorityexception";


	/**
	 * 用户注册返回字符串
	 */
	public static final String MEMBER_EXIST = "用户已经存在";
	public static final String MEMBER_REGISTER_SUCCESS = "注册成功";
	public static final String EMPTY = "";
	public static final String SC = "sc";
	public static final String ZERO = "0";
	public static final String ONE = "1";
	public static final String TWO = "2";
	public static final String THREE = "3";
	public static final String INTERNATIONAL = "国际";
	public static final String INTERNAL = "国内";
	public static final String WEIGHTMODEL = "重量模式";
	public static final String INSTANTINTERFACE = "即时到帐交易接口";
	public static final String SECUREDINTERFACE = "担保交易接口";
	public static final String STANDARD = "标准双接口";
	public static final String OPEN = "开启";
	public static final String CLOSE = "关闭";
	public static final String YES = "是";
	public static final String NO = "否";
	// 商品属性的静态字段用于json比较取值
	public static final String GOODSATTRIBUTENAME = "goodsattributename";
	public static final String ATTRIBUTETYPE = "attributeType";
	public static final String ATTRIBUTELIST = "attributelist";
	public static final String SORT = "sort";
	public static final String GOODSATTRIBUTEID = "goodsattributeid";
	public static final String SELECTITEM = "筛选项";
	public static final String INPUTITEM = "输入项";
	// 产品规格的静态字段用于json比较取值
	public static final String SPECIFIKEY = "specifikey";
	public static final String SPECIFIVALUE = "specifivalue";
	public static final String SPECIFISORT = "specifisort";
	public static final String WORTTYPE = "颜色类型";
	public static final String IMGTYPE = "图片类型";
	public static final String COLORTYPE = "颜色类型";
	public static final String DEFAULTSPECIFNAME = "默认规格";
	// 商品分类静态字段
	public static final String TOPCA = "顶级分类";
	public static final String TWOCA = "二级分类";
	public static final String THREECA = "三级分类";
	// 商品属性静态字段
	public static final String ATTRVAL = "attrval";
	// 货物静态字段
	public static final String DEFAULT = "默认";
	public static final String ONSALE = "上架";
	public static final String OFFSALE = "下架";
	// 会员静态字段
	public static final String SEXMAN = "男";
	public static final String SEXFEMAL = "女";
	public static final String SEXWHICHMAN = "同性";
	public static final String SEXWHICHFEMAL = "异性";
	public static final String MERRYED = "已婚";
	public static final String UNMERRY = "未婚";
	public static final String BLOODA = "A型";
	public static final String BLOODB = "B型";
	public static final String BLOODAB = "AB型";
	public static final String BLOODO = "O型";
	public static final String DOACTIVE = "激活";
	public static final String DONOTACTIVE = "禁止";
	// 个性化标签json标记
	public static final String TAG = "tag";
	/**
	 * 订单部分
	 */
	// 配送方式
	// 分成快递，平邮，ems，和虚拟类购物方式
	public static final String EXPRESS = "快递";
	public static final String POST = "平邮";
	public static final String EMS = "EMS";
	public static final String CARD = "虚拟充值";
	// 订单显示状态
	public static final String ORDERSTATE_ONE = "已确认";
	public static final String ORDERSTATE_TWO = "货到付款";
	public static final String ORDERSTATE_THREE = "待确认收货";
	public static final String ORDERSTATE_FOUR = "退货";
	public static final String ORDERSTATE_FIVE = "关闭";
	public static final String ORDERSTATE_SIX = "用户已收货";
	public static final String ORDERSTATE_SEVEN = "缺货";
	public static final String ORDERSTATE_EIGHT = "用户删除";
	public static final String ORDERSTATE_NINE = "成功";
	// 会员信息静态字段
	/**
	 * 会员状态 0=未激活
	 */
	public static final String MEMBERSTATE_ZERO_NUM = "0";
	/**
	 * 会员状态 1=激活
	 */
	public static final String MEMBERSTATE_ONE_NUM = "1";
	// 系统用户管理
	public static final String NORMALUSER = "普通用户";
	public static final String MANAGERUSER = "一般管理员";
	public static final String SUPERMANAGER = "超级管理员";
	public static final String ANCHOR = "主播";
	public static final String USERSTATEACTIVE = "激活";
	public static final String USERSTATEUNACTIVE = "未激活";
	//系统操作
	public static final String SYSTEMOPERATION = "系统操作";

}

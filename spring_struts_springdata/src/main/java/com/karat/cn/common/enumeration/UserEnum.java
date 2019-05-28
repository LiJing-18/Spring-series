package com.karat.cn.common.enumeration;

/**
 * 用户账号类型枚举
 * @author 开发
 *
 */
public class UserEnum {
	/**
	 * 用户账号类型
	 * @author 开发
	 *
	 */
	public enum UserType{
		NORMAL("普通用户","1"),SHOPMANAGER("一般管理员","2"),SUPERMANAGER("超级管理员","3"),ANCHOR("主播","0"),navyManager("应用管理员","4"),beautyANCHOR("美女主播","5");
		
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private UserType(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(UserType d: UserType.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 用户状态
	 * @author 开发
	 *
	 */
	public enum UserState{
		ACTIVE("激活","1"),UNACTIVE("未激活","0"),LOCK("锁定","2");
		
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private UserState(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(UserState d: UserState.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}
}

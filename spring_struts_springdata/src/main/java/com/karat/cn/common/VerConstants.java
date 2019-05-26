package com.karat.cn.common;

import org.apache.commons.lang3.StringUtils;
/**
 * 版本号设置
 * @author 开发
 *
 */
public class VerConstants {
	// iOS
	public static String CONST_VER_IOS = "aoneCjhd|cjhd2Aone|BED9NA3R|YD1CR5EP";
	// android
	public static String CONST_VER_ANDROID = "a1.0";
	// 微信小程序
	public static String CONST_VER_WXAPP = "w1.0|3RI9NFAW";
	
	// IOS key
	public static boolean findIosVerKeyState(String ver) {
		if (StringUtils.isNotBlank(ver) && (CONST_VER_IOS.indexOf(ver) >= 0) && ver.length() >= 8) {
			return true;
		}
		return false;
	}

	// Android key
	public static boolean findAndroidVerKeyState(String ver) {
		if (StringUtils.isNotBlank(ver) && (CONST_VER_ANDROID.indexOf(ver) >= 0)) {
			return true;
		}
		return false;
	}

	// Wx key
	public static boolean findWxVerKeyState(String ver) {
		if (StringUtils.isNotBlank(ver) && (CONST_VER_WXAPP.indexOf(ver) >= 0)) {
			return true;
		}
		return false;
	}
	
	// IOS Android Wx (所有平台) key
	public static boolean findAllPlatformVerKeyState(String ver) {
		if (findIosVerKeyState(ver) || findAndroidVerKeyState(ver) || findWxVerKeyState(ver)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(findAllPlatformVerKeyState("aoneCjhd"));
	}
}

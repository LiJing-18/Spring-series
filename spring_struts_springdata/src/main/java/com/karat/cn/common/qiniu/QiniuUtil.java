package com.karat.cn.common.qiniu;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;


public class QiniuUtil {
	private final static String BUCKET = "**********";
	public final static String QINIU_HOST = "*********";
	private final static String ACCESS_KEY = "***********";
	private final static String SECRET_KEY = "**********";
	private final static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	private final static UploadManager uploadManager = new UploadManager();
	private final static BucketManager bucketManager = new BucketManager(auth);
	private static String uptoken;
	private static Date outtime;
	
	
	public static void delete(String key) throws QiniuException{
		bucketManager.delete(BUCKET, key);
	}
	// 上传内存中数据
	public static Map<String, String> uploadForUpdate(byte[] data, String qnpath) throws QiniuException {

		Response res = uploadManager.put(data, qnpath, getUpToken1(qnpath));
		Map<String, String> map = new HashMap<String, String>();
		if (res.isOK()) {
			map.put("code", "200");
			map.put("path", QINIU_HOST + "/" + qnpath);
		} else {
			map.put("code", "400");
		}
		return map;
	}
	
	// 上传内存中数据
	public static Map<String, String> upload(byte[] data, String qnpath) throws QiniuException {

		Response res = uploadManager.put(data, qnpath, getUpToken());
		Map<String, String> map = new HashMap<String, String>();
		if (res.isOK()) {
			map.put("code", "200");
			map.put("path", QINIU_HOST + "/" + qnpath);
		} else {
			map.put("code", "400");
		}
		return map;
	}

	public static Map<String, String> uploadFile(File file, String qnpath) throws QiniuException {
		Response res = uploadManager.put(file, qnpath, getUpToken0());

		Map<String, String> map = new HashMap<String, String>();
		if (res.isOK()) {
			map.put("code", "200");
			map.put("path", QINIU_HOST + qnpath);
		} else {
			map.put("code", "400");
		}
		return map;
	}

	// 简单上传，使用默认策略
	public static String getUpToken0() {
		String uptoken = auth.uploadToken(BUCKET);
		return uptoken;
	}

	// 覆盖上传
	public static String getUpToken1(String pnpath) {
		String uptoken = auth.uploadToken(BUCKET, pnpath);
		return uptoken;
	}

	// 设置指定上传策略
	public static String getUpToken() {
		if (outtime == null || new Date().after(outtime)) {
			int n = 60 * 60 * 12;
			outtime = getOutTime(n);
			uptoken = auth.uploadToken(BUCKET, null, n, null);
		}
		return uptoken;
	}

	// 设置指定上传策略
	public static String getUpToken2() {
		String uptoken = auth.uploadToken(BUCKET, null, 3600, new StringMap().put("callbackUrl", "call back url").putNotEmpty("callbackHost", "").put("callbackBody", "key=$(key)&hash=$(etag)"));
		return uptoken;
	}

	// 设置预处理、去除非限定的策略字段
	public static String getUpToken3() {
		String uptoken = auth.uploadToken(BUCKET, null, 3600, new StringMap().putNotEmpty("persistentOps", "").putNotEmpty("persistentNotifyUrl", "").putNotEmpty("persistentPipeline", ""), true);
		return uptoken;
	}

	private static Date getOutTime(int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, second);
		Date date = calendar.getTime();
		return date;
	}

	public static String getFileName() {
		String uuid = UUID.randomUUID().toString();
		String guid = uuid.replace("-", "").toUpperCase();
		String fileName = guid.substring(8, 24);
		return fileName;
	}

	public static String getFilePathByDate(String fileName) {
		SimpleDateFormat sDateFormat;
		sDateFormat = new SimpleDateFormat("yyyyMMdd");
		String path = sDateFormat.format(new Date());
		return "uploads/" + path + "/" + getFileName() + getFileExtName(fileName);
	}

	public static String getFileExtName(String fileName) {
		String extName = "";
		if (fileName.lastIndexOf(".") >= 0) {
			extName = fileName.substring(fileName.lastIndexOf("."));
		}
		return extName;
	}
}

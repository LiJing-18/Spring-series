package com.karat.cn.controller.back;

import com.karat.cn.common.qiniu.QiniuUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;


/**
 * 图片上传接口
 */
@RestController
@RequestMapping("/")
public class ImgTController {

	/**
	 * 异步图片
	 * @return
	 */
	@RequestMapping("ajaxFileUploads")
	public String ajaxFileUploads(HttpServletRequest request,HttpServletResponse response) {
		String filename = request.getHeader("X-File-Name");
		String filepath = QiniuUtil.getFilePathByDate(filename);
		
		PrintWriter writer = null;
		InputStream inputStream = null;
		try {
			writer = response.getWriter();
			inputStream = request.getInputStream();
			byte[] data = IOUtils.toByteArray(inputStream);
			Map<String, String> map = QiniuUtil.upload(data, filepath);
			String code = map.get("code");
			if ("200".equals(code)) {
				response.setStatus(HttpServletResponse.SC_OK);
				System.out.println(map.get("path"));
				writer.print("{success:'" + map.get("path") + "'}");
			}
		} catch (IOException ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
		} finally {
			try {
				inputStream.close();
			} catch (IOException ignored) {

			}
		}
		writer.flush();
		writer.close();
		return "json";
	}

}
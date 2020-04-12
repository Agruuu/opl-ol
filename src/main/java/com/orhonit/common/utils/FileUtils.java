package com.orhonit.common.utils;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件工具类
 * @author 	池永福
 * @date	2018年4月12日 下午7:53:35
 */
public class FileUtils {
	
	

	
	/**
	 * 获取三级目录   例如:/2018/5/systemTime/
	 * @param basicPath 基础路径
	 * @param systemTime 时间戳
	 * @param date Calendar对象
	 * @param sep  路径通配符
	 * @return
	 */
	public static String getBasicPath(Long systemTime,Calendar date,String sep){
		//Calendar date = Calendar.getInstance();
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		return year+sep+month+sep+systemTime+sep;
	}

	/**
	 * 将服务器文件下载到本地
	 * @param filePath	文件路径
	 * @param response	响应
	 * @param request	请求
	 * @param fileName	文件名称
	 * @param fileType	文件类型
	 * @return
	 */
	public static boolean downLoadFile(String filePath,
			HttpServletResponse response, HttpServletRequest request,
			String fileName) {
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try {
			File file = new File(filePath);
			if(!file.exists()){
				return false ;
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			/*response.setHeader("Content-disposition",
					"attachment; filename=" + new String("稍等好.docx".getBytes("utf-8"), "ISO8859-1"));*/
			//response.setContentType("application/octet-stream");
			bis = new BufferedInputStream(new FileInputStream(file));
			bos=new BufferedOutputStream(response.getOutputStream());
			byte[] data=new byte[2048];
			int index=0;
			while((index=bis.read(data))!=-1){
				bos.write(data, 0, index);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
}

package com.orhonit.common.utils;

import java.io.File;
import java.io.IOException;

//import com.orhonit.nfh.newsmessage.rest.Test;

public class DeleteFileUtil {
	
	   //public static void deleteObj(String url) throws IOException {
////	        //创建文件
////	        File file = new File("d:\\test_file.txt");
//		   this.judgeFileExists(file);
//	//
////	        //创建文件夹
////	        File dir = new File("d:\\hello\\test_dir");
////	        Test.judgeDieExists(dir);
	  //  	File dir = new File(url);
	//    	Test.judgeDieExists(dir);
//	        //删除文件和文件夹
//	        //Test.deleteFile(file);
//	        Test.deleteFile(dir);
//	    }

	    //判断文件是否存在
	    public static void judgeFileExists(File file) {
	        if (file.exists()) {
	            System.out.println("The file exists");
	        } else {
	            System.out.println("File not exists, create it...");
	            try {
	                file.createNewFile();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    //判断文件夹是否存在
	    public static void judgeDieExists(File dir) {
	        if (dir.exists()) {
	            if (dir.isDirectory()) {
	                System.out.println("The dir exits.");
	            } else {
	                System.out.println("The same name file exists, can't create the file.");
	            }
	        } else {
	            System.out.println("The dir doesn't exists, create it.");
	            dir.mkdirs();
	        }

	    }

	    //删除文件或者文件夹
	    public static R deleteFile(File file) {
	        if (file.exists()) {
	            //文件存在
	            System.out.println(file.getAbsolutePath()+" exists.");
	            file.delete();
	            System.out.println("文件删除完成~~");
	            return R.ok();
	        }
	            //文件压根不存在        	
	            System.out.println("文件不存在~~");
	            return R.error("文件不存在~~");
	    }
}

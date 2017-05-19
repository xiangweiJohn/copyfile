package com.zxw.bean;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileContent {
	
	public static void srcCopy2dest(File src, File dest,String suffix) throws IOException {
		File[] subFiles = src.listFiles();
		for (File subFile : subFiles) {
			if(!subFile.getAbsolutePath().equals(dest.getAbsolutePath())) {//如果目的地文件夹是在源文件下就不对其进行遍历
				if (subFile.isFile() && subFile.getName().endsWith(suffix)) {
					File file = new File(dest,subFile.getName());
					file.createNewFile();
					copyContent(subFile,file);
				}  else if (subFile.isDirectory()) {
						srcCopy2dest(subFile,dest,suffix);
				}
			}
				
		}
		
	}
	
	public static void copyContent(File src, File dest) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		
		int b;
		while ((b = bis.read()) != -1) {
			bos.write(b);
		}
		
		bis.close();
		bos.close();
	}
}

package com.zxw.copyfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CooyFile {

	/**
	 * 将原文件夹下的指定文件复制到指定文件路径下
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("请输入源文件夹路径:");
		File src = getFilePath();
		System.out.println("请输入需要目的地文件夹路径:");
		File dest = getFilePath();
		
		String suffix = getFilesuffix();
		
		if (src.equals(dest)) {
			System.out.println("源文件夹路径与目的地文件夹路径相同");
		} else {
			srcCopy2dest(src,dest,suffix);
		}
		
		//demo1();
	}

	public static String getFilesuffix() {
		System.out.println("请输入你要拷贝的文件后缀:");
		Scanner sc = new Scanner(System.in);
		while (true) {
			String suffix = sc.nextLine();//遇到\r\n就判断输入结束,但是并不会把\r\n作为字符赋给suffix
			String regex = "\\s+";
			if (suffix.isEmpty() || suffix.matches(regex)) {//当你之输入回车时,suffix相当于为空,连空白字符都不是!
				System.out.println("你输入的文件后缀为空,请再次输入");
			} else {
				return suffix;
			} 	
		}
	}

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
	
	
	public static File getFilePath() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String line = sc.nextLine();
			File file = new File(line);
			if (!file.exists()) {
				System.out.println("您输入的文件夹路径不存在,请重新输入:");
			} else if (file.isFile()) {
				System.out.println("您输入的文件路径,请输入文件夹路径:");
			} else {
				return file;
			}
		}
	}

}

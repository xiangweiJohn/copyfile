package com.zxw.bean;

import java.io.File;
import java.util.Scanner;

public class GetFilePath {
	public static File getFilePath() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入文件夹路径:");
		
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

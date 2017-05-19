package com.zxw.bean;

import java.util.Scanner;

public class GetFileSuffix {
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
}

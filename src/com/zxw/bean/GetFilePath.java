package com.zxw.bean;

import java.io.File;
import java.util.Scanner;

public class GetFilePath {
	public static File getFilePath() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ļ���·��:");
		
		while (true) {
			String line = sc.nextLine();
			File file = new File(line);
			if (!file.exists()) {
				System.out.println("��������ļ���·��������,����������:");
			} else if (file.isFile()) {
				System.out.println("��������ļ�·��,�������ļ���·��:");
			} else {
				return file;
			}
		}
	}
}

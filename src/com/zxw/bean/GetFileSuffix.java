package com.zxw.bean;

import java.util.Scanner;

public class GetFileSuffix {
	public static String getFilesuffix() {
		System.out.println("��������Ҫ�������ļ���׺:");
		Scanner sc = new Scanner(System.in);
		while (true) {
			String suffix = sc.nextLine();//����\r\n���ж��������,���ǲ������\r\n��Ϊ�ַ�����suffix
			String regex = "\\s+";
			if (suffix.isEmpty() || suffix.matches(regex)) {//����֮����س�ʱ,suffix�൱��Ϊ��,���հ��ַ�������!
				System.out.println("��������ļ���׺Ϊ��,���ٴ�����");
			} else {
				return suffix;
			} 	
		}
	}
}

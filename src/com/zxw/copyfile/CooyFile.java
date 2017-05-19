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
	 * ��ԭ�ļ����µ�ָ���ļ����Ƶ�ָ���ļ�·����
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("������Դ�ļ���·��:");
		File src = getFilePath();
		System.out.println("��������ҪĿ�ĵ��ļ���·��:");
		File dest = getFilePath();
		
		String suffix = getFilesuffix();
		
		if (src.equals(dest)) {
			System.out.println("Դ�ļ���·����Ŀ�ĵ��ļ���·����ͬ");
		} else {
			srcCopy2dest(src,dest,suffix);
		}
		
		//demo1();
	}

	public static void demo1() throws IOException, FileNotFoundException {
		String name1 = "day21note.md";
		String name2 = "day21note.md";
		File file1 = new File(name1);
		file1.createNewFile();
		System.out.println(file1);
		System.out.println(file1.exists());
		File file2 = new File(name2);
		System.out.println(file2);
		file2.createNewFile();
		System.out.println(file2.exists());
		
		System.out.println(file1 == file2);
		
		FileInputStream fis1 = new FileInputStream(file1);
		System.out.println(fis1);
		FileInputStream fis2 = new FileInputStream(file2);
		System.out.println(fis2);
		
		System.out.println(file1.getAbsolutePath());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file1.getAbsolutePath() == file2.getAbsolutePath());//��Ȼfile1��file2�ľ���·����ͬ,������==�Ƚϵ��ǵ�ֵַ
		System.out.println(file1.getAbsolutePath().equals(file2.getAbsolutePath()));
		System.out.println("D:\\˫Ԫ����\\copyfile\\day21note.md" == "D:\\˫Ԫ����\\copyfile\\day21note.md");
	}
	
	
	
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

	public static void srcCopy2dest(File src, File dest,String suffix) throws IOException {
		File[] subFiles = src.listFiles();
		for (File subFile : subFiles) {
			if(!subFile.getAbsolutePath().equals(dest.getAbsolutePath())) {//���Ŀ�ĵ��ļ�������Դ�ļ��¾Ͳ�������б���
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
				System.out.println("��������ļ���·��������,����������:");
			} else if (file.isFile()) {
				System.out.println("��������ļ�·��,�������ļ���·��:");
			} else {
				return file;
			}
		}
	}

}

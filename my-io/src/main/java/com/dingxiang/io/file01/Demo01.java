package com.dingxiang.io.file01;

import java.io.File;

/**
 * ��������
 * 1��·���ָ���  ;
 * 2�����Ʒָ��� /(windows)  /(linux ��)
 *
 *
 * @author Administrator
 *
 */
public class Demo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(File.pathSeparator);
		System.out.println(File.separator);

		//·����ʾ��ʽ
		String path ="E:\\xp\\test\\2.jpg";
		path="E:"+File.separator+"xp"+File.separator+"test"+File.separator+"2.jpg";
		//�Ƽ���ʽ
		path="E:/xp/test/2.jpg";
	}
}
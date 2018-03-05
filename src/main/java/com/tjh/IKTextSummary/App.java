package com.tjh.IKTextSummary;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			System.out.println("开始NLP。。。。");
			String tdemp = ArticleSummary.getSummary("据警方通报，孟某在群内其他网友质疑其侮辱南京大屠杀死难者时，他发表“侮辱了怎么样”、“杀少了”、“才三十万而已”等言论，遭到众网友的一致指责。警方调查后认为，孟某为“泄私愤”，罔顾民族感情，通过互联网群组肆意侮辱、谩骂死难同胞，伤害了人民群众的爱国情感，造成不良的社会影响。根据《中华人民共和国治安管理处罚法》规定，孟某的行为构成寻衅滋事，杨浦警方依法对其予以行政拘留5日。",4);
			System.out.println(tdemp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

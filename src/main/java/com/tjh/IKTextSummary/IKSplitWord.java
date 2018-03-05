package com.tjh.IKTextSummary;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

/**
 * IK分词
 * 
 * @author xukong
 *
 */
public class IKSplitWord {
	/**
	 * 分割词语
	 * 
	 * @param txt
	 * @return
	 * @throws IOException
	 */
	public static List<String> segementWord(String txt) throws IOException {
		List<String> result = new ArrayList<String>();
		StringReader sr = new StringReader(txt);
		// true代表不是细颗粒的分词
		IKSegmenter ik = new IKSegmenter(sr, true);
		Lexeme lex = null;
		while ((lex = ik.next()) != null) {
			String temp = lex.getLexemeText();
			result.add(temp);
		}

		return result;
	}
}

package com.tjh.IKTextSummary;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式管理
 * 
 * @author xukong
 *
 */
public class RegexManager {
	/**
	 * 根据标点符号进行分割字符串
	 * 
	 * @param matchStr
	 * @param regexStr
	 * @return
	 */
	public static List<String> getSymbolMatchResult(String matchStr, String regexStr) {
		List<String> result = new ArrayList<String>();
		Pattern word = Pattern.compile(regexStr);
		Matcher m = word.matcher(matchStr);
		while (m.find()) {
			result.add(m.group());
		}
		
		return result;
	}
}

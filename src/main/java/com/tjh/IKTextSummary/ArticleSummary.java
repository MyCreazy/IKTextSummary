package com.tjh.IKTextSummary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 文章摘要
 * 
 * @author xukong
 *
 */
public class ArticleSummary {
	/**
	 * 获取摘要
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String getSummary(String article, int wordNumber) throws IOException {
		String result = "";
		//// 获取中文停用词
		List<String> stopWordList = TxtFileManager.readTxt("E:\\工作\\开发\\JAVA\\IKTextSummary\\stopword.txt");
		//// 进行分词
		List<String> wordList = IKSplitWord.segementWord(article);
		//// 去掉分的词语中的停用词
		List<String> newWordList = new ArrayList<String>();
		String tempwordstr = Arrays.toString(wordList.toArray());
		Iterator tempit = wordList.iterator();
		while (tempit.hasNext()) {
			String te = (String) tempit.next();
			boolean ishave = false;
			for (String tempword : stopWordList) {
				if (te.contains(tempword)) {
					ishave = true;
					break;
				}

				if (!false) {
					////这种词语不是停用词
					newWordList.add(te);
				}
			}
		}

		//// 统计每个词语出现的频率
		Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
		Iterator it = newWordList.iterator();
		while (it.hasNext()) {
			int count = 0;
			String temp = (String) it.next();
			if (wordFrequency.containsKey(temp)) {
				count = wordFrequency.get(temp);
			}

			wordFrequency.put(temp, count + 1);
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(wordFrequency.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			// 降序排序
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// return o1.getValue().compareTo(o2.getValue());
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		//// 拿到高频词汇
		List<String> newwordFrequency = new ArrayList<String>();
		int tempcount = 0;
		for (Map.Entry<String, Integer> mapping : list) {
			tempcount++;
			if (tempcount > wordNumber) {
				break;
			}
			newwordFrequency.add(mapping.getKey());
		}

		//// 拿到这些高频词汇所在的句子
		List<String> wordSplitResult = RegexManager.getSymbolMatchResult(article, "(.*?)(?=，|；|。|！)");
		Iterator wordit = newwordFrequency.iterator();
		List<String> finallyWordList = new ArrayList<String>();
		while (wordit.hasNext()) {
			String temp = (String) wordit.next();
			//// 判断属于哪一句
			Iterator tempit1 = wordSplitResult.iterator();
			while (tempit1.hasNext()) {
				String temparticleword = (String) tempit1.next();
				if (temparticleword != "") {
					if (temparticleword.contains(temp)) {
						//// 这个句子需要，然后跳出
						finallyWordList.add(temparticleword);
						break;
					}
				}
			}
		}

		//// 对获取的句子去除重复
		finallyWordList = WordUtil.removeDuplicate(finallyWordList);
		result=org.apache.commons.lang.StringUtils.join(finallyWordList.toArray(),",");  
		return result;
	}
}

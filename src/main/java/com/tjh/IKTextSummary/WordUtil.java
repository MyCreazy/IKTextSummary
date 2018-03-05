package com.tjh.IKTextSummary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 语句辅助工具
 * 
 * @author xukong
 *
 */
public class WordUtil {
	/**
	 * 去除重复
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> removeDuplicate(List<String> list) {
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);

		return list;
	}
}

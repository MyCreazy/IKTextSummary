package com.tjh.IKTextSummary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 文本管理
 * 
 * @author xukong
 *
 */
public class TxtFileManager {
	/**
	 * 读取文本
	 * @param pathname
	 * @return
	 * @throws IOException
	 */
	public static List<String> readTxt(String pathname) throws IOException {
		List<String> result = new ArrayList<String>();
		InputStreamReader reader = null;
		try {
			File filename = new File(pathname);
			reader = new InputStreamReader(new FileInputStream(filename));
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (line != "") {
					result.add(line);
				}
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		return result;
	}
}

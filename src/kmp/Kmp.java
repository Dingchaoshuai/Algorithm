package kmp;

import java.util.Arrays;

public class Kmp {
	public static void main(String[] args) {
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		int[] next = kmpNext(str2);
		int index = kmpSearch(str1, str2, next);
		System.out.println(index);
		//System.out.println(Arrays.toString(next));
	}
	//写出kmp搜索
	/**
	 * 
	 * @param str1 源字符串
	 * @param str2 字串
	 * @param next next部分匹配表
	 * @return
	 */
	public static int kmpSearch(String str1,String str2,int[] next) {
		//遍历str1
		for( int i = 0, j = 0; i < str1.length(); i++) {
			//需要处理str1.charAt(i) ！= str2.charAt(j)
			//核心
			while(j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j - 1];
			}
			if(str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if(j == str2.length()) {
				return i - j + 1;
			}
		}
		return -1;
	}
	//获取到字串的部分匹配值表
	public  static int[] kmpNext(String dest) {
		//创建一个next数组保存部分匹配值
		int[] next = new int[dest.length()];
		next[0] = 0;//如果dest是只有一个字符  部分匹配值为0
		for(int i = 1 , j = 0; i < dest.length();i++) {
			//当dest.charAt(i)！= dest.charAt(j) 需要从next[j-1] 获取新的j
			//直到dest.charAt(i)== dest.charAt(j)成立才退出
			while(j > 0 && dest.charAt(i)!= dest.charAt(j)) {
				j = next[j- 1];
			}
			//当dest.charAt(i)== dest.charAt(j)满足时，部分匹配值+1
			if(dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}

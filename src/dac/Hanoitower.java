package dac;

public class Hanoitower {

	public static void main(String[] args) {
		
	}
	
	//汉诺塔移动方案
	//分治算法
	public static void hanoiTpwer(int num,char a,char b, char c) {
		//如果只有一个盘
		if(num == 1) {
			System.out.println("从第1个盘从" + a + "->" + c);
		}
	}
}

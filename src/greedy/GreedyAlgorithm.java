package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
	public static void main(String[] args) {
		//创建广播电台放入一个map
		HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
		//将各个电台放入broadcasts
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("上海");
		hashSet2.add("深圳");
		
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("上海");
		hashSet4.add("天津");
		
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("杭州");
		hashSet5.add("大连");
		
		//加入到map
		broadcasts.put("k1", hashSet1);
		broadcasts.put("k2", hashSet2);
		broadcasts.put("k3", hashSet3);
		broadcasts.put("k4", hashSet4);
		broadcasts.put("k5", hashSet5);
		
		//存放所有地区
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("北京");
		allAreas.add("上海");
		allAreas.add("天津");
		allAreas.add("广州");
		allAreas.add("深圳");
		allAreas.add("成都");
		allAreas.add("杭州");
		allAreas.add("大连");
		
		// a 创建一个ArrayList 存放选择的 电台
		ArrayList<String> selects = new  ArrayList<String>();
		
		// a 定义一个临时的集合，在遍历过程中，存放遍历过程中电台覆盖的地区和当前未覆盖地区的交集
		HashSet<String> tempSet = new HashSet<String>();
		
		//a 定义一个maxkey 保存在一次遍历过程中，能够覆盖最大未覆盖地区对应的电台key
		String maxkey = null;
		//a 记录maxkey对应地区的个数
		int maxkeySize =0;
		
		//a 如果maxkey不为null，则加入到selects
		while(allAreas.size() > 0) {
			//a 每进行一次循环
			maxkey = null;
			for(String key : broadcasts.keySet()) {
				//a 每一次for 将tempset清空
				tempSet.clear();
				//a 得到当前key对应的地区
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				//a 取当前覆盖的地区和未覆盖地区的交集 交集会赋给tempset
				tempSet.retainAll(allAreas);
				if(tempSet.size() > 0 && (maxkey == null || tempSet.size() > maxkeySize)) {
					maxkey = key;
					maxkeySize = tempSet.size();
				}
			}
			//a 如果maxkey != null 需要将maxkey加入selects
			if(maxkey != null) {
				selects.add(maxkey);
				//a 将maxkey对应的地区从总地区中删除
				allAreas.removeAll(broadcasts.get(maxkey));
			}
		}
		
		System.out.println(selects);
	}
}

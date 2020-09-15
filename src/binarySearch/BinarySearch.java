package binarySearch;
/**
 * 二分查找非递归实现
 * @author DC
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		//测试
		int[] arr = {1,3,8,10,11,67,100};
		int index = binarySearch(arr, 100);
		System.out.println("index=" + index);
	}
	
	/**
	 * 
	 * @param arr 数组 升序排列
	 * @param target 要查找的数
	 * @return 返回对应下标 没有找到-1
	 */
	public static int binarySearch(int[] arr,int target) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right ) / 2;
 			if(arr[mid] == target) {
 				return mid;
 			}else if(arr[mid] > target) {
 				right = mid -1;
 			}else {
 				left = mid + 1; 
 			}
		}
		return -1;
	}
}

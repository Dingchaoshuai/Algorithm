package Dynamic;
/**
 * 背包问题
 * @author DC
 *
 */
public class KnapsackProblem {
	public static void main(String[] args) {
		int[] w = {1,4,3};//物品重量
		int[] val = {1500,3000,2000};//价值 对应公式val
		int m = 4;//背包容量
		int n = val.length;//物品的个数
		
		//创建二维数组
		//v[i][j] 表示在i个物品中能够装入容量为j 的背包的最大价值
		int[][] v = new int[n+1][m+1];
		
		//初始化第一行第一列
		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0;//第一列设置为0
		}
		for (int i = 0; i < v[0].length; i++) {
			v[0][i] = 0;//第一行设置为0
		}
		//为了记录放入商品的情况，
		int[][] path = new int[n+1][m+1];
		//根据公式动态规划
		for(int i = 1; i < v.length; i++) {//不处理第一行
			for(int j = 1; j< v[0].length;j++) {//不处理第一列
				if(w[i - 1] > j) {//因为程序i从1开始，因此公式中的w[i] 修改成w[i-1]
					v[i][j] = v[i-1][j];
				}else {
					//因为i从1开始  公式需要调整
					//v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
					//为了记录商品的情况，不能直接使用上面的公式
					if(v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]) {
						v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
						//把当前情况记录到path
						path[i][j] = 1;
					}else {
						v[i][j] = v[i-1][j];
					}
					
				}
			}
		}
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
	}
}
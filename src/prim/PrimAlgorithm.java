package prim;

import java.util.Arrays;

public class PrimAlgorithm {
	public static void main(String[] args) {
		//测试图
		char[] data = new char[]{'A','B','C','D','E','F','G'};
		int verxs = data.length;
		int[][] weight = new int[][] {
			{10000,5,7,10000,10000,10000,2},
			{5,10000,10000,9,10000,10000,3},
			{7,10000,10000,10000,8,10000,10000},
			{10000,9,10000,10000,10000,4,10000},
			{10000,10000,8,10000,10000,5,4},
			{10000,10000,10000,4,5,10000,6},
			{2,3,10000,10000,4,6,10000},
		};
		
		MGraph mGraph = new MGraph(verxs);
		minTree minTree = new minTree();
		minTree.createGraph(mGraph, verxs, data, weight);
		minTree.showGraph(mGraph);
		
		//测试prim
		minTree.prim(mGraph, 0);
	}
}
class minTree{
	//创建图的邻接矩阵
	public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
		int i , j;
		for(i = 0; i < verxs; i++) {
			graph.data[i] = data[i];
			for(j = 0; j < verxs; j++) {
				graph.weight[i][j] = weight[i][j];
			}
		}
	}
	public void showGraph(MGraph graph) {
		for(int[] link : graph.weight) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	//编写prim算法
	/**
	 *  
	 * @param graph  
	 * @param v 起始顶点
	 */
	public void prim(MGraph graph ,int v) {
		int[] visited = new int[graph.verxs];//标记节点是否被访问过
		
		visited[v] = 1;//把当前节点标记为以访问
		
		int h1 = -1;
		int h2 = -1;//使用两个顶点来记录访问的两个顶点
		int minWeight = 10000;
		
		for(int k = 1; k < graph.verxs; k++) {//有graph.verxs个顶点，就有graph.verxs-1边
			//确定每次生成的子图，和哪个节点距离最近
			for(int i = 0; i < graph.verxs; i++) {//i表示以访问
				if(visited[i] == 1) {
					for(int j = 0; j < graph.verxs; j++) {//j表示未访问
						if(visited[j] == 0 && graph.weight[i][j] < minWeight) {
							minWeight = graph.weight[i][j];
							h1 = i;
							h2 = j;
						}
					}
				}
			}
			System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">权值：" + minWeight);
			//将h2标记为以访问
			visited[h2] = 1;
			minWeight = 10000;
		}
	}
}
class MGraph{
	int verxs;//节点个数
	char[] data;//节点数据
	int[][] weight;//邻接矩阵
	
	public MGraph(int verxs) {
		this.verxs = verxs;
		data = new char[verxs];
		weight = new int[verxs][verxs];
	}
}
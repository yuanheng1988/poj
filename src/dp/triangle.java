package dp;

import java.util.Scanner;

public class triangle {
	static int MAX_NUM = 100;
	static int[][] value = new int[MAX_NUM + 10][MAX_NUM + 10];
	static int[][] aMaxSum = new int[MAX_NUM + 10][MAX_NUM + 10];
	static int[][] next = new int[MAX_NUM + 10][MAX_NUM + 10];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int rowNum = scanner.nextInt();
		for(int i = 1; i <= rowNum; i++){
			for(int j = 1; j <= i; j++){
				value[i][j] = scanner.nextInt();
			}
		}
		
		for(int j = 1; j <= rowNum; j++){
			aMaxSum[rowNum][j] = value[rowNum][j];
		}
		for(int i = rowNum; i > 1; i--)
			for(int j = 1; j < i; j++){
				if(aMaxSum[i][j] > aMaxSum[i][j+1]){
					aMaxSum[i-1][j] = aMaxSum[i][j] + value[i-1][j];
					next[i-1][j] = j;
				}
				else{
					aMaxSum[i-1][j] = aMaxSum[i][j+1] + value[i-1][j];
					next[i-1][j] = j+1;
				}
		}
		System.out.println(aMaxSum[1][1]);
		System.out.print(value[1][1]);
		int index = next[1][1];
		for(int i = 2; i <= rowNum; i++){
			System.out.print(" " + value[i][index]);
			index = next[i][index];
		}
	}
}
   
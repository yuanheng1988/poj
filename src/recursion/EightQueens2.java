package recursion;

import java.util.Scanner;

public class EightQueens2 {
	static int[][] ans = new int[92][8];
	static int[] hang = new int[8];
	static int count = 0;
	
	public static void queen(int ithQueen){
		if(ithQueen == 8){
			for(int i = 0;i < 8; i++){
				ans[count][i] = hang[i] + 1;
			}
			count++;
			return;                    //��仰���������ú�����ֱ�ӻص���һ�㣬��Ȼ��������һ�������forѭ��
		}        
		for(int j = 0; j < 8;j++){
			int k;
			for(k = 0;k < ithQueen; k++){
				if(hang[k] == j || Math.abs(hang[k]-j) == Math.abs(k-ithQueen))
					break;
      			}
			if(k == ithQueen){
				hang[ithQueen] = j;
				queen(ithQueen+1);
			}
		}
	}
	
	public static void main(String[] args){
		queen(0);
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for(int i = 0; i<num; i++){
			int order = scanner.nextInt();
			for(int j=0;j<8;j++){
				System.out.print(ans[order-1][j]);
			}
			System.out.println();
		}
	}
	

}

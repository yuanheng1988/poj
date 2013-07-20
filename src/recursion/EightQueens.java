package recursion;

import java.util.Scanner;

public class EightQueens {
	
	static int count = 0;
	static int[][] queenPlaces = new int[92][8];
	static int[][] board = new int[8][8];
	
	public static void main(String[] args){
		for(int i = 0; i<8; i++){
			for(int j = 0; j<8; j++)
				board[i][j] = -1;
			for(int k = 0;k < 92;k++){
				queenPlaces[k][i] = 0;
			}
		}
		putQueen(0);
		int num = new Scanner(System.in).nextInt();
		for(int i = 0;i < num; i++){
			int ith = new Scanner(System.in).nextInt();
			for(int j = 0; j < 8; j++){
				System.out.print(queenPlaces[ith-1][j]);
			}
			System.out.println("\n");
		}
	}
	
	public static void putQueen(int ithQueen){
		if (ithQueen == 8){
			count++;
			return;
		}
		for(int i = 0; i < 8; i++){
			if(board[i][ithQueen] == -1){
				board[i][ithQueen] = i;
			}
			
			//couldn't understand...
			for(int k = count;k < 92; k++){
				queenPlaces[k][ithQueen] = i+1;
			}
			for(int k = 0; k<8;k++){
				for(int t = 0; t<8;t++){
					if(board[k][t] == -1 && (k==i||t==ithQueen||Math.abs(k-i)==Math.abs(t-ithQueen)))
						board[k][t] = ithQueen;
				}
			}
			putQueen(ithQueen + 1);
			//»ØËÝ
			for(int k = 0; k < 8; k++){
				for(int t=0; t<8; t++)
					if(board[k][t] == ithQueen)
						board[k][t] = -1;
			}
			
		}
	}
}

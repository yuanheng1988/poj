package dp;

import java.util.Arrays;
import java.util.Scanner;

public class MaxComSubSequence {
	static int MAX_NUM = 200;
	static int[][] aMaxLen = new int[MAX_NUM + 10][MAX_NUM + 10];
	static String s1;
	static String s2;
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		s1 = scanner.next();
		s2 = scanner.next();
		while(s1 != null && s2 != null){
			for(int i = 0; i < aMaxLen.length; i++){
				Arrays.fill(aMaxLen[i], -1);
			}
			System.out.println(MaxLen(s1.length(),s2.length()));
			s1 = scanner.next();
			s2 = scanner.next();
		}
		
	}
	
	public static int MaxLen(int i, int j){
		if(i == 0 || j == 0)
			return 0;
		else if(s1.charAt(i-1) == s2.charAt(j-1)){
			if(aMaxLen[i][j] == -1)
				aMaxLen[i][j] = MaxLen(i-1,j-1) + 1;
			return aMaxLen[i][j];
		}
		else{
			if(aMaxLen[i][j] == -1)
				aMaxLen[i][j] = Math.max(MaxLen(i-1,j), MaxLen(i,j-1));
			return aMaxLen[i][j];
		}
	}
	
}

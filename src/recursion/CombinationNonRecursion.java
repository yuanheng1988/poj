package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationNonRecursion {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		char[] str = scanner.next().toCharArray();
		int len = str.length;
		char[] tmp;
		for(int i = 1; i < (1<<len); i++){
			tmp = Integer.toBinaryString(i).toCharArray();
			for(int j = 0; j < tmp.length; j++){
				if(tmp[j] == '1')
					System.out.print(str[len-1-(tmp.length-1-j)]);
			}
			System.out.println();
		}
	}

}

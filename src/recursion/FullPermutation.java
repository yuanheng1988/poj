package recursion;

import java.util.Arrays;

public class FullPermutation {
	static String tmpStr = null;
	
	public static void main(String[] args){
		char[] str = "abca".toCharArray();
		permutation(str, 0, str.length);
	}
	
	public static void permutation(char[] orig,int start, int end){
		if(start == end){
			for(int i = 0; i < end; i++){
				System.out.print(orig[i]);
			}
			System.out.println();
		}
		for(int i = start; i < end; i++){
			if(isSwapable(orig, start, i)){
				char tmp = orig[start];
				orig[start] = orig[i];
				orig[i] = tmp;
				permutation(orig,start + 1,end);
				orig[i] = orig[start];
				orig[start] = tmp;
			}
		}
	}

	private static boolean isSwapable(char[] orig, int start, int end) {
		// TODO Auto-generated method stub
		/*for(int i = start; i < end; i++){
			if(orig[i] == orig[end])
				return false;
		}*/
		return true;
	}
}

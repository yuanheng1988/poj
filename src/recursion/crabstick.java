package recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class crabstick { 
	static Integer[] sticks = new Integer[100];
	static boolean[] used = new boolean[100];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int stickNum = scanner.nextInt();
		int sum;
		while(stickNum != 0){
			sum = 0;
			for(int i = 0;i < 100; i++){
				sticks[i] = 0;
				used[i] = false;
			}
			for(int i=0;i<stickNum;i++){
				sticks[i] = scanner.nextInt();
				sum += sticks[i];
			}
			Arrays.sort(sticks,Collections.reverseOrder());
			int len = sticks[0];       //��¼��󳤶�
			for(int i = len; i <= sum; i++){         //�Ⱥź���Ҫѽ��һ���������Ҫ
				if(sum%i != 0)
					continue;
				if(concatenate(stickNum,0,sum/i,i)){
//				if(concatenate(stickNum,0,stickNum,i)){
					System.out.println(i); 
					break;
				}
			}
			stickNum = scanner.nextInt();
		}
	}

	public static boolean concatenate(int totalSticks, int left, int concatNum, int length) {
		if(left == 0 && concatNum == 0)
			return true;
		if(left == 0){
			left = length;
			concatNum--;
		}
		for(int i = 0; i < totalSticks; i++){
			if(used[i] == true)
				continue;
			if(sticks[i] > left)
				continue;
			used[i] = true;
			if(concatenate(totalSticks,left-sticks[i],concatNum,length))
				return true;
			//�����true���򷵻�true����������㣬����Ծ�����֦���ٷ��ء�
			used[i] = false;
			if(sticks[i] == left || left == length){
				break;
			}
		}
		return false;
	}

}

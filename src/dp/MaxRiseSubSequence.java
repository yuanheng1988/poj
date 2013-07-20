package dp;

import java.util.Scanner;

public class MaxRiseSubSequence {
	static int MAX_LENGTH = 1000;
	static int sequence[] = new int[MAX_LENGTH + 10];
	static int[] aMaxSub = new int[MAX_LENGTH + 10];
	static int[] previous = new int[MAX_LENGTH + 10];
//	static int[] maxValue = new int[MAX_LENGTH + 10];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int seqLength = scanner.nextInt();
		for(int i = 0; i < seqLength; i++){
			sequence[i] = scanner.nextInt();
			aMaxSub[i] = 1;
			previous[i] = -1;
		}
		for(int i = 1; i < seqLength; i++){
			for(int j = 0; j < i; j++){
				//poj�ύ�汾
/*				if(sequence[i] > sequence[j]){
					aMaxSub[i] = Math.max(aMaxSub[i], aMaxSub[j] + 1);
				}*/
				//����·��
				if(sequence[i] > sequence[j] && aMaxSub[i] < aMaxSub[j] + 1){
					aMaxSub[i] = aMaxSub[j] + 1;
					previous[i] = j;
				}
			}
		}
		int max = aMaxSub[0];
		//poj�ύ
/*		for(int i = 1; i < seqLength; i++){
			if(max < aMaxSub[i])
				 max = aMaxSub[i];
		}*/
		//����·��
		int index = 0;
		for(int i = 1; i < seqLength; i++){
			if(max < aMaxSub[i]){
				max = aMaxSub[i];
				index = i;
			}
		}
		System.out.println(max);
		int[] result = new int[seqLength];
		result[0] = sequence[index];
		int tmp = previous[index];
		for(int i = 1; tmp != -1; i++){
			result[i] = sequence[tmp];
			tmp = previous[tmp];
		}
		for(int j = result.length-1; j >= 0; j--){
			if(result[j] == 0)
				continue;
			System.out.print(" " + result[j] );
		}
	}
}

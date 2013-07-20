package dp;

import java.util.Arrays;
import java.util.Scanner;


//0/1 knapsack
/**
 * @author xukexin
 *
 *
�������ݣ�
10	34
2	15
7	25
3	8
4	9
8	15
5	9
8	13
6	9
4	6
16	14
87
 */
public class Knapsack {
	static final int MAX_NUM = 3402;
	static final int MAX_WEIGHT = 12880;
	static int[] weight = new int[MAX_NUM + 10];
	static int[] value = new int[MAX_NUM + 10];
	static int[][] aMaxValue = new int[MAX_NUM + 10][12880];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		for(int i = 0; i < N; i++){
			weight[i] = scanner.nextInt();
			value[i] = scanner.nextInt();
		}
		for(int i = 0; i < N; i++){
			Arrays.fill(aMaxValue[i], -1);
		}
		System.out.println(MaxValue(N-1,M)); 
	}
	
	public static int MaxValue(int index, int leftWeight){
		if(index == 0){
			return weight[index]<=leftWeight?value[index]:0;              //��Ҫ�������������0�ĳɸ����
		}
		if(weight[index] <= leftWeight){
			if(aMaxValue[index-1][leftWeight] == -1)
				aMaxValue[index-1][leftWeight] = MaxValue(index-1,leftWeight);
			if(aMaxValue[index-1][leftWeight-weight[index]] == -1)
				aMaxValue[index-1][leftWeight-weight[index]] = MaxValue(index-1,leftWeight-weight[index]);
			aMaxValue[index][leftWeight] = Math.max(aMaxValue[index-1][leftWeight], aMaxValue[index-1][leftWeight-weight[index]]+ value[index]);
//			return Math.max(MaxValue(index-1,leftWeight), MaxValue(index-1,leftWeight-weight[index]) + value[index]);
   		}
		else{
			if(aMaxValue[index-1][leftWeight] == -1)
				aMaxValue[index-1][leftWeight] = MaxValue(index-1,leftWeight);
			aMaxValue[index][leftWeight] = aMaxValue[index-1][leftWeight];
//			return MaxValue(index-1,leftWeight);
		}
		return aMaxValue[index][leftWeight];	
	}	
}

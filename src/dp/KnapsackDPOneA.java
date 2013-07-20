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
public class KnapsackDPOneA {
	static final int MAX_NUM = 3402;
	static final int MAX_WEIGHT = 14000;
	static int[] weight = new int[MAX_NUM + 10];
	static int[] value = new int[MAX_NUM + 10];
	static int[] aMaxValue = new int[MAX_WEIGHT];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		for(int i = 1; i <= N; i++){
			weight[i] = scanner.nextInt();
			value[i] = scanner.nextInt();
		}
		Arrays.fill(aMaxValue, 0);          //��aMaxValue[0:N]ȫ����Ϊ0�����Բ�װ������Ҫ��ȫװ������aMaxValue[0]����0������aMaxValue[1:N]Ϊ������
		//һά����
		for(int i = 1; i <= N; i++){
			for(int j = M; j >= 0; j--){
				if(weight[i] <= j){
					aMaxValue[j] = Math.max(aMaxValue[j], aMaxValue[j-weight[i]] + value[i]);
				}
			}
		}
		System.out.println(aMaxValue[M]); 
	}
}

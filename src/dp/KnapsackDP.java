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
public class KnapsackDP {
	static final int MAX_NUM = 3402;
	static final int MAX_WEIGHT = 14000;
	static int[] weight = new int[MAX_NUM + 10];
	static int[] value = new int[MAX_NUM + 10];
	static int[][] aMaxValue = new int[MAX_NUM + 10][MAX_WEIGHT];
	static int[][] path = new int[MAX_NUM + 10][MAX_WEIGHT];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		for(int i = 1; i <= N; i++){
			weight[i] = scanner.nextInt();
			value[i] = scanner.nextInt();
		}
		Arrays.fill(aMaxValue[0], -10000);             //��ʼ��Ϊ0���߸�����
		aMaxValue[0][0] = 0;                           //���ｫaMaxValue[0][1:N]��ɸ����aMaxValue[0][0]���0��
		for(int i = 1; i <= N; i++){
			for(int j = 0; j <= M; j++){
				aMaxValue[i][j] = aMaxValue[i-1][j];
				path[i][j] = 0;                         //����·��������ʱҪ�ø�Ϊpath[i][j] = path[i-1][j];
				if(weight[i] <= j){
//					aMaxValue[i][j] = Math.max(aMaxValue[i-1][j], aMaxValue[i-1][j-weight[i]] + value[i]);
					if(aMaxValue[i-1][j-weight[i]] + value[i] > aMaxValue[i-1][j]){
						aMaxValue[i][j] = aMaxValue[i-1][j-weight[i]] + value[i];
						path[i][j] = i;
					}
				}
			}
		}
		System.out.println(aMaxValue[N][M]); 
		//����·��
		//����һ�������¼·�������ڸ���ʱ��¼
		int w = M;
		for(int i = N; i >=1;i--){
			if(path[i][w] != 0){
				System.out.print(path[i][w]);
			}
			w -= weight[path[i][w]];
		}
		
		//��������pathҪ���ּ�¼��������ʱpathҲҪ��¼
		/*for(int i = N; i >=1;){
			System.out.print(path[i][w]);
			int tmp = i;
			i = path[i][w]-1;
			w -= weight[path[tmp][w]];
			}*/
		
		//���������������¼path·����ͨ��aMaxValue�������·��
		/*int W = M;
		for (int i = N; i >= 1; --i) {
	        for (int j = W; j >= 1; --j) {
	            if (aMaxValue[i][j] == aMaxValue[i-1][j]) {
	                System.out.println("û��ѡ�����Ʒ��\n");;
	                break;
	            }
	            else if (aMaxValue[i][j] == aMaxValue[i][j-weight[i]]+value[i]) {
	                System.out.println("ѡȡ�˵�" + i + "����Ʒ\n");
	                W -= weight[i];
	                break;
	            }
	        }
	    }*/
	}
}

package dp;

public class Solution {
    public static int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        // write your code here...
    	long centre1X = (K + M)/2;
    	long centre1Y = (L + N)/2;
    	long centre2X = (P + R)/2;
    	long centre2Y = (Q + S)/2;
    	long length1X = M - K;
    	long length1Y = N - L;
    	long length2X = R - P;
    	long length2Y = S - Q;
    	long d1 = (length1X+length2X)/2 - Math.abs(centre1X-centre2X);
    	long d2 = (length1Y+length2Y)/2 - Math.abs(centre1Y-centre2Y);
    	long sum = length1X*length1Y + length2X*length2Y;
    	
    	if(d1 > Math.min(length1X, length2X)){
    		d1 = Math.min(length1X, length2X);
    	}
    	if(d2 > Math.min(length1Y, length2Y)){
    		d2 = Math.min(length1Y, length2Y);
    	}
    	if(d1 > 0 && d2 > 0){
    		sum -= d1*d2;
    	}
    	if(sum > 2147483647)
    		sum = -1;
    	return (int) sum;
    } 
    
   public static void main(String[] args){
	   System.out.println(solution(-4, 1, 2, 6, 0, 2, 1, 4));  //����
	   System.out.println(solution(-4, 1, 2, 6, 0, -1, 4, 3)); //���ཻ��Aƽ�б�ֻ��һ����Bƽ�б�֮��
	   System.out.println(solution(-4, 1, 2, 6, 0, -1, 1, 3)); //С�ཻ��Aƽ�б���������Bƽ�б�֮��
	   System.out.println(solution(-4, 1, 2, 6, 3, 4, 5, 7));   //����
//	   System.out.println(solution(0, 0, 10, 10, -2, -2, -5, -5));
//	   System.out.println(solution(0, 0, 10, 10, 2, 2, 5, 5));
//	   System.out.println(solution(-4, 1, 2, 6, 0, -1, 4, 3));
   }
}

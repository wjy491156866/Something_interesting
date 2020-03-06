package csvtest;

public class Possionrandom {
    static int count = 0;   // 初始化统计变量
    
    public static void main(String[] args) {
    	double lamda = 6;
        System.out.println(getPossionVariable(lamda)); //调用方法
    }
    
    private static int getPossionVariable(double lamda) {
		int x = 0;
		double y = Math.random(), cdf = getPossionProbability(x, lamda);
		while (cdf < y) {
			x++;
			cdf += getPossionProbability(x, lamda);
		}
		return x;
	}
 
	private static double getPossionProbability(int k, double lamda) {
		double c = Math.exp(-lamda), sum = 1;
		for (int i = 1; i <= k; i++) {
			sum *= lamda / i;
		}
		return sum * c;
	}


}

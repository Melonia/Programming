package for_statement;

import java.util.Scanner;

public class N8393 {
    public static void main(String[] args){
    	Scanner scan=new Scanner(System.in);

    	int N;
        int sum=0;
        N=scan.nextInt();
        
        for(int i=1;i<=N;i++){
            sum+=i;
        }
        
        System.out.println(sum);
    }
}
/*
문제
n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.

출력
1부터 n까지 합을 출력한다.
*/
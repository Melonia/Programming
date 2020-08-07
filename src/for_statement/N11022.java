package for_statement;

import java.util.Scanner;

public class N11022 {
    public static void main(String[] args){
    	Scanner scan=new Scanner(System.in);
        int T;
        T=scan.nextInt();
        
        for(int i = 0; i < T; i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            int c=a+b;
            System.out.println("Case #"+(i+1)+": "+a+" + "+b+" = "+c);
        }
    }
}
/*
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.

각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.
*/
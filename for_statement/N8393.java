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
����
n�� �־����� ��, 1���� n���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� n (1 �� n �� 10,000)�� �־�����.

���
1���� n���� ���� ����Ѵ�.
*/
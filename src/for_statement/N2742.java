package for_statement;

import java.util.Scanner;

public class N2742 {
    public static void main(String[] args){
    	Scanner scan=new Scanner(System.in);
        int N;
        N=scan.nextInt();
 
        for(int i = 0; i < N; i++){   
            System.out.println(N-i); 
        }
    }
}
/*
����
�ڿ��� N�� �־����� ��, N���� 1���� �� �ٿ� �ϳ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� 100,000���� �۰ų� ���� �ڿ��� N�� �־�����.

���
ù° �ٺ��� N��° �� ���� ���ʴ�� ����Ѵ�.
*/
package for_statement;

import java.util.Scanner;

public class N2439 {
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
        int num;
        num = scan.nextInt();
        
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                if(j<num-i-1) System.out.print(" ");
                else System.out.print("*");
            }
           System.out.println();
        }
    }
}
/*
����
ù° �ٿ��� �� 1��, ��° �ٿ��� �� 2��, N��° �ٿ��� �� N���� ��� ����

������, �������� �������� ������ ��(���� ����)�� ����Ͻÿ�.

�Է�
ù° �ٿ� N(1 �� N �� 100)�� �־�����.

���
ù° �ٺ��� N��° �ٱ��� ���ʴ�� ���� ����Ѵ�.
*/
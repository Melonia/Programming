package for_statement;

import java.util.Scanner;

public class N2739 {
    public static void main(String[] args){
    	Scanner scan=new Scanner(System.in);

    	int num;
        num=scan.nextInt();
        
        for(int i=1;i<10;i++){
            System.out.println(num+" * "+i+" = "+num*i);
        }
    }
}
/*
����
N�� �Է¹��� ��, ������ N���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ��� ���Ŀ� ���缭 ����ϸ� �ȴ�.

�Է�
ù° �ٿ� N�� �־�����. N�� 1���� ũ�ų� ����, 9���� �۰ų� ����.

���
������İ� ���� N*1���� N*9���� ����Ѵ�.
*/
package while_statement;

import java.util.Scanner;

public class N10952 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int a,b;
        
        while(true){
           a=scan.nextInt();
           b=scan.nextInt();
           if(a==0&&b==0) break;
           System.out.println(a+b);
        }
    }
}
/*
����
�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�.

�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����. (0 < A, B < 10)

�Է��� ���������� 0 �� ���� ���´�.

���
�� �׽�Ʈ ���̽����� A+B�� ����Ѵ�.
*/
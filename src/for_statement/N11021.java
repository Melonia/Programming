package for_statement;

import java.util.Scanner;

public class N11021 {
    public static void main(String[] args){
    	Scanner scan=new Scanner(System.in);
        int num;
        num=scan.nextInt();
        
        for(int i=0;i<num;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            int c=a+b;
            System.out.println("Case #"+(i+1)+": "+c);
        }
    }
}
/*
����
�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����.

�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����. (0 < A, B < 10)

���
�� �׽�Ʈ ���̽����� "Case #x: "�� ����� ����, A+B�� ����Ѵ�. �׽�Ʈ ���̽� ��ȣ�� 1���� �����Ѵ�.
*/
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
����
�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����.

�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����. (0 < A, B < 10)

���
�� �׽�Ʈ ���̽����� "Case #x: A + B = C" �������� ����Ѵ�. x�� �׽�Ʈ ���̽� ��ȣ�̰� 1���� �����ϸ�, C�� A+B�̴�.
*/
package arithmetic_operation;

import java.util.Scanner;

public class N10430 {
    public static void main(String[] args){
    	Scanner scan=new Scanner(System.in);

    	int a,b,c;
        a=scan.nextInt();
        b=scan.nextInt();
        c=scan.nextInt();
        
        System.out.println((a+b)%c);
        System.out.println(((a%c) + (b%c))%c);
        System.out.println((a*b)%c);
        System.out.println(((a%c) * (b%c))%c);
    }
}
/*
����
(A+B)%C�� ((A%C) + (B%C))%C �� ������?

(A��B)%C�� ((A%C) �� (B%C))%C �� ������?

�� �� A, B, C�� �־����� ��, ���� �� ���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� A, B, C�� ������� �־�����. (2 �� A, B, C �� 10000)

���
ù° �ٿ� (A+B)%C, ��° �ٿ� ((A%C) + (B%C))%C, ��° �ٿ� (A��B)%C, ��° �ٿ� ((A%C) �� (B%C))%C�� ����Ѵ�.
*/
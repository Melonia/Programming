package if_statement;

import java.util.Scanner;

public class N1330 {
    public static void main(String[] args){
    	Scanner scan=new Scanner(System.in);

    	int a,b;
        a=scan.nextInt();
        b=scan.nextInt();
   
        if(a<b){
            System.out.println("<");
        }
        else if(a>b){
            System.out.println(">");
        }
        else{
            System.out.println("==");
        }
    }
}
/*
����
�� ���� A�� B�� �־����� ��, A�� B�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� A�� B�� �־�����. A�� B�� ���� �� ĭ���� ���еǾ��� �ִ�.

���
ù° �ٿ� ���� �� ���� �� �ϳ��� ����Ѵ�.

A�� B���� ū ��쿡�� '>'�� ����Ѵ�.
A�� B���� ���� ��쿡�� '<'�� ����Ѵ�.
A�� B�� ���� ��쿡�� '=='�� ����Ѵ�.
*/

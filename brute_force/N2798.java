package brute_force;

import java.util.Scanner;

public class N2798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int card = scan.nextInt();
		int number = scan.nextInt();
		int[] deck = new int[card];
		
        for (int i = 0; i < card; i++) {
			deck[i] = scan.nextInt();
		}
        
		int result = 0;
        int max = 0;
		for (int i = 0; i < deck.length - 2; i++)
			for (int j = i + 1; j < deck.length - 1; j++)
				for (int k = j + 1; k < deck.length; k++){
					result = deck[i] + deck[j] + deck[k];
                    if(result <= number)
                        max = max(result,max);
                }
		System.out.println(max);
	}

    static int max(int a, int b){
        return a>b?a:b;
    }
}

/*
����
ī���뿡�� ���� �α� �ִ� ���� ������ ��Ģ�� ����� ����. ī���� ���� 21�� ���� �ʴ� �ѵ� ������, ī���� ���� �ִ��� ũ�� ����� �����̴�. ������ ī���븶�� �پ��� ������ �ִ�.

�ѱ� �ְ��� ���� ��� �������� ���ο� ���� ��Ģ�� ����� ���, â���̿� �����Ϸ��� �Ѵ�.

������ ������ ���迡�� �� ī�忡�� ���� ������ ���� �ִ�. �� ����, ������ N���� ī�带 ��� ���ڰ� ���̵��� �ٴڿ� ���´�. �׷� �Ŀ� ������ ���� M�� ũ�� ��ģ��.

���� �÷��̾�� ���ѵ� �ð� �ȿ� N���� ī�� �߿��� 3���� ī�带 ���� �Ѵ�. ���� ���� �����̱� ������, �÷��̾ �� ī���� ���� M�� ���� �����鼭 M�� �ִ��� ������ ������ �Ѵ�.

N���� ī�忡 ���� �ִ� ���ڰ� �־����� ��, M�� ���� �����鼭 M�� �ִ��� ����� ī�� 3���� ���� ���� ����Ͻÿ�.

�Է�
ù° �ٿ� ī���� ���� N(3 �� N �� 100)�� M(10 �� M �� 300,000)�� �־�����. ��° �ٿ��� ī�忡 ���� �ִ� ���� �־�����, �� ���� 100,000�� ���� �ʴ´�.

���� M�� ���� �ʴ� ī�� 3���� ã�� �� �ִ� ��츸 �Է����� �־�����.

���
ù° �ٿ� M�� ���� �����鼭 M�� �ִ��� ����� ī�� 3���� ���� ����Ѵ�.
*/
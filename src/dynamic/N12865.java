package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String NandK = bf.readLine();
		
		StringTokenizer st = new StringTokenizer(NandK);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		
		//W�� V���� �Է¹޴´�.
		for(int i = 1; i < N+1; i++) {
			String WandV = bf.readLine();
			st = new StringTokenizer(WandV);
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] Val = new int[N+1][K+1];
		for(int i = 0; i < K+1; i++) {
			Val[0][i] = 0;
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < K+1; j++) {
				if(j-W[i]>=0) {
					Val[i][j] = Math.max(Val[i-1][j-W[i]]+V[i],Val[i-1][j]);
				}
				else {
					Val[i][j] = Val[i-1][j];
				}
			}
		}
		System.out.println(Val[N][K]);
	}
}

/*
����
�� ������ ���� ����� �賶�� ���� �����̴�.

�� �� �ĸ� ������ �θ��� �ް� �Ǵ� �ؼ��� ������ ������ �Ѵ�. ������� ������ �����ϸ� �ִ��� ���� ���� �����̱� ������, ������ �ٴ� �賶 ���� �ִ��� ��ġ �ְ� �η��� �Ѵ�.

�ؼ��� ���࿡ �ʿ��ϴٰ� �����ϴ� N���� ������ �ִ�. �� ������ ���� W�� ��ġ V�� �����µ�, �ش� ������ �賶�� �־ ���� �ؼ��� V��ŭ ��� �� �ִ�. ���� �౺�� �غ� ���� ���� �ؼ��� �ִ� K���Ա����� �賶�� ��� �ٴ� �� �ִ�. �ؼ��� �ִ��� ��ſ� ������ �ϱ� ���� �賶�� ���� �� �ִ� ���ǵ��� ��ġ�� �ִ��� �˷�����.

�Է�
ù �ٿ� ��ǰ�� �� N(1 �� N �� 100)�� �ؼ��� ��ƿ �� �ִ� ���� K(1 �� K �� 100,000)�� �־�����. �� ��° �ٺ��� N���� �ٿ� ���� �� ������ ���� W(1 �� W �� 100,000)�� �ش� ������ ��ġ V(0 �� V �� 1,000)�� �־�����.

�Է����� �־����� ��� ���� �����̴�.

���
�� �ٿ� �賶�� ���� �� �ִ� ���ǵ��� ��ġ���� �ִ��� ����Ѵ�.
*/
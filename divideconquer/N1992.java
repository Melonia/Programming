package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1992 {
	private static int N;
	private static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = bf.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j)-48;
				
			}
		}
		
		divide(N, 0, 0);
		
	}

	private static void divide(int N, int x, int y) {
		int num = arr[x][y];
		
		for(int i = x; i < x + N; i++) {
			for(int j = y; j < y + N; j++) {
				if(arr[i][j] == num)
					continue;
				System.out.print("(");
				divide(N/2, x, y);
				divide(N/2, x, y + N/2);
				divide(N/2, x + N/2, y);
				divide(N/2, x + N/2, y + N/2);
				System.out.print(")");
				return;
			}
		}
		System.out.print(num);
	}
}

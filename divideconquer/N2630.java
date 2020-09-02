package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2630 {
	
	static int N;
	static int[][] paper;
	static int[] color;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		paper = new int[N][N];
		color = new int[2];
		int m = 0;
		boolean flag = false;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				
				if(i == 0 && j == 0)
					m = paper[0][0];
				else if(!flag && paper[i][j] != m)
					flag = true;
			}
		}
		
		if(!flag)
			color[m]++;
		else {
			divide(N, 0, 0);
		}
		
		System.out.println(color[0]);
		System.out.println(color[1]);
		
	}
	
	private static void divide(int tempN, int R, int C) {
		int st = paper[R][C];
		
		for(int i = R; i < R + tempN; i++) {
			for(int j = C; j < C + tempN; j++) {
				if(st == paper[i][j])
					continue;
				
				divide(tempN/2, R, C);
				divide(tempN/2, R+tempN/2, C);
				divide(tempN/2, R, C+tempN/2);
				divide(tempN/2, R+tempN/2, C+tempN/2);
				
				return;
			}
		}
		color[st]++;
	}
}


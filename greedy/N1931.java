package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		List<Conf> conf = new ArrayList<Conf>();
		StringTokenizer st = null;
		int N = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < N; i++) {
			String s = bf.readLine();
			st = new StringTokenizer(s);
			conf.add(new Conf(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		/*
		for(int i = 0; i < N; i++)
			System.out.println(conf.get(i));
		*/
		
		Collections.sort(conf);
		
		/*
		for(int i = 0; i < N; i++)
			System.out.println(conf.get(i));
		*/
		int start = 0;
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(start<=conf.get(i).start) {
				count++;
				start = conf.get(i).end;
			}
		}
		System.out.println(count);
	}
}

class Conf implements Comparable<Conf>{
	int start;
	int end;
	Conf(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Conf conference) {
        if (this.end < conference.end) return -1;
        if (this.end == conference.end) {
            return this.start - conference.start;
        }
        return 1;
    }
	@Override
	public String toString() {
		return "Conf [start=" + start + ", end=" + end + "]";
	}
	
}
/*
����
�� ���� ȸ�ǽ��� �ִµ� �̸� ����ϰ��� �ϴ� N���� ȸ�ǿ� ���Ͽ� ȸ�ǽ� ���ǥ�� ������� �Ѵ�. �� ȸ�� I�� ���� ���۽ð��� ������ �ð��� �־��� �ְ�, �� ȸ�ǰ� ��ġ�� �ʰ� �ϸ鼭 ȸ�ǽ��� ����� �� �ִ� ȸ���� �ִ� ������ ã�ƺ���. ��, ȸ�Ǵ� �ѹ� �����ϸ� �߰��� �ߴܵ� �� ������ �� ȸ�ǰ� ������ �Ͱ� ���ÿ� ���� ȸ�ǰ� ���۵� �� �ִ�. ȸ���� ���۽ð��� ������ �ð��� ���� ���� �ִ�. �� ��쿡�� �������ڸ��� ������ ������ �����ϸ� �ȴ�.

�Է�
ù° �ٿ� ȸ���� �� N(1 �� N �� 100,000)�� �־�����. ��° �ٺ��� N+1 �ٱ��� �� ȸ���� ������ �־����µ� �̰��� ������ ���̿� �ΰ� ȸ���� ���۽ð��� ������ �ð��� �־�����. ���� �ð��� ������ �ð��� 231-1���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.

���
ù° �ٿ� �ִ� ����� �� �ִ� ȸ���� �ִ� ������ ����Ѵ�.
*/
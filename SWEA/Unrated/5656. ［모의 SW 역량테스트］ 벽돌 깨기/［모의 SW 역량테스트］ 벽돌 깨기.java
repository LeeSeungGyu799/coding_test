import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int n, w, h, maxBroken;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int T = Integer.parseInt(bf.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new int[h][w];
			int initCnt= 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) {
						initCnt++;
					}
				}
			}

			// 꺨 벽돌 찾기
			maxBroken = Integer.MIN_VALUE;
			dropBomb(0, 0);
			
			//System.out.println(initCnt);
			sb= new StringBuilder();
			sb.append("#").append(testCase).append(" ").append(initCnt - maxBroken).append("\n");
			System.out.print(sb);
		}
	}

	public static void dropBomb(int depth, int broken) {
		if (depth >= n) {
			if (broken > maxBroken) {
				maxBroken = broken;
			}
			return;
		}

		for (int i = 0; i < w; i++) {
			// tempMap 만들기
			int[][] tempMap = copyMap();
			int cnt = explode(i);
			gravity();
			dropBomb(depth + 1, broken + cnt);
			restore(tempMap);
		}
	}

	public static int[][] copyMap() {
		int[][] result = new int[h][w];

		for (int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				result[i][j] = map[i][j];
			}
		}
		return result;
	}

	public static int explode(int target) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int cnt = 0;
		
		for(int i = 0 ; i < h; i++) {
			if(map[i][target] != 0) {
				q.offer(new int[] {i, target, map[i][target]});
				cnt++;
				map[i][target] = 0;
				break;
			}
		}
		// init
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			int nowPower = now[2];
			
			for(int i =0 ; i < 4; i++) {
				for(int p = 0; p < nowPower; p++) {
					int nx = nowX + dir[i][0] * p;
					int ny = nowY + dir[i][1] * p;
					if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
						continue;
					}
					if(map[nx][ny] == 0)
						continue;
					
					q.offer(new int[] {nx,ny,map[nx][ny]});
					map[nx][ny] = 0;
					cnt++;
				}
			}
		}
		
		
		return cnt;
	}

	public static void gravity() {
		for(int i = 0; i < w; i++) {
			ArrayDeque<Integer> temp = new ArrayDeque<>();
			for(int j = h-1; j >= 0; j--) {
				if(map[j][i] != 0) {
					temp.offer(map[j][i]);
				}
			}
		
			for(int j = h-1; j >= 0; j--) {
				if(!temp.isEmpty()) {
					map[j][i] = temp.poll();
				} else {
					map[j][i] = 0;
				}
			}
		}
	}

	public static void restore(int[][] tempMap) {
		for (int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				map[i][j] = tempMap[i][j];
			}
		}
	}
}

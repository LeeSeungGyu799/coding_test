import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String k = bf.readLine();
        map = new char[5][5];

        // Please write your code here.
        // 5x5 표로 채워넣기
        fillMap(k);

        //메시지를 두글자로 나누기
        ArrayList<Character> splitted = new ArrayList<>();
        splitted = split(s);

        //조건에 맞게 암호화
        ArrayList<Character> cyphered = new ArrayList<>();
        cyphered = cypher(splitted);

        //출력
        for(int i = 0; i < cyphered.size(); i++) {
             System.out.print(cyphered.get(i));
        }
    }

    public static void fillMap(String key) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        for(int i = 0; i < key.length(); i++) {
            if(!q.contains(key.charAt(i))) {
                q.offer(key.charAt(i));
            }
        }

        for(int i = 'A' + 0; i < 'Z' + 1; i++) {
            if(!q.contains((char) i)) {
                if((char) i != 'J')
                    q.offer((char) i);
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(!q.isEmpty()) 
                    map[i][j] = q.poll();
            }
        }
    }

    public static ArrayList<Character> split(String s) {
        ArrayList<Character> result = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < s.length(); i++) {
            //cnt가 짝수라면, 그냥 넣는다
            if(cnt % 2 == 0) {
                result.add(s.charAt(i));
                cnt++;
                continue;
            } else {
                // 홀수라면, 바로 앞의 것을 체크
                char target = result.get(cnt - 1);
                // 본인이 X인데 앞에도 X라면, Q를 넣고 본인을 넣고 cnt += 2
                if(s.charAt(i) == 'X' && target == 'X') {
                    result.add('Q');
                    result.add(s.charAt(i));
                    cnt += 2;
                    continue;
                }
                // 본인이 딴건데 앞에 같은거라면 X를 넣고 본인을 넣고 cnt+=2
                if(s.charAt(i) == target) {
                    result.add('X');
                    result.add(s.charAt(i));
                    cnt += 2;
                    continue;
                }
                // 둘다 아니면 (다르면) 그냥 넣고 cnt++
                result.add(s.charAt(i));
                cnt++;
            }
        }

        if(result.size() % 2 == 1)
            result.add('X');

        return result;
    }

    public static ArrayList<Character> cypher(ArrayList<Character> splitted) {
        ArrayList<Character> result = new ArrayList<>();
        
        for(int i = 0; i < splitted.size(); i += 2) {
            int frontX = 0, frontY = 0 , backX = 0, backY = 0;
            char front = splitted.get(i);
            char back = splitted.get(i+1);

            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(front == map[j][k]) {
                        frontX = j;
                        frontY = k;
                    }
                    if(back == map[j][k]) {
                        backX = j;
                        backY = k;
                    }
                }
            }

            // 같은 행
            if(frontX == backX) {
                frontY = (frontY + 1) % 5;
                backY = (backY + 1) % 5;
                result.add(map[frontX][frontY]);
                result.add(map[backX][backY]);
                continue;
            }

            // 같은 열
            if(frontY == backY) {
                frontX = (frontX + 1) % 5;
                backX = (backX + 1) % 5;
                result.add(map[frontX][frontY]);
                result.add(map[backX][backY]);
                continue;
            }

            // 다를때
            result.add(map[frontX][backY]);
            result.add(map[backX][frontY]);
        }


        return result;
    }
}
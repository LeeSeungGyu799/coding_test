class Solution {

    public int solution(int h1, int m1, int s1,
                        int h2, int m2, int s2) {

        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;  // 초

        int answer = 0;

        if (start == 0 || start == 43200) {
            answer++;
        } // 12시

        for (int i = start; i < end; i++) {
            double nowS = (i % 60) * 6.0; // 1초 
            double nowM = (i % 3600) * 0.1; // 1분
            double nowH = (i % 43200) / 120.0; // 1시

            // 1초 후
            double nextS;
            if(i % 60 == 59)
                nextS = 360.0; // 360도
            else 
                nextS = nowS + 6.0;
            
            double nextM = ((i + 1) % 3600) * 0.1;
            double nextH = ((i + 1) % 43200) / 120.0;

            boolean meetM = false;
            boolean meetH = false;
            
            if(nowS < nowM && nextS >= nextM)
                meetM = true;
            if(nowS < nowH && nextS >= nextH)
                meetH = true;

            if (meetM) 
                answer++;
            if (meetH) 
                answer++;

            // 3개는 43200 / 0에만 겹침
            if (meetM && meetH && (i + 1) % 43200 == 0) {
                answer--;
            }
        }

        return answer;
    }
}
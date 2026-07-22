import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {      
        // fees 기본시간 기본요금 단위시간 단위요금
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        int endtime = 23 * 60 + 59;
        
        int carNum = records.length;
        
        Map<Integer, String> map = new HashMap<Integer, String>();
        
        for(int i = 0; i < carNum; i++) {
            String[] result = records[i].split(" "); //result0 시간 result1 차번 result2출입
            
            String[] carTime = result[0].split(":");      
            int minute = Integer.parseInt(carTime[0]) * 60 + Integer.parseInt(carTime[1]);
            
            int plateNum = Integer.parseInt(result[1]);
            
            boolean isIn = false;
            if(result[2].equals("IN")) {
                isIn = true;
            } else isIn = false;
            
            String input = minute + ":" + isIn + ":" + 0;
            
            if(map.containsKey(plateNum)) { //있다면
                // parse[0] 시간 [parse1] isIn [parse2] 누적시간
                String[] parse = map.get(plateNum).split(":");
                // if parse[1] true
                // parse[1] = false
                // parse[2] = temp + minute - parse[0] 
                if(parse[1].equals("true")) {
                    parse[1] = "false";
                    int temp = Integer.parseInt(parse[2]);
                    parse[2] = Integer.toString(temp + minute - Integer.parseInt(parse[0]));
                }
                // if parse[1] false
                // parse[1] = true
                // parse[0] = minute
                else {
                    parse[1] = "true";
                    parse[0] = Integer.toString(minute);
                }
                map.put(plateNum, parse[0] + ":" + parse[1] + ":" + parse[2]);
            } else { //없다면
                // 키값 부여. value는 input
                map.put(plateNum, input);
            }
        }
        // key 기준 정렬
        
        Map<Integer, String> sortedMap = new TreeMap(map);
        int[] answer = new int[sortedMap.size()];
        int resultFee;
        List<Integer> keyList = new ArrayList<>(sortedMap.keySet());
        
        // 전부 체크, 싹다 parse, In이면 23:59 기준으로 계산후 parse[2]에 추가
        for(int i = 0; i < sortedMap.size(); i++) {
            resultFee = 0;
            int finalKey = keyList.get(i);
            String[] finalInfo = sortedMap.get(finalKey).split(":"); // finalInfo[0] 시간 [finalinfo1] isIn [2] 누적시간
            if(finalInfo[1].equals("true")) {  //In일 경우
                int temp = Integer.parseInt(finalInfo[2]);
                finalInfo[2] = Integer.toString(temp + endtime - Integer.parseInt(finalInfo[0]));
            }
            
            // baseTime > 시간 -> baseFee
            // 아니라면, 단위시간으로 나눈 몫 * unitFee
            if (Integer.parseInt(finalInfo[2]) <= baseTime) {
                resultFee = baseFee;
            } else {
                int resultTime = (int) Math.ceil((double) (Integer.parseInt(finalInfo[2]) - baseTime) / unitTime);
                resultFee = resultTime * unitFee + baseFee;
            }
            answer[i] = resultFee;
        }
        
       
        // 싹다 for문
        
        // answer arr에 넣기
        
        return answer;
    }
}
//System.out.println(result[0]);
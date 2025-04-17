import java.time.*;
import java.time.format.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        for(String command : commands){
            String[] curPos = pos.split(":");
            int curM = Integer.parseInt(curPos[0]);
            int curS = Integer.parseInt(curPos[1]);
            
            String[] opsPos = op_start.split(":");
            int opsM = Integer.parseInt(opsPos[0]);
            int opsS = Integer.parseInt(opsPos[1]);
            
            String[] opePos = op_end.split(":");
            int opeM = Integer.parseInt(opePos[0]);
            int opeS = Integer.parseInt(opePos[1]);
            

            // op_start <= cur < op_end
            // 오프닝 시작보다: 분은 같고 초가 크거나, 분이 크거나
            // 오프닝 끝보다: 분은 같고 초가 작거나, 분이 작거나
            if(((opsM==curM && opsS <= curS) || opsM < curM) && 
                (((opeM==curM && opeS > curS) || opeM > curM))){
                pos = op_end;
            }
            
            curPos = pos.split(":");
            curM = Integer.parseInt(curPos[0]);
            curS = Integer.parseInt(curPos[1]);
            
            switch(command){
                case "next": {
                    String[] vdEnd = video_len.split(":");
                    int vdM = Integer.parseInt(vdEnd[0]);
                    int vdS = Integer.parseInt(vdEnd[1]);
                                        
                    curS += 10;
                    if(curS >= 60) {
                        curS -= 60;
                        curM++;
                    }
                    
                    if((vdM < curM) || (vdM==curM && vdS < curS)){
                        pos = video_len;
                    } else{
                        String minute = Integer.toString(curM);
                        String second = Integer.toString(curS);
                        if(curM < 10) minute = "0" + minute;
                        if(curS < 10) second = "0" + second;
                        pos = minute + ":" + second;

                    }
                    break;
                }
                case "prev": {
                    
                    curS -= 10;
                    if(curS < 0) {
                        curS += 60;
                        curM--;
                    }
                    
                    if(curM < 0){
                        pos = "00:00";
                    } else{
                        String minute = Integer.toString(curM);
                        String second = Integer.toString(curS);
                        if(curM < 10) minute = "0" + minute;
                        if(curS < 10) second = "0" + second;
                        pos = minute + ":" + second;
                    }
                    break;
                }
                default:
                    break;    
            }
                        
            curPos = pos.split(":");
            curM = Integer.parseInt(curPos[0]);
            curS = Integer.parseInt(curPos[1]);
            
            // op_start <= cur < op_end
            // 오프닝 시작보다: 분은 같고 초가 크거나, 분이 크거나
            // 오프닝 끝보다: 분은 같고 초가 작거나, 분이 작거나
            if(((opsM==curM && opsS <= curS) || opsM < curM) && 
                (((opeM==curM && opeS > curS) || opeM > curM))){
                    pos = op_end;
            }
            
        }
        answer = pos;
        return answer;
    }

}

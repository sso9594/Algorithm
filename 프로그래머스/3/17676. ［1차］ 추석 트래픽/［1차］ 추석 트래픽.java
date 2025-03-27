import java.util.*;
import java.text.*;

class Solution {
    static class Time{
        long start, end;
        Time (long start, long end){
            this.start = start;
            this.end = end;
        }
        
        boolean isContain(long start, long end){
            return !(this.end < start || this.start > end);
        }
    }
    public int solution(String[] lines) throws Exception{
        List<Time> times = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        for (String line : lines) {
            String[] parts = line.split(" ");
            long endTime = sdf.parse(parts[0] + " " + parts[1]).getTime();
            double duration = Double.parseDouble(parts[2].replace("s", "")) * 1000;
            long startTime = endTime - (long) duration + 1;
            
            System.out.println(endTime + " " + startTime);

            times.add(new Time(startTime, endTime));
        }
        
        int maxThroughput = 0;
        for (Time time : times) {
            long windowStart = time.end;
            long windowEnd = time.end + 999;

            int count = 0;
            for (Time otherTime : times) {
                if (otherTime.isContain(windowStart, windowEnd)) {
                    count++;
                }
            }

            maxThroughput = Math.max(maxThroughput, count);
        }

        return maxThroughput;
    }
}
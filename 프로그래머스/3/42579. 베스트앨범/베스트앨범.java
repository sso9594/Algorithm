import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        // 장르별 Map 부터
        Map<String, Integer> genreMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            String curGen = genres[i];
            int curCnt = plays[i];
            
            genreMap.put(curGen, genreMap.getOrDefault(curGen, 0)+curCnt);
        }
        
        List<String> genreRank = new ArrayList<>(genreMap.keySet());
        genreRank.sort((e1, e2) -> Integer.compare(genreMap.get(e2), genreMap.get(e1)));

        int idx = 0;
        for(String genre : genreRank){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(genre)){
                    list.add(i);
                }
            }
            list.sort((e1, e2) -> Integer.compare(plays[e2], plays[e1]));
            int cnt = 0;
            for(int num : list){
                if(cnt >= 2) break;
                answer.add(num);
                cnt++;
            }
        }
        int[] ans = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
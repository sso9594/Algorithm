import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> sum = new ArrayList<>();
        visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), 0, 3);
        
        for(ArrayList<Integer> subArr : result){
            int sumNum = 0;
            for(int num : subArr){
                sumNum += num;
            }
            sum.add(sumNum);
        }
        
        Collections.sort(sum);
    
        boolean[] boolArr = new boolean[sum.get(sum.size() - 1) + 1];
        for(int i=0; i<boolArr.length; i++){
            boolArr[i] = true;
        }
        
        boolArr[0] = boolArr[1] = false;
        
        for(int i=2; i<Math.sqrt(boolArr.length); i++){
            if(boolArr[i]){
                for(int j=i*i; j<boolArr.length; j+=i){
                    boolArr[j] = false;
                }
            }
        }
        
        for(int num : sum){
            if(boolArr[num]){
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int[] arr, ArrayList<Integer> current ,int start, int r){
        if(r==0){
            result.add(new ArrayList<>(current));
            return;
        } 
        for(int i=start; i<arr.length; i++){
            current.add(arr[i]);
            dfs(arr, current, i + 1, r-1);
            current.remove(current.size()-1);
        }
    }
    
    static void add(int[] arr){
        ArrayList<Integer> current = new ArrayList<>(); 
        for(int i=0; i<arr.length; i++){
            if(visited[i]){
                current.add(arr[i]);
            }
        }
        result.add(current);
    }
    
}
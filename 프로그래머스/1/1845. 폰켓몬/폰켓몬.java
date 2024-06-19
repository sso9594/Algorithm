import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        
        if((nums.length/2) < hash.size()){
            return nums.length/2;
        }else{
            return hash.size();
        }
    }
}
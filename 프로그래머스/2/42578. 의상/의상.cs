using System;
using System.Collections.Generic;

public class Solution {
    public int solution(string[,] clothes) {
        int answer = 1;
        var dict = new Dictionary<string, int>();
        
        for(int i=0; i<clothes.GetLength(0); i++){
            string category = clothes[i, 1];
            dict[category] = dict.GetValueOrDefault(category, 0) + 1;
        }
        
        foreach(var num in dict.Values){
            answer *= num + 1;
        }
        return answer-1;
    }
}
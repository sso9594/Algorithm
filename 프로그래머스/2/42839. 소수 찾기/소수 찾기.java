import java.util.*;

class Solution {
    
    static ArrayList<Integer> resultList = new ArrayList<>();
    
    public int solution(String numbers) {
        int arr[] = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i) - '0';
        }
        for(int i=1; i<=numbers.length(); i++){
            permutation(arr, 0, numbers.length(), i);
        }
        
        return resultList.size();
    }
    
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // arr : 순열 생성 배열, depth : 현재 재귀 깊이, n : 배열 전체 길이, r : 순열의 길이
    private static void permutation(int[] arr, int depth, int n, int r){
        if(depth == r){
            String number = "";
            for(int i=0; i<r; i++){
                number += arr[i];
            }
            if(isPrime(Integer.valueOf(number)) && !resultList.contains(Integer.valueOf(number))){
                resultList.add(Integer.valueOf(number));
            }
            
            return;
        }
        for(int i=depth; i<n; i++){
            swap(arr, depth, i);
            permutation(arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }
    
    private static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        if(num == 2){
            return true;
        }
        if(num % 2 == 0){
            return false;
        }
        for(int i=2; i<= (int)Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
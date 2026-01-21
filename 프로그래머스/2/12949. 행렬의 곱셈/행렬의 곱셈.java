class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        int row = arr1.length;
        int col = arr2[0].length;
        int flat = arr1[0].length;
        
        answer = new int[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                for(int k=0; k<flat; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}

/**
[1, 4]     [3, 3]     [15, 15]
[3, 2]  *  [3, 3]  =  [15, 15]
[4, 1]                [15, 15]


[0][0] * [0][0] + [0][1] * [1][0]
[0][0] * [0][1] + [0][1] * [1][1]
*/
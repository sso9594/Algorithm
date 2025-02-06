import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[][] edge = new int[6][2];

		for (int i = 0; i < edge.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			edge[i][0] = Integer.parseInt(st.nextToken());
			edge[i][1] = Integer.parseInt(st.nextToken());
		}

		int bigBox = 0;
		int minusBox = 0;
		int maxW = 0;
		int maxH = 0;

		for (int i = 0; i < edge.length; i++) {
			if(edge[i][0] == 1 || edge[i][0] == 2){
				maxH = Math.max(maxH, edge[i][1]);
			} else{
				maxW = Math.max(maxW, edge[i][1]);
			}
		}

		bigBox = maxH * maxW;

		for (int i = 0; i < edge.length; i++) {
			if(edge[i%6][0] == edge[(i+2)%6][0] && edge[(i+1)%6][0] == edge[(i+3)%6][0]){
				minusBox = edge[(i+1)%6][1] * edge[(i+2)%6][1];
			}
		}

		int result = (bigBox - minusBox) * K;

		System.out.println(result);
	}
}


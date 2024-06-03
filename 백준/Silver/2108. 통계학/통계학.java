import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long mean = Math.round(Arrays.stream(arr).average().orElse(0.0));
        System.out.println(mean);

        Arrays.sort(arr);
        int median = arr[n/2];
        System.out.println(median);

        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int num : arr){
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = Collections.max(hash.values());
        List<Integer> modeList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
            if(entry.getValue() == maxFrequency){
                modeList.add(entry.getKey());
            }
        }
        Collections.sort(modeList);
        int mode = (modeList.size() > 1) ? modeList.get(1) : modeList.get(0);
        System.out.println(mode);

        int range = arr[n-1] - arr[0];
        System.out.println(range);
        

    }

}

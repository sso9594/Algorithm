import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int maxLen = 0;
        int answerS = -1;
        int answerT = -1;

        // 모든 쌍을 비교 (i < j 조건으로 중복 제거)
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // 같은 문자열은 제외
                if (words[i].equals(words[j])) continue;

                // 공통 접두사 길이 계산
                int len = getCommonPrefixLength(words[i], words[j]);

                // 갱신 조건:
                // 1. 더 긴 접두사를 찾았거나
                // 2. 같은 길이이고 len > 0 이며, 첫 발견이거나 더 앞선 쌍인 경우
                if (len > maxLen) {
                    maxLen = len;
                    answerS = i;
                    answerT = j;
                } else if (len == maxLen && len > 0) {
                    if (answerS == -1 || i < answerS || (i == answerS && j < answerT)) {
                        answerS = i;
                        answerT = j;
                    }
                }
            }
        }

        System.out.println(words[answerS]);
        System.out.println(words[answerT]);
    }

    // 두 문자열의 공통 접두사 길이 반환
    static int getCommonPrefixLength(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
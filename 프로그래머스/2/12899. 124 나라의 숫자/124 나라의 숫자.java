class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String token = "124";

        while (n > 0) {
            int mod = n % 3;
            if (mod == 0) {
                sb.append("4");
                n = n / 3 - 1;
            } else {
                sb.append(token.charAt(mod - 1));
                n /= 3;
            }
        }

        return sb.reverse().toString();
    }
}

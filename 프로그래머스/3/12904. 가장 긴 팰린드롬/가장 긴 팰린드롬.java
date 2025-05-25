class Solution
{
    public int solution(String s)
    {
       int maxLen = 1;
        int n = s.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                maxLen = Math.max(maxLen, right - left + 1);
                left--;
                right++;
            }
        }

        return maxLen;
    }
}
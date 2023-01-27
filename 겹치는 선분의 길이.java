class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        // -100 ~ 100 -> 0 ~ 200
        int[] cnt = new int[201];
        
        for(int i=0; i<lines.length; i++) {
            for(int a = lines[i][0] + 100; a<lines[i][1]+ 100; a++) {
                cnt[a]++;
            }
        }
        
        for(int i=0; i<cnt.length; i++) {
            if(cnt[i] >= 2) answer++;
        }
    
        
        
        return answer;
    }
}

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sounds = {"aya", "ye", "woo", "ma"};
        
        for(String word : babbling) {
            boolean valid = true; 
            String previousSound = ""; 
            
            while(!word.isEmpty() && valid) {
                boolean matched = false;
                
                for(String sound : sounds) {
                    if (word.startsWith(sound) && !previousSound.equals(sound)) { 
                        word = word.substring(sound.length()); 
                        previousSound = sound; 
                        matched = true;
                        break;
                    }
                }
                
                if (!matched) {
                    valid = false; 
                }
            }
            
            if(valid && word.isEmpty()) { 
                answer++;
            }
        }
        
        return answer;
    }
}

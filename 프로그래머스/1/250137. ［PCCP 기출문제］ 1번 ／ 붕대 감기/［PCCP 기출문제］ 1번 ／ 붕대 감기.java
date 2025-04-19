class Solution {
    class Player{
        int hp, success;
        Player(int hp, int success){
            this.hp = hp;
            this.success = success;
        }
        @Override
        public String toString(){
            return Integer.toString(hp);
        }
    }
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = attacks[attacks.length-1][0];
        Player player = new Player(health, 0);
        int T = 0;
        for(int i=1; i<=time; i++){
            if(attacks[T][0]==i){
                player.hp -= attacks[T][1];
                player.success = 0;
                T++;
            } else{
                player.hp += bandage[1];
                player.success++;
                if(player.success == bandage[0]){
                    player.hp += bandage[2];
                    player.success = 0;
                }
                if(player.hp > health){
                    player.hp = health;
                }         
            }
            if(player.hp <= 0) break;
        }
        
        answer = player.hp > 0 ? player.hp : -1;
        return answer;
    }
}
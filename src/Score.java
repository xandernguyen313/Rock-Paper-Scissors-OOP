import java.util.HashMap;

public class Score {
    private HashMap<Player, Integer> gamesRecord;
    private int totalGamesPlayed = 0;
    private Player player1;
    private Player player2;

    public Score(Player p1, Player p2){
        this.player1 = p1;
        this.player2 = p2;
        gamesRecord = new HashMap<>();
        gamesRecord.put(player1, 0);
        gamesRecord.put(player2, 0);
    }

    public void addToRecord(Player player){
        totalGamesPlayed++;
        gamesRecord.put(player, gamesRecord.get(player) + 1);

    }
    public int getTotalGamePlayed(){
        return totalGamesPlayed;
    }
    public int getPlayerGamesWon(Player player) {
        return gamesRecord.get(player);
    }
    public  HashMap<Player, Integer> getRecord(){
        return gamesRecord;
    }

    public String toString(){
        String s = "";
        s += "==================\n";
        s += "Total games played: " + totalGamesPlayed + "\n";
        for(Player key: gamesRecord.keySet()) {
            s += key.getName() + " won " + gamesRecord.get(key) + " games. ";
        }
        s += "\n\n";
        return s;
    }
}

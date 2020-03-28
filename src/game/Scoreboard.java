package game;

// class handling everything related to score
public class Scoreboard {
    private static double score;
    private Game game;

    public Scoreboard(PlayableCharacter playableCharacter, Game game) {
        this.game = game;
        this.score = game.getScore();
        score = (playableCharacter.getItemsCollected() * 50) / Game.getDeathcount() ;
    }

    public static double getScore() {
        return score;
    }

    public static String getScoreString(){
        return String.valueOf(score);
    }

    public static void main(String[] args) {
        System.out.println(getScoreString());
    }
}

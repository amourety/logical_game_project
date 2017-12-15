package entities;

public class Player {
    private String nickname;
    private int score = 0;
    public void addScore(){
        score++;
    }

    public int getScore() {
        return score;
    }
    public Player(String nickname) {
        this.nickname = nickname;
    }

}

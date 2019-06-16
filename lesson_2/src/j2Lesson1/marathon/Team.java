package j2Lesson1.marathon;

public class Team {
    String name;
    Competitor[] competitors=new Competitor[4];
    int score;
    int finishers=4;

    public Team(String name, Competitor c0,Competitor c1,Competitor c2,Competitor c3) {
        this.name = name;
        competitors [0] = c0;
        competitors [1] = c1;
        competitors [2] = c2;
        competitors [3] = c3;
    }
    public void teamInfo(){
        System.out.print(name+" score "+score+" ");
        for (Competitor c:competitors) {
            if (c.isOnDistance())c.info();
        }
        System.out.println();
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }
    public void finishersDecrease(){
        finishers--;
    }
}

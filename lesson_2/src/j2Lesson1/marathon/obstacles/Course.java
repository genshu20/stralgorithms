package j2Lesson1.marathon.obstacles;

import j2Lesson1.marathon.*;

public class Course {
    Obstacle[]obstacles;

    public Course(Obstacle ...o) {
        obstacles = o;
    }
    public void doCourse(Team team){
        for (Competitor c:team.getCompetitors()){
            for (Obstacle o:obstacles){
                o.doIt(c);
                if(c.isOnDistance())team.increaseScore();
                if(!c.isOnDistance()){
                    team.finishersDecrease();
                    break;
                }
            }
            System.out.println();
        }
    }
}

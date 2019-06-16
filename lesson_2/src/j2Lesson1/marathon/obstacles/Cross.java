package j2Lesson1.marathon.obstacles;
import j2Lesson1.marathon.Competitor;

public class Cross extends Obstacle{
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}

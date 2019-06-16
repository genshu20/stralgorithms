package j2Lesson1.marathon;

public class Human implements Competitor{
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpHeight;
    boolean onDistance;

    public Human(String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    public Human(String name) {
        this(name,400,100,2);
    }

    @Override
    public void run(int dist) {
        if(dist<=maxRunDistance) System.out.print("Human "+name+" run ok ");
        else{
            System.out.print("Human "+name+" drop dead ");
            onDistance=false;
        }
    }

    @Override
    public void swim(int dist) {
        if(dist<=maxSwimDistance) System.out.print("Human "+name+" swum ok ");
        else{
            System.out.print("Human "+name+" drowned ");
            onDistance=false;
        }
    }

    @Override
    public void jump(int height) {
        if(height<=maxJumpHeight) System.out.print("Human "+name+" jump ok ");
        else{
            System.out.print("Human "+name+" crashed ");
            onDistance=false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.print("Human "+name+" "+onDistance+" ");
    }
}

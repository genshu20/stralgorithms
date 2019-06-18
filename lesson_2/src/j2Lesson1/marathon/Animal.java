package j2Lesson1.marathon;

public class Animal implements Competitor{
   String type;
   String name;
   int maxRunDistance;
   int maxSwimDistance;
   int maxJumpHeight;
   boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if(dist<=maxRunDistance) System.out.print(type+" "+name+" run ok ");
        else{
            System.out.print(type+" "+name+" drop dead ");
            onDistance=false;
        }
    }

    @Override
    public void swim(int dist) {
        if(dist<=maxSwimDistance) System.out.print(type+" "+name+" swum ok ");
        else{
            System.out.print(type+" "+name+" drowned ");
            onDistance=false;
        }
    }

    @Override
    public void jump(int height) {
        if(height<=maxJumpHeight) System.out.print(type+" "+name+" jump ok ");
        else{
            System.out.print(type+" "+name+" crashed ");
            onDistance=false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.print(type+" "+name+" "+onDistance+" ");
    }
}

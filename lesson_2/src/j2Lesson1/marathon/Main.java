package j2Lesson1.marathon;

import j2Lesson1.marathon.obstacles.*;

public class Main {
    public static void main(String[] args) {
        Team[] teams = new Team[3];
        teams[0] = new Team("Items", new Human("Bob"), new Human("Bill"), new Cat("Vaska"), new Dog("Tuzik"));
        teams[1] = new Team("Humans", new Human("John"), new Human("Sam"), new Human("Paul"), new Human("Bob"));
        teams[2] = new Team("Dogs", new Dog("Sharik"), new Dog("Bobik"), new Dog("Dutik"), new Dog("Kubik"));
        Course course = new Course(new Cross(100), new Wall(1), new Water(10), new Cross(200), new Wall(2), new Water(20));

        for (Team t:teams){
            t.teamInfo();
            course.doCourse(t);
            t.teamInfo();
            System.out.println("finishers "+t.finishers);
            System.out.println();
        }
    }
}

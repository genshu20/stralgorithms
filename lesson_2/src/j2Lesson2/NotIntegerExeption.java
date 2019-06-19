package j2Lesson2;

public class NotIntegerExeption extends RuntimeException {
    String str;

    public NotIntegerExeption(String str) {
        super("not cast to int ");
        this.str = str;
    }
}

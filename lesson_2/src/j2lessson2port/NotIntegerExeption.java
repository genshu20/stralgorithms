package j2lessson2port;

class NotIntegerExeption extends Exception {
    private String str;

    NotIntegerExeption(String str) {
        super("not cast to int "+ str);
        this.str = str;
    }


}

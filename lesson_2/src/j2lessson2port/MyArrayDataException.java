package j2lessson2port;

class MyArrayDataException extends Exception {
    private int i;
    private int j;
    private String s;

    MyArrayDataException(int i, int j, String s) {
        super("String "+ s+" not cast to int string "+i+" column "+j);
        this.i = i;
        this.j = j;
        this.s = s;
    }
}

package j2Lesson3port;

public class Main {
    public static void main(String[] args) {
        String[]words={"table","mather","father","table","map","array","table","map",
                "list","mather","map","list","mather"};
        Count<String> count=new Count<>();
        System.out.println(count.counter(words));

        PhoneBook book=new PhoneBook();
        book.add("Ivanov","212850a");
        book.add("Ivanov","212850a");
        book.add("Ivanov","212850b");
        book.add("Ivanov","212850v");
        book.add("Voronin","212850g");
        book.add("Voronin","212850d");
        book.add("Vasin","212850e");
        book.add("Vasin","212850g");
        book.add("Grebenschikov","2128506");
        book.add("Grebenschikov","2128506");
        book.add("Grebenschikov","2128506");
        book.add("Sergeev","4345454");
        System.out.println(book.toString());
    }
}

package j2Lesson3port;

import java.util.*;

public class PhoneBook {
    private Map<String, ArrayList<String>>map=new TreeMap<>();
    void add(String name,String number){
        ArrayList<String>current=map.getOrDefault(name,new ArrayList<>());
        if(!current.contains(number))current.add(number);
        map.put(name,current);
    }
    ArrayList<String> get(String name){
        return map.get(name);
    }

    @Override
    public String toString() {
        Set<Map.Entry<String,ArrayList<String>>>set=map.entrySet();
        String s="";
        for (Map.Entry<String,ArrayList<String>> me:set) {
          s+=me.getKey()+"\n"+me.getValue().toString()+"\n";
        }
        return s;
    }
}

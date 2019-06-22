package j2Lesson3port;

import java.util.*;

class Count<T> {
   Map<T,Integer> counter(T[]ts){
    Map<T,Integer>map=new HashMap<>();
       for (T t:ts) {
           Integer currenNum=map.get(t);
           map.put(t,currenNum==null? 1:++currenNum);
       }
       return map;
   }
}

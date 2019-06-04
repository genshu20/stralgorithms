package lesson_2;

public class MySortedArrayList<T extends Comparable> extends MyArrayList<T>{
    @Override
    public void add(T t) {
        int i=0;
        while (i<size()&& t.compareTo(get(i))>=0) {
            i++;
        }
        super.add(i,t);
    }
    @Override
    public void add(int index, T t) {
        add(t);
    }
    public boolean binaryFind(T t){
        int lo=0;
        int hi=size()-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(t.compareTo(get(mid))<0)hi=mid-1;
            else if(t.compareTo(get(mid))>0)lo=mid+1;
            else return true;
        }return false;
    }
}

package lesson_7;

import java.util.LinkedList;

public class Graph implements Cloneable {
    private int vertxCount;
    private int edgeCount;
    private LinkedList<Integer>[]adgList;

    public Graph(int vertxCount) {
        if(vertxCount<0)throw new IllegalArgumentException("vertexes less 0");
        this.vertxCount = vertxCount;
        adgList=new LinkedList[vertxCount];
        for (int i = 0; i <adgList.length ; i++) {
            adgList[i]=new LinkedList<>();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getVertxCount() {
        return vertxCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public LinkedList<Integer> getAdgList(int vertex) {
        return (LinkedList<Integer>)adgList[vertex].clone();
    }
    public void addEdge(int v1,int v2){
        if(v1<0||v2<0||v1>=vertxCount||v2>=vertxCount)throw new IllegalArgumentException();
        adgList[v1].add(v2);
        adgList[v2].add(v1);
    }
    public void deleteEdge(int v1,int v2){
        if(v1<0||v2<0||v1>=vertxCount||v2>=vertxCount)throw new IllegalArgumentException();
        adgList[v1].remove((Integer)v2);
        adgList[v2].remove((Integer)v1);
    }
}

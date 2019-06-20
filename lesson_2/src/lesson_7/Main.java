package lesson_7;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Graph graph=new Graph(10);
        int source=6;
        graph.addEdge(0,1);
        graph.addEdge(0,7);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(6,5);
        graph.addEdge(6,7);
        graph.addEdge(7,8);
        graph.addEdge(8,5);
        graph.addEdge(8,9);
        graph.addEdge(9,3);
        graph.addEdge(9,2);

        BreadthFirstPath bfp=new BreadthFirstPath(graph,source);
        System.out.println(bfp.distTo(2));
        System.out.println(bfp.pathTo(2));
    }
}

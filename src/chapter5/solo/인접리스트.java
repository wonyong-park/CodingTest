package chapter5.solo;

import java.util.ArrayList;

public class 인접리스트{
    //행이 3개인 인접 리스트 표현
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        graph.get(1).add(new Node(0, 7));

        graph.get(2).add(new Node(0, 5));

    }

}

class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show(){
        System.out.print("(" + this.index + "," + this.distance + ")");
    }
}

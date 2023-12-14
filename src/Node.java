
import java.util.ArrayList;

public class Node implements Comparable<Node> {


    public static int path;

    String name;
    ArrayList<Edge> neighbours;

    int distance;
    int time;
    int cost;
    Node prev;

    public Node(String name) {
        this.name = name;
        this.neighbours = new ArrayList<Edge>();
        this.distance = Integer.MAX_VALUE;
        this.time = Integer.MAX_VALUE;
        this.cost = Integer.MAX_VALUE;
        this.prev = null;
    }
    public void addNeighbour(Node n, int d, int t, int c) {
        neighbours.add(new Edge(n, d, t, c));
        n.neighbours.add(new Edge(this, d, t, c));

    }

    public int compareTo(Node other) {
        if (path == 0) {
            return Integer.compare(this.distance, other.distance);
        }
        else if(path == 1) {
            return Integer.compare(this.time, other.time);
        }
        else  {
            return Integer.compare(this.cost, other.cost);
        }



    }


}


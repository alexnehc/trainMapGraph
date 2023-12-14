

public class Edge {

    int distance;
    int time;
    int cost;
    Node n;


    public Edge(Node n, int d, int t, int c) {
        this.n = n;
        distance = d;
        time = t;
        cost = c;
    }
}

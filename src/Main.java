import java.util.*;


public class Main {




    public static void main(String[] args) {



        Node MNH = new Node("Museum of Natural History");
        Node TM = new Node("The Met");
        Node TS = new Node("Times Square");
        Node GC = new Node("Grand Central Station");
        Node CB = new Node("Chrysler Building");
        Node PS = new Node("Penn Station");
        Node ESB = new Node("Empire State Building");
        Node FB = new Node("Flatiron Building");
        Node OPP = new Node("1 Pace Plaza");
        Node BB = new Node("Brooklyn Bridge");
        Node WS = new Node("163 Williams Street");



        MNH.addNeighbour(TS,2,2,2);


        TS.addNeighbour(MNH, 8, 20, 8);
        TS.addNeighbour(PS, 1, 4, 2);
        TS.addNeighbour(ESB, 2, 3, 2);
        TS.addNeighbour(GC, 2, 2, 2);

        PS.addNeighbour(TS, 1, 4, 2);
        PS.addNeighbour(ESB, 1, 3, 1);

        TM.addNeighbour(GC, 10, 30, 10);
        CB.addNeighbour(GC, 1, 1, 1);

        GC.addNeighbour(TM, 10, 30, 10);
        GC.addNeighbour(CB, 1, 1, 1);
        GC.addNeighbour(TS, 2, 2, 2);
        GC.addNeighbour(OPP, 7, 5, 2);

        ESB.addNeighbour(TS, 1, 4, 2);
        ESB.addNeighbour(PS, 1, 3, 1);
        ESB.addNeighbour(FB, 2, 3, 2);

        FB.addNeighbour(ESB, 2, 3, 2);
        FB.addNeighbour(WS, 3, 5, 3);


        WS.addNeighbour(BB,1,2,1);
        WS.addNeighbour(OPP, 1, 1, 1);

        BB.addNeighbour(WS,1, 2, 1);
        BB.addNeighbour(OPP, 1, 1, 1);

        OPP.addNeighbour(BB, 1, 1, 1);
        OPP.addNeighbour(WS, 1, 1, 1);
        OPP.addNeighbour(GC, 7, 5, 2);



        path(MNH,WS,0);
        System.out.println();
        path(MNH, WS, 1);
        System.out.println();
        path(MNH, WS, 2);
    }


    public static void path(Node start, Node end, int pathType) {

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        switch(Node.path) {
            case 0:

                Node.path = pathType;

                start.distance = 0;

                pq.add(start);

                while(!pq.isEmpty()) {
                    Node current = pq.poll();
                    if(current == end) break;

                    for(Edge e: current.neighbours) {
                        int tempDist = current.distance+e.distance;
                        Node n = e.n;
                        if(tempDist > n.distance) continue;

                        n.distance = tempDist;
                        n.prev = current;
                        pq.remove(n);
                        pq.add(n);
                    }
                }
                break;

            case 1:

                Node.path = pathType;

                start.time = 0;

                pq.add(start);

                while(!pq.isEmpty()) {
                    Node current = pq.poll();
                    if(current == end) break;

                    for(Edge e: current.neighbours) {
                        int tempDist = current.time+e.time;
                        Node n = e.n;
                        if(tempDist > n.time) continue;

                        n.time = tempDist;
                        n.prev = current;
                        pq.remove(n);
                        pq.add(n);
                    }
                }
                break;

            case 2:

                Node.path = pathType;

                start.cost = 0;

                pq.add(start);

                while(!pq.isEmpty()) {
                    Node current = pq.poll();
                    if(current == end) break;

                    for(Edge e: current.neighbours) {
                        int tempDist = current.cost+e.cost;
                        Node n = e.n;
                        if(tempDist > n.cost) continue;

                        n.cost = tempDist;
                        n.prev = current;
                        pq.remove(n);
                        pq.add(n);
                    }
                }
                break;
        }
        printPath(end);
    }


    public static void printPath(Node n) {
        if(n == null) return;
        printPath(n.prev);
        System.out.println(n.name);
    }
}

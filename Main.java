import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //The main method runs tests that report back whether each search found the target node or not.

        //Edit target value to change what node is being searched for
        //Changing it to something not A-I will result in a full graph traversal
        String targetData = "C";
        Node E = buildGraph();

        System.out.println("BFS (Iterative)\n---------------");
        boolean bfsFound = bfs(E, targetData);

        E = buildGraph();
        System.out.println("\n\nDFS (Iterative)\n---------------");
        boolean dfsIterFound = dfsIterative(E, targetData);

        E = buildGraph();
        System.out.println("\n\nDFS (Recursive)\n---------------");
        boolean dfsRecurFound = dfsRecursive(E, targetData);

        String output = bfsFound ? "\nBFS found " + targetData + ".\n" : "\nBFS didn't find " + targetData + ".\n";
        output += dfsIterFound ? "DFS (iterative) found " + targetData + ".\n" : "DFS (iterative) didn't find " + targetData + ".\n";
        output += dfsRecurFound ? "DFS (recursive) found " + targetData + ".\n" : "DFS (recursive) didn't find " + targetData + ".\n";

        System.out.println("\n\nRESULTS\n-------" + output);
    }

    public static boolean bfs(Node start, String targetData) {
        Queue<Node> queue = new LinkedList<>();
        Node store;
        queue.add(start);
        while (queue.size() > 0) {
            store = queue.remove();
            if (store.data == targetData) {
                System.out.println("Found Target");
                return true;
            }
            else {
                store.visit();
                for (Node a : store.neighbors) {
                    if (a.visited == false && queue.contains(a) == false) {
                        queue.add(a);
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfsIterative(Node start, String targetData) {
        Stack<Node> stack = new Stack<>();
        Node store;
        stack.push(start);
        while (stack.size() > 0) {
            store = stack.pop();
            if (store.data == targetData) {
                System.out.println("Found Target");
                return true;
            }
            else {
                store.visit();
                for (Node a : store.neighbors) {
                    if (a.visited == false && stack.contains(a) == false) {
                        stack.push(a);
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfsRecursive(Node current, String targetData) {
            if (current.data == targetData) {
                System.out.println("Found Target");
                return true;
            } else {
                current.visit();
                boolean found = false;
                for (Node a : current.neighbors) {
                    if (a.visited == false) {
                        found = dfsRecursive(a, targetData);
                        if (found == true) {
                            return true;
                        }
                    }
                }
                return false;
            }
    }

    public static Node buildGraph() {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        A.neighbors = new Node[]{E};
        B.neighbors = new Node[]{C, E, F, I};
        C.neighbors = new Node[]{B};
        D.neighbors = new Node[]{F};
        E.neighbors = new Node[]{A, B, G};
        F.neighbors = new Node[]{B, D, H};
        G.neighbors = new Node[]{E};
        H.neighbors = new Node[]{F, I};
        I.neighbors = new Node[]{B, H};
        return E;
    }
}


public class Node {
    String data;
    boolean visited;
    Node[] neighbors;

    public Node (String data){
        this.data = data;
    }

    public void visit() {
        System.out.print(data + ", ");
        visited = true;
    }
}
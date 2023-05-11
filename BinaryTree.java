import java.util.Scanner;

public class BinaryTree {
    static class Node{
        String key;
        Node left, right;
    
        Node(String item){
            key = item;
    
            left = right = null; 
        }
    }
    
    public static Node root;

  
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("                                 BINARY TREE MAKER");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Enter the items in the nodes of this Binary Tree (Type in the word null, to not add anything )");
        System.out.println("This program will create the node using the pre order traversal(parent node first then left child then right child)");
        System.out.println("");
        System.out.print("Enter the first node:");
        root = CreateBinaryTree(scn);
        int counter = CountNodes(root);
        System.out.println("");

        System.out.println("The number of items in this binary tree is "+ counter);
        System.out.println("");
        System.out.println("                                    VISUALIZATION");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("");
        printBinaryTree(root,"");
        System.out.println("");

    



        
    }

     
    static Node CreateBinaryTree(Scanner scn){
        String item = scn.nextLine();

        if (!item.equals("null")){
            Node node = new Node(item);
            System.out.print("Enter the left child of " + item + ": ");
            node.left = CreateBinaryTree(scn);
            System.out.print("Enter the right child of " + item + ": ");
            node.right = CreateBinaryTree(scn);
            return node;
        
        }
        else{
            return null;
        }
   



    }

    static int CountNodes(Node node){
        if(node == null){
            return 0;
        }

        else{
            int leftCounter = CountNodes(node.left);
            int rightCounter = CountNodes(node.right);
            return 1 + leftCounter + rightCounter;
        }

        
    } 
    static void printBinaryTree(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.key);

        if (node.left != null || node.right != null) {
            String childIndent = indent + "    ";
            printBinaryTree(node.left, childIndent + "|---");
            printBinaryTree(node.right, childIndent + "|---");
        }
    }

}
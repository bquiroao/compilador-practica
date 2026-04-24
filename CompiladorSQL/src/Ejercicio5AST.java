/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quiro
 */
public class Ejercicio5AST {

    public static void main(String[] args) {
        String query = "SELECT nombre FROM usuarios";
        Node root = parse(query);

        printTree(root, 0);
    }

    public static Node parse(String query) {

        String[] parts = query.split(" ");

        if(parts.length < 4) {
            return null;
        }

        // Crear nodos
        Node selectNode = new Node("SELECT");
        Node columnNode = new Node(parts[1]);
        Node tableNode = new Node(parts[3]);

        // Construir árbol
        selectNode.addChild(columnNode);
        selectNode.addChild(tableNode);

        return selectNode;
    }

    // Método para imprimir el árbol
    public static void printTree(Node node, int level) {
        if(node == null) return;

        for(int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        System.out.println(node.value);

        for(Node child : node.children) {
            printTree(child, level + 1);
        }
    }
}

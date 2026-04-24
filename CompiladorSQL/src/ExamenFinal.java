/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quiro
 */
public class ExamenFinal {

    public static void main(String[] args) {

        String[] queries = {
            "SELECT nombre FROM usuarios",
            "SELECT edad FROM usuarios WHERE edad > 18",
            "SELECT nombre usuarios",
            "SELECT edad FROM usuarios WHERE edad > \"hola\""
        };

        for(String q : queries) {
            System.out.println("Query: " + q);

            String resultado = validar(q);
            System.out.println("Resultado: " + resultado);

            if(resultado.equals("Query válida") || resultado.equals("Query válida con WHERE")) {
                Node ast = construirAST(q);
                printTree(ast, 0);
            }

            System.out.println("-------------------");
        }
    }
    
public static String validar(String query) {

    String[] parts = query.split(" ");

    // Validar estructura mínima
    if(parts.length < 4) {
        return "Query inválida (estructura)";
    }

    if(!parts[0].equals("SELECT") || !parts[2].equals("FROM")) {
        return "Query inválida (estructura)";
    }

    // Validar WHERE
    if(query.contains("WHERE")) {

        // Validación semántica
        if(query.contains(">") && query.contains("\"")) {
            return "Error semántico";
        }

        return "Query válida con WHERE";
    }

    return "Query válida";
}

public static Node construirAST(String query) {

    String[] parts = query.split(" ");

    Node root = new Node("SELECT");

    Node column = new Node(parts[1]);
    Node table = new Node(parts[3]);

    root.addChild(column);
    root.addChild(table);

    if(query.contains("WHERE")) {
        Node whereNode = new Node("WHERE");

        // condición simple
        Node condition = new Node(parts[5] + " " + parts[6] + " " + parts[7]);

        whereNode.addChild(condition);
        root.addChild(whereNode);
    }

    return root;
}

public static void printTree(Node node, int level) {

    for(int i = 0; i < level; i++) {
        System.out.print("  ");
    }

    System.out.println(node.value);

    for(Node child : node.children) {
        printTree(child, level + 1);
    }
}
}
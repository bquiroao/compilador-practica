/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quiro
 */
public class Ejercicio3CompletarCodigo {
    public static void main (String[] args){
        String query = "SELECT nombre FROM usuarios";
        System.out.println(parse(query));
    }
    
    public static String parse(String query){
        
        if(query.startsWith("SELECT") && query.contains("FROM")){
       //TODO: validar que exista FROM
       return "Query válida";
        }
        return "Query inválida";
        
}
}

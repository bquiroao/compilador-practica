/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quiro
 */
public class ParserSQL {
    public static void main (String[] args){
        
        String[] queries = {
            "SELECT nombre FROM usuarios",
            "SELECT edad FROM usuarios WHERE edad > 18",
            "SELECT nombre usuarios",
            "SELECT edad FROM usuarios WHERE edad > \"hola\""
        };
        
        for(String q : queries){
            System.out.println(q + " -> " + parse(q));
        }
    }
    
    public static String parse(String query){
        
        if(query.startsWith("SELECT") && query.contains("FROM")){
            
            if(query.contains("WHERE")) {
                
                //VALIDACION SEMANTICA
                if(query.contains(">") && query.contains("\"")){
                return "Error semántico";
                }
                
                return "Query válida con WHERE";
            }
            
            return "Query válida";
        }
        
        return "Query inválida";
    }
}
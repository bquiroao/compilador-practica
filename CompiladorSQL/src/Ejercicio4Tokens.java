/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quiro
 */
public class Ejercicio4Tokens {
   public static void main (String[] args){
        String query = "SELECT nombre FROM usuarios";
        //CASO INCORRECTO String query = "SELECT nombre usuarios";
        System.out.println(parse(query));
    }
    
    public static String parse(String query){
        
        //PASO 1 SEPARAR EN TOKENS
        String[] parts = query.split(" ");
        
        //PASO 2 VALIDAR QUE TENGA AL MENOS 4 PARTES
        if(parts.length < 4){
            return "Query invalida";
        }
        
        //PASO 3 VALIDAR ESTRUCTURA
        if(parts[0].equals("SELECT") && parts[2].equals("FROM")){
            return "Query válida";
        }
       return "Query inválida";
    }
}
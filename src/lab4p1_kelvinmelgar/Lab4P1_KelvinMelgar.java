/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p1_kelvinmelgar;

import java.util.Scanner;
/**
 *
 * @author kelvi
 */
public class Lab4P1_KelvinMelgar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        
        do{
            System.out.println("\n<----- Menu ----->");
            System.out.println("1. Sumador Binario");
            System.out.println("2. Contains");
            System.out.println("3. Alpha");
            System.out.println("4. Salir...");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
            
            if (opcion == 1) {
                String cadena1, cadena2;
                char valid1 = 's', valid2 = 's';

                System.out.print("\nIngrese una cadena (solo Binarios): ");
                cadena1 = sc.next();

                System.out.print("Ingrese otra cadena (solo Binarios): ");
                cadena2 = sc.next();

                //Ciclos para vericar si son binarios
                for (int i = 0; i < cadena1.length(); i++) {
                    if ((int) cadena1.charAt(i) < 48 || (int) cadena1.charAt(i) > 49) {
                        valid1 = 'n';
                    }
                }

                for (int i = 0; i < cadena2.length(); i++) {
                    if ((int) cadena2.charAt(i) < 48 || (int) cadena2.charAt(i) > 49) {
                        valid2 = 'n';
                    }
                }

                //Realiza las validaciones
                if (valid1 == 's') {
                    if (valid2 == 's') {
                        if (cadena1.length() == cadena2.length()) {
                            sumadorBinario(cadena1, cadena2);

                        } else {
                            System.out.println("\nEl tamanio debe ser igual...");
                        }
                    } else {
                        System.out.println("\nLa segunda cadena no es un binario");
                    }
                } else {
                    System.out.println("\nLa primer cadena no es un binario");
                }

            }
            else if(opcion == 2){
                System.out.print("Ingrese una cadena: ");
                sc.nextLine();
                String contenedor = sc.nextLine();

                System.out.print("Ingrese otra cadena: ");
                String contenido = sc.nextLine();

                if (contenido.length() > contenedor.length()) {
                    System.out.println("Error...la segunda cadena no debe ser mayor");
                } else {
                    otroContains(contenedor, contenido);
                }

            }
            else if(opcion == 3){
                String cadena;

                System.out.print("\nIngrese una cadena: ");
                cadena = sc.next();

                soloLetras(cadena);
            }
            else if(opcion == 4){
                System.out.println("Saliendo....");
            }
            else{
                System.out.println("Opcion invalida....");
            }
        }while(opcion != 4);
    }//Fin del main
    
    
    public static void sumadorBinario(String cad1, String cad2){
        String result="";
        int res = 0, sum,dig1, dig2;
        
        for (int i = cad1.length() - 1; i >= 0; i--) {
            //Obtiene el ultimo digito de las cadenas para integer
            if((int)cad1.charAt(i) == 48){
                dig1 = 0;
            }else{
                dig1 = 1;
            }
            
            if((int)cad2.charAt(i) == 48){
                dig2 = 0;
            }else{
                dig2 = 1;
            }
            
            //Depiendo de la suma se obtiene el valor del resultado y residuo
            sum = dig2 + dig1 + res;
            
            switch(sum){
                case 0:{
                    result = 0 + result;
                    res = 0;
                    break;
                }
                case 1:{
                    result = 1 + result;
                    res = 0;
                    break;
                }
                case 2:{
                    result = 0 + result;
                    res = 1;
                    break;
                    
                }case 3:{
                    result = 1 + result;
                    res = 1;
                    break;
                }
            }
        }
        
        //Le agrega otro digito
        if(res == 1){
            result = 1 + result;
        }
        
        System.out.println("\nEl resultado fue: " + result);
    }
    
    public static void otroContains(String contr, String cont){
        String acum_c="";
        
        //Recorre antes del ultimo caracter
        for (int i = 0; i < cont.length() - 1; i++) {

            for (int j = 0; j <= contr.length()-1 ; j++) {

                if (cont.charAt(i) == contr.charAt(j)) {
                    //Si la la siguiente letra esta en el contenido
                    if (cont.charAt(i + 1) == contr.charAt(j + 1)) {
                        acum_c += cont.charAt(i);
                        
                        //revisa si es la ultima vuelta
                        if (cont.length() - i == 2) {
                            if (cont.charAt(i + 1) == contr.charAt(j + 1)) {
                                acum_c += cont.charAt(i + 1);
                            }
                        }
                    }
                }
            }
        }
        
        if (acum_c.length() == cont.length()) {
            System.out.printf("\nLa cadena %s contiene la subcadena %s.", contr, cont);
        } else {
            System.out.printf("\nLa cadena %s no contiene la subcadena %s.", contr, acum_c);
        }
        
    }
    
    public static void soloLetras(String cadena){
        
        cadena = cadena.toLowerCase();
        boolean paso = true;

        for (int i = 0; i < cadena.length(); i++) {
            int c = (int) cadena.charAt(i);

            //Revisas si no esta dentro del rango de las letras
            if (!(c >= 97 && c <= 122)) {
                paso = false;
                break;
            }
        }

        if (paso) {
            System.out.printf("\nLa cadena %s tiene solo letras.", cadena);
        } else {
            System.out.printf("\nLa cadena %s tiene letras y otros caracteres.", cadena);
        }
    }
}

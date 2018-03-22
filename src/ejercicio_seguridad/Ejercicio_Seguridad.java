/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_seguridad;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author pc HP
 */
public class Ejercicio_Seguridad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int option = 0;
        OpcionesMenu o = new OpcionesMenu();
        
        System.out.println("--------------------------------------------");
        System.out.println("            SISTEMA DE SEGURIDAD            ");
        
        do{
            try{
                System.out.println("--------------------------------------------");
                System.out.println("---------------" + Console_Colors.ANSI_PURPLE + "Menu Principal" + Console_Colors.ANSI_RESET + "---------------");
                System.out.println("1. Ingresar al Sistema");
                System.out.println("2. Registrarse");
                System.out.println("3. Salir");
                System.out.println("--------------------------------------------");
                System.out.print(">>");
                option = sc.nextInt();
                
                switch (option) {
                    case 1:
                        System.out.println();
                        System.out.println(Console_Colors.ANSI_PURPLE + "1. Ingresar al Sistema" + Console_Colors.ANSI_RESET);
                        o.opcionIngresar();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println(Console_Colors.ANSI_PURPLE + "2. Registrarse" + Console_Colors.ANSI_RESET);
                        o.opcionRegistrar();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println(Console_Colors.ANSI_RED + "**Opcion del Menu no Valida" + Console_Colors.ANSI_RESET);
                        break;
                }
                
            }catch (InputMismatchException e){
                System.out.println(Console_Colors.ANSI_RED + "**Ingreso un dato Invalido." + Console_Colors.ANSI_RESET);
                System.out.println();
                sc.nextLine();
            }
        }while(option != 3);
    }
    
}

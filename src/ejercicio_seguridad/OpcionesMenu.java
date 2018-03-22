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
public class OpcionesMenu {
    Scanner sc = new Scanner(System.in);
    
    public void opcionIngresar(){
        String user = null;
        
        do{
            try{
                
            }catch (InputMismatchException e){
                System.out.println(Console_Colors.ANSI_RED + "**Ingreso un dato Invalido." + Console_Colors.ANSI_RESET);
                System.out.println();
                sc.nextLine();
            }
        }while (!user.equals("0"));
    }
    
    public void opcionRegistrar(){
        String user = null;
        
        do{
            try{
                
            }catch (InputMismatchException e){
                System.out.println(Console_Colors.ANSI_RED + "**Ingreso un dato Invalido." + Console_Colors.ANSI_RESET);
                System.out.println();
                sc.nextLine();
            }
        }while (!user.equals("0"));
        
    }
    
    
}

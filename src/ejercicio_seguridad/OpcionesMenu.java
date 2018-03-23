/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_seguridad;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author pc HP
 */
public class OpcionesMenu {

    Scanner sc = new Scanner(System.in);
    Email e = new Email();
    Connect c = new Connect();
    Console console = System.console();

    public void opcionIngresar() {
        String user = null;
        String password = null;
        String userPass = null;
        String registrar = null;
        int contador = 0;
        

        do {
            try {
                System.out.printf("%-60s%-26s%n", "Ingrese su Correo Electrónico:", Console_Colors.ANSI_BLUE + "←Ingrese <0> para regresar" + Console_Colors.ANSI_RESET);
                System.out.print(">> ");
                user = sc.nextLine();

                if (user.equals("0")) {

                } else if (e.validateEmail(user)) {
                    if (c.validateUser(user)) {
                        do {
                            System.out.printf("%-60s%-26s%n", "Ingrese su Contraseña:", Console_Colors.ANSI_BLUE + "←Ingrese <0> para regresar" + Console_Colors.ANSI_RESET);
                            /*Console console = System.console();
                            char[] passwordChars = console.readPassword();
                            password = new String(passwordChars);*/
                            password = sc.nextLine();
                            if (password.equals("0")) {

                            } else if (c.validatePassword(password, user)) {
                                do {
                                    System.out.println();
                                    System.out.println("::::>>" + Console_Colors.ANSI_PURPLE + "BIENVENIDO" + Console_Colors.ANSI_RESET + "<<::::");
                                    System.out.println("Ingrese <0> para Salir del Sistema" + Console_Colors.ANSI_RESET);
                                    password = sc.nextLine();
                                    if (password.equals("0")) {
                                        user = "0";
                                    } else {
                                        System.out.println(Console_Colors.ANSI_RED + "**Respuesta no Valida, favor escribir unicamente <0> para salir." + Console_Colors.ANSI_RESET);
                                    }
                                } while (!password.equals("0"));
                            } else {
                                System.out.println(Console_Colors.ANSI_RED + "**Contraseña Incorrecta" + Console_Colors.ANSI_RESET);

                                contador++;
                                if (contador == 3) {
                                    e.sendWarning(user);
                                }
                            }

                        } while (!password.equals("0"));

                    } else {
                        do {
                            System.out.println("Su usuario aun no existe, desea Registrarlo?    <S>/<N>");
                            registrar = sc.nextLine();
                            if (registrar.equalsIgnoreCase("S")) {
                                System.out.println();
                                System.out.println("<::: " + Console_Colors.ANSI_PURPLE + "REGISTRARSE" + Console_Colors.ANSI_RESET + " :::>");
                                opcionRegistrar(user);
                            } else if (registrar.equalsIgnoreCase("N")) {

                            } else {
                                System.out.println(Console_Colors.ANSI_RED + "**Respuesta no Valida, favor escribir unicamente <S> o <N>." + Console_Colors.ANSI_RESET);
                            }
                        } while (!registrar.equalsIgnoreCase("S") && !registrar.equalsIgnoreCase("N"));

                    }

                } else {
                    System.out.println(Console_Colors.ANSI_RED + "**Su Correo no tiene un formato valido." + Console_Colors.ANSI_RESET);
                    System.out.println();
                }

            } catch (InputMismatchException e) {
                System.out.println(Console_Colors.ANSI_RED + "**Ingreso un dato Invalido." + Console_Colors.ANSI_RESET);
                System.out.println();
                sc.nextLine();
            }
        } while (!user.equals("0"));
    }

    public void opcionRegistrar(String user) {
        String email = null;
        String password, password2;
        int confirmacion = 0;

        do {
            try {
                System.out.printf("Desea utilizar " + user + " como su correo electronico?  <S>/<N>");
                String utilizar = sc.nextLine();
                if (utilizar.equalsIgnoreCase("S")) {
                    email = user;
                } else if (utilizar.equalsIgnoreCase("N")) {
                    do {
                        System.out.println("Ingrese su Correo Electrónico:");
                        System.out.print(">> ");
                        email = sc.nextLine();
                        if (e.validateEmail(email)== false) {
                            System.out.println(Console_Colors.ANSI_RED + "**Su Correo no tiene un formato valido." + Console_Colors.ANSI_RESET);
                            System.out.println();
                        }
                    } while (e.validateEmail(email)== false);
                } else {
                    System.out.println(Console_Colors.ANSI_RED + "**Respuesta no Valida, favor escribir unicamente <S> o <N>." + Console_Colors.ANSI_RESET);
                }
                do {
                    System.out.println("Ingrese su Contraseña: ");
                    System.out.print(">> ");
                    password = sc.nextLine();
                    System.out.println("Confirme su Contraseña: ");
                    System.out.print(">> ");
                    password2 = sc.nextLine();
                    if (password.equals(password2)) {
                        confirmacion = 1;
                    } else {
                        System.out.println(Console_Colors.ANSI_RED + "**Error en la confirmacion" + Console_Colors.ANSI_RESET);
                    }
                } while (confirmacion != 1);

                c.insertarUsuario(email, password2);
                user = "0";

            } catch (InputMismatchException e) {
                System.out.println(Console_Colors.ANSI_RED + "**Ingreso un dato Invalido." + Console_Colors.ANSI_RESET);
                System.out.println();
                sc.nextLine();
            }
        } while (!user.equals("0"));

    }

    public void opcionRegistrar() {
        String email = null;
        String password, password2;
        int confirmacion = 0;

        do {
            try {
                do{
                System.out.println("Ingrese su Correo Electrónico:");
                System.out.print(">> ");
                email = sc.nextLine();
                    if (e.validateEmail(email) == false) {
                        System.out.println(Console_Colors.ANSI_RED + "**Su Correo no tiene un formato valido." + Console_Colors.ANSI_RESET);
                        System.out.println();
                    }
                
                }while (e.validateEmail(email) == false);
                do {
                    System.out.println("Ingrese su Contraseña: ");
                    System.out.print(">> ");
                    password = sc.nextLine();
                    System.out.println("Confirme su Contraseña: ");
                    System.out.print(">> ");
                    password2 = sc.nextLine();
                    if (password.equals(password2)) {
                        confirmacion = 1;
                    } else {
                        System.out.println(Console_Colors.ANSI_RED + "**Error en la confirmacion" + Console_Colors.ANSI_RESET);
                    }
                } while (confirmacion != 1);
                
                c.insertarUsuario(email, password2);
                email = "0";

            } catch (InputMismatchException e) {
                System.out.println(Console_Colors.ANSI_RED + "**Ingreso un dato Invalido." + Console_Colors.ANSI_RESET);
                System.out.println();
                sc.nextLine();
            }
        } while (!email.equals("0"));

    }

}

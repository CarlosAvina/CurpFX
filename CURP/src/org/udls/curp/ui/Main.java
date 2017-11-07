/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.udls.curp.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.udls.curp.modelo.Ciudadano;
import org.udls.curp.core.ObtenerCURP;

/**
 *
 * @author carlosavinaluna
 */
public class Main {
    public static void main(String[] args) throws Exception
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isr);
        
        Ciudadano ciudadano = new Ciudadano();
        int opción;
        
        do{
            System.out.println("Escribe tu primer nombre");
            ciudadano.setNombreA(teclado.readLine());
            System.out.println("Escribe tu segundo nombre (En caso de no tener simplemente presiona Enter)");
            ciudadano.setNombreB(teclado.readLine());
            System.out.println("Escribe tu apellido paterno");
            ciudadano.setApellidoP(teclado.readLine());
            System.out.println("Escribe tu apellido materno");
            ciudadano.setApellidoM(teclado.readLine());
            System.out.println("[1] Hombre\n[2] Mujer");
            ciudadano.setGenero(ObtenerCURP.obtenerGenero(Integer.valueOf(teclado.readLine())));
            System.out.println("¿En que estado naciste?\n" + ciudadano.estados);
            ciudadano.setEstado(ObtenerCURP.obtenerEstado(Integer.valueOf(teclado.readLine())));
            System.out.println("¿Cuál es el día de tu fecha de nacimiento?");
            ciudadano.setDiaNacimiento(Integer.valueOf(teclado.readLine()));
            System.out.println("¿Cuál es el mes de tu fecha de nacimiento?");
            ciudadano.setMesNacimiento(Integer.valueOf(teclado.readLine()));
            System.out.println("¿Cuál es el año de tu fecha de nacimiento?");
            ciudadano.setAñoNacimiento(Integer.valueOf(teclado.readLine()));
            
            System.out.println("El CURP es: " + (ObtenerCURP.obtenerCURP(ciudadano.getNombreA(), ciudadano.getNombreB(), ciudadano.getApellidoP(), ciudadano.getApellidoM(), ciudadano.getGenero(), ciudadano.getEstado(), ciudadano.getDiaNacimiento(), ciudadano.getMesNacimiento(), ciudadano.getAñoNacimiento())).toUpperCase());
            
            System.out.println("¿Desea calcular otro CURP?\n[1] Sí\n[2] No");
            opción = Integer.valueOf(teclado.readLine());
        }while(opción == 1);
    }
}

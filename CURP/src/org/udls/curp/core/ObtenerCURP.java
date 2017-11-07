/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.udls.curp.core;

/**
 *
 * @author carlosavinaluna
 */
public class ObtenerCURP {
    public static String[] soez = {"PEDO","PENE","PUTA","PUTO","PEDA","CACA","RATA","POPO","PITO"};
    public static String[] soezBien = {"PXDO","PXNE","PXTA","PXTO","PXDA","CXCA","RXTA","PXPO","PXTO"};
    
    public static String obtenerCURP(String nombreA, String nombreB, String apellidoP, String apellidoM, String genero, String estado, int dia, int mes, int año)
    {
        String curp = "";
        curp += apellidoP.charAt(0);
        
        for(int i = 1;i < apellidoP.length();i++)
            if(validarVocal(apellidoP.charAt(i)) == true)
            {
                curp += apellidoP.charAt(i);
                break;
            }
                
        curp += apellidoM.charAt(0);//3 (Si no tiene segundo apellido se pone una X)
        
        if(nombreA != "José" && nombreA != "María")//4
            curp += nombreA.charAt(0);
        else
            curp += nombreB.charAt(0);
        
        for(int i = 0;i < 100;i++) if((año + i) % 100 == 0) año = 100 - i;
        if(año < 10) curp = curp + "0" + año;
        else curp += año;
        
        if(mes < 10) curp = curp + "0" + mes;
        else curp += mes;
        
        if(dia < 10) curp = curp + "0" + dia;
        else curp += dia;
        
        curp += genero;
        curp += estado;
        
        for(int i = 1;i < apellidoP.length();i++)
        {
            if(validarVocal(apellidoP.charAt(i)) == false)
            {
                curp += apellidoP.charAt(i);
                break;
            }
            else if(i == apellidoP.length() - 1)
            {
                curp += 'X';
                break;
            }
        }
        
        for(int i = 1;i < apellidoM.length();i++)
        {
            if(validarVocal(apellidoM.charAt(i)) == false)
            {
                curp += apellidoM.charAt(i);
                break;
            }
            else if(i == apellidoM.length() - 1)
            {
                curp += 'X';
                break;
            }
        }
        
        if(nombreA != "José" && nombreA != "María")
            for(int i = 1;i < nombreA.length();i++)
            {
                if(validarVocal(nombreA.charAt(i)) == false)
                {
                    curp += nombreA.charAt(i);
                    break;
                }
                else if(i == nombreA.length() - 1)
                {
                    curp += 'X';
                    break;
                }
            }
        else
            for(int i = 1;i < nombreB.length();i++)
            {
                if(validarVocal(nombreB.charAt(i)) == false)
                {
                    curp += nombreB.charAt(i);
                    break;
                }
                else if(i == nombreB.length() - 1)
                {
                    curp += 'X';
                    break;
                }
            }
        
        curp = curp.replaceAll("\u00f1", "X");
        curp = curp.replaceAll("\u00d1", "X");
        
        curp += "00";
        
        curp = (curp).toUpperCase();
        curp = quitarPalabrasSoeces(curp);
        
        return curp;
    }
    
    public static boolean validarVocal(char letra)
    {
        if(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u')
            return true;
        
        return false;
    }
    
    public static String obtenerGenero(int genero)
    {
        do
        {
            if(genero == 1) return "H";
            else if(genero == 2) break;
        }while(genero != 1 && genero != 2);
        
        return "M";
    }
    
    public static String obtenerEstado(int estado)
    {
        switch(estado)
        {
            case 1: return "AS";
            case 2: return "BC";
            case 3: return "BS";
            case 4: return "CC";
            case 5: return "CL";
            case 6: return "CM";
            case 7: return "CS";
            case 8: return "CH";
            case 9: return "DF";
            case 10: return "DG";
            case 11: return "GT";
            case 12: return "GR";
            case 13: return "HG";
            case 14: return "JC";
            case 15: return "MC";
            case 16: return "MN";
            case 17: return "MS";
            case 18: return "NT";
            case 19: return "NL";
            case 20: return "OC";
            case 21: return "PL";
            case 22: return "QT";
            case 23: return "QR";
            case 24: return "SP";
            case 25: return "SL";
            case 26: return "SR";
            case 27: return "TC";
            case 28: return "TS";
            case 29: return "TL";
            case 30: return "VZ";
            case 31: return "YN";
            case 32: return "ZS";
        }
        return "NE";
    }
    
    public static String quitarPalabrasSoeces(String curp)
    {
        for(int i = 0;i < soez.length;i++)
            curp = curp.replaceAll(soez[i], soezBien[i]);
        return curp;
    }
}

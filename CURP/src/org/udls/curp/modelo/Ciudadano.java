/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.udls.curp.modelo;

/**
 *
 * @author carlosavinaluna
 */
public class Ciudadano {

    /**
     * @return the nombreA
     */
    public String getNombreA() {
        return nombreA;
    }

    /**
     * @param nombreA the nombreA to set
     */
    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    /**
     * @return the nombreB
     */
    public String getNombreB() {
        return nombreB;
    }

    /**
     * @param nombreB the nombreB to set
     */
    public void setNombreB(String nombreB) {
        this.nombreB = nombreB;
    }

    /**
     * @return the apellidoP
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * @param apellidoP the apellidoP to set
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * @return the apellidoM
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * @param apellidoM the apellidoM to set
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the diaNacimiento
     */
    public int getDiaNacimiento() {
        return diaNacimiento;
    }

    /**
     * @param diaNacimiento the diaNacimiento to set
     */
    public void setDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    /**
     * @return the mesNacimiento
     */
    public int getMesNacimiento() {
        return mesNacimiento;
    }

    /**
     * @param mesNacimiento the mesNacimiento to set
     */
    public void setMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    /**
     * @return the añoNacimiento
     */
    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    /**
     * @param añoNacimiento the añoNacimiento to set
     */
    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }
    private String nombreA;
    private String nombreB;
    private String apellidoP;
    private String apellidoM;
    private String genero;
    private String estado;
    private int diaNacimiento;
    private int mesNacimiento;
    private int añoNacimiento;
    
    public String estados = 
            "[1]Aguascalientes        [12]Guerrero      [23]Quintana Roo\n" +
            "[2]Baja California       [13]Hidalgo       [24]San Luis Potosi\n" +
            "[3]Baja California Sur   [14]Jalisco       [25]Sinaloa\n" +
            "[4]Campeche              [15]México        [26]Sonora\n" +
            "[5]Coahuila              [16]Michoacán     [27]Tabasco\n" +
            "[6]Colima                [17]Morelos       [28]Tamaulipas\n" +
            "[7]Chiapas               [18]Nayarit       [29]Tlaxcala\n" +
            "[8]Chihuahua             [19]Nuevo León    [30]Veracruz\n" +
            "[9]Distrito Federal      [20]Oaxaca        [31]Yucatán\n" +
            "[10]Durango              [21]Puebla        [32]Zacatecas\n" +
            "[11]Guanajuato           [22]Queretaro     [33]Nacido en el extranjero\n";
}

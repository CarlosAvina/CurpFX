/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.udls.curpfx.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.ButtonGroup;
import org.udls.curp.core.ObtenerCURP;

/**
 *
 * @author carlosavinaluna
 */
public class WindowMain extends javafx.application.Application
{
    @FXML TextField txtNombreA;
    @FXML TextField txtNombreB;
    @FXML TextField txtApellidoP;
    @FXML TextField txtApellidoM;
    @FXML ComboBox cmbEstados;
    @FXML ComboBox cmbDia;
    @FXML ComboBox cmbMes;
    @FXML ComboBox cmbAño;
    @FXML RadioButton radHombre;
    @FXML RadioButton radMujer;
    @FXML Button btnCalcular;
    @FXML Label lblCURP;
    
    ButtonGroup bgRadioButton = new ButtonGroup();
    
    
    FXMLLoader fxmll;
    Scene scene;
    Stage window;
    ObtenerCURP curp;
    
    ObservableList<Number> dias = 
    FXCollections.observableArrayList();
    
    ObservableList<Number> meses = 
    FXCollections.observableArrayList();
    
    ObservableList<Number> años =
            FXCollections.observableArrayList();
    
    ObservableList<String> estados =
            FXCollections.observableArrayList(
            "Aguascalientes",
            "Baja California",
            "Baja California Sur",
            "Campeche",
            "Coahuila",
            "Colima",
            "Chiapas",
            "Chihuahua",
            "Distrito Federal",
            "Durango",
            "Guanajuato",
            "Guerrero",
            "Hidalgo",
            "Jalisco",
            "México",
            "Michoacán",
            "Morelos",
            "Nayarit",
            "Nuevo León",
            "Oaxaca",
            "Puebla",
            "Queretaro",
            "Quintana Roo",
            "San Luis Potosi",
            "Sinaloa",
            "Sonora",
            "Tabasco",
            "Tamaulipas",
            "Tlaxcala",
            "Veracruz",
            "Yucatán",
            "Zacatecas",
            "Nacido en el extranjero"
            );
    
    //Hola shaba esto es una prueba :D
    public WindowMain()
    {
        super();
        
        fxmll = new FXMLLoader(System.class.getResource("/org/udls/curpfx/gui/fxml/window_main.fxml"));
        fxmll.setController(this);
        curp = new ObtenerCURP();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        fxmll.load();
        scene = new Scene(fxmll.getRoot());
        primaryStage.setScene(scene);
        
        for(int i = 1900;i < 2018;i++) años.add(i);
        for(int i = 0;i < 12;i++) meses.add(i + 1);
        for(int i = 0;i < 31;i++) dias.add(i + 1);
        
        cmbDia.setItems(dias);
        cmbMes.setItems(meses);
        cmbAño.setItems(años);
        cmbEstados.setItems(estados);
        lblCURP.setText("");
        
        radHombre.setOnAction((ActionEvent event) ->
        {
            if(radHombre.isSelected()) radMujer.setSelected(false);
        });
        radMujer.setOnAction((ActionEvent event) ->
        {
            if(radMujer.isSelected()) radHombre.setSelected(false);
        });
        
        btnCalcular.setOnAction((ActionEvent event) -> 
        {
            lblCURP.setText(calcularCURP());
        });
        
        window = primaryStage;
        window.setTitle("Calculador de CURP JavaFX");
        window.show();
    }
    
    private String calcularCURP()
    {
        String nombreA = txtNombreA.getText();
        String nombreB = txtNombreB.getText();
        String apellidoP = txtApellidoP.getText();
        String apellidoM = txtApellidoM.getText();
        int estado = (int)cmbEstados.getSelectionModel().getSelectedIndex() + 1;
        int dia = (int)cmbDia.getSelectionModel().getSelectedItem();
        int mes = (int)cmbMes.getSelectionModel().getSelectedItem();
        int año = (int)cmbAño.getSelectionModel().getSelectedItem();
        int genero = 0;
        
        if(radHombre.isSelected()) genero = 1;
        else genero = 2;
        
        return curp.obtenerCURP(nombreA, nombreB, apellidoP, apellidoM, curp.obtenerGenero(genero),curp.obtenerEstado(estado), dia, mes, año);
    }
}

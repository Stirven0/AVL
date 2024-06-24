package com.mycompany.avl;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import arbolBinario.Arbol;
import arbolBinario.ArbolPanel;
import arbolBinario.Lista;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.IntegerStringConverter;

public class SecondaryController implements Initializable {

    ArbolPanel arbolPanel = new ArbolPanel();
    Arbol arbol = new Arbol();
    Lista list = new Lista();

    @FXML
    private Label inOrden;

    @FXML
    private Label posOrden;

    @FXML
    private Label preOrden;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnAvanzar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField entrada;

    @FXML
    private BorderPane panel;

    @FXML
    private Slider slider;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // slider.setOnDragDetected(event ->{
        //     esliderSet();
        // } );
        slider.setValue(50);
        panel.setCenter(arbolPanel);

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?") || newText.isEmpty()) { // Regex para solo dígitos
                return change;
            }
            return null; // Ignorar el cambio si no es un dígito
        };
        entrada.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0, filter));

        entrada.setText("");
        inOrden.setText("Sin valor");
        posOrden.setText("Sin valor");
        preOrden.setText("Sin valor");
        
        btnVolver.setDisable(true);
        btnAvanzar.setDisable(true);
    }

    @FXML
    void agregarNodo(MouseEvent event) {
        if (entrada.getText().compareTo("") != 0) {
            arbol.insertar(Integer.parseInt(entrada.getText()));
            // arbolPanel.show(arbol.getRaiz());
            arbolPanel.incertar(arbol.getRaiz(),Integer.parseInt(entrada.getText()));
            // arbolPanel.name();
            Arbol aux = new Arbol();
            aux.clonarTo(arbol);
            list.addToLasd(aux);
            btnVolver.setDisable(false);
            btnAvanzar.setDisable(true);
            recorridos();
            entrada.setText("");
        }

    }

    
    // public boolean sig() {
    //     Arbol aux = list.siguiente();
    //     return aux == arbol;
    // }
    
    @FXML
    void eliminarNodo(MouseEvent event) {
        
        if (entrada.getText().compareTo("") != 0) {
            arbol.eliminar(Integer.parseInt(entrada.getText()));
            arbolPanel.getChildren().clear();
            arbolPanel.show(arbol.getRaiz());
            
            Arbol aux = new Arbol();
            aux.clonarTo(arbol);
            list.addToLasd(aux);
            btnAvanzar.setDisable(true);
            entrada.setText("");
            recorridos();
        }
    }
    
    @FXML
    void avanzar(MouseEvent event) {

        Arbol siguiente = list.siguiente();
        if (siguiente != null) {
            arbol = siguiente;
            arbolPanel.getChildren().clear();
            arbolPanel.show(arbol.getRaiz());
            recorridos();
            btnVolver.setDisable(false);
            entrada.setText("");

        }else{
            btnAvanzar.setDisable(true);

        }

    }

    @FXML
    void volver(MouseEvent event) {

        Arbol anterior = list.anterior();
        if (anterior != null) {
            arbol = anterior;
            arbolPanel.getChildren().clear();
            arbolPanel.show(arbol.getRaiz());
            recorridos();
            btnAvanzar.setDisable(false);
            entrada.setText("");

        }else{

            btnVolver.setDisable(true);
            
        }
    }

    // public boolean vol() {
    //     int n1 = list.anterior().numeroNodos();
    //     int n2 = arbol.numeroNodos();
    //     // return aux == arbol;
    // }

    public void recorridos() {
        inOrden.setText(arbol.inorden().toString());
        posOrden.setText(arbol.postorden().toString());
        preOrden.setText(arbol.preorden().toString());
    }
    @FXML
    void esliderSet(MouseEvent event) {

        arbolPanel.setDuration(slider.getValue()*100);
        System.out.println(slider.getValue());
    }
    

}
package com.mycompany.avl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import Oters.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable{


    TreeItem<String> rooItem = new TreeItem<String>("Root");
    
    @FXML
    private TableView<Persona> tvDatos;
    
    @FXML
    private TreeView treeview;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        

        TreeItem<String> db1 = new TreeItem<String>("Data Base 1");
        TreeItem<String> db2 = new TreeItem<String>("Data Base 2");
        TreeItem<String> db3 = new TreeItem<String>("Data Base 3");


        TreeItem<String> db1_tabla1 = new TreeItem<String>("Tabla 1");
        TreeItem<String> db1_tabla2 = new TreeItem<String>("Tabla 2");
        TreeItem<String> db1_tabla3 = new TreeItem<String>("Tabla 3");
        TreeItem<String> db2_tabla1 = new TreeItem<String>("Tabla 1");
        TreeItem<String> db2_tabla2 = new TreeItem<String>("Tabla 2");
        TreeItem<String> db3_tabla1 = new TreeItem<String>("Tabla 1");
        TreeItem<String> db3_tabla2 = new TreeItem<String>("Tabla 2");
        TreeItem<String> db3_tabla3 = new TreeItem<String>("Tabla 3");

        
        db1.getChildren().addAll(db1_tabla1,db1_tabla2,db1_tabla3);
        db2.getChildren().addAll(db2_tabla1,db2_tabla2);
        db3.getChildren().addAll(db3_tabla1,db3_tabla2,db3_tabla3);
        
        rooItem.getChildren().addAll(db1,db2,db3);
        treeview.setRoot(rooItem);
        treeview.setShowRoot(false);



        mostrar_datos_tabla();
    }

    private void mostrar_datos_tabla() {
        ObservableList<Persona> lista = FXCollections.observableArrayList();
        Persona p1 = new Persona("julio","cesar","amaya","amaya",29,"masculino","soltero","Calle 41 # 11a-30","riohacha","la guajira","colombia",123123);
        for (int i = 0; i < 40; i++) {
            lista.add(new Persona("julio","cesar","amaya","amaya",29,"masculino","soltero","Calle 41 # 11a-30","riohacha","la guajira","colombia",123123));
        }

        lista.add(p1);
        tvDatos.setItems(lista);
        
        TableColumn<Persona, String> primerNombre = new TableColumn<Persona, String>("Primer Nombre");
        primerNombre.setCellValueFactory(new PropertyValueFactory<>("primerNombre"));
        
        TableColumn<Persona, String> segundoNombre = new TableColumn<Persona, String>("Segundo Nombre");
        segundoNombre.setCellValueFactory(new PropertyValueFactory<>("segundoNombre"));
        
        TableColumn<Persona, String> primerApellido = new TableColumn<Persona, String>("Primer Apellido");
        primerApellido.setCellValueFactory(new PropertyValueFactory<>("primerApellido"));
        
        TableColumn<Persona, String> segundoApellido = new TableColumn<Persona, String>("Segundo Apellido");
        segundoApellido.setCellValueFactory(new PropertyValueFactory<>("segundoApellido"));
        
        TableColumn<Persona, String> edad = new TableColumn<Persona, String>("Edad");
        edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        
        TableColumn<Persona, String> sexo = new TableColumn<Persona, String>("Sexo");
        sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        
        TableColumn<Persona, String> stadoCivil = new TableColumn<Persona, String>("Estado Civil");
        stadoCivil.setCellValueFactory(new PropertyValueFactory<>("stadoCivil"));
        
        TableColumn<Persona, String> direccion = new TableColumn<Persona, String>("Direccion");
        direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        
        TableColumn<Persona, String> ciudad = new TableColumn<Persona, String>("Ciudad");
        ciudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        
        TableColumn<Persona, String> departamento = new TableColumn<Persona, String>("Departamento");
        departamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        
        TableColumn<Persona, String> pais = new TableColumn<Persona, String>("Pais");
        pais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        
        TableColumn<Persona, String> salario = new TableColumn<Persona, String>("Salario");
        salario.setCellValueFactory(new PropertyValueFactory<>("salario"));

        tvDatos.getColumns().clear();
        // tvDatos.getColumns().addAll(primerNombre);
        tvDatos.getColumns().addAll(primerNombre,segundoNombre,primerApellido,segundoApellido,edad,sexo,stadoCivil,direccion,ciudad,departamento,pais,salario);
    }

    public void crearDB() {
        TreeItem<String> db = new TreeItem<String>("Data Base");
        rooItem.getChildren().add(db);
    }
    public void eliminarDB() {
        TreeItem<String> item = (TreeItem<String>) treeview.getSelectionModel().getSelectedItem();
        if (rooItem.getChildren().contains(item)) {
            rooItem.getChildren().remove(item);
        }
    }
    public void crearTabla() {
        TreeItem<String> item = (TreeItem<String>) treeview.getSelectionModel().getSelectedItem();
        TreeItem<String> tabla = new TreeItem<String>("Tabla");

        if (rooItem.getChildren().contains(item)) {
            item.getChildren().add(tabla);
        }
        
    }
    public void eliminarTabla() {
        
        TreeItem<String> item = (TreeItem<String>) treeview.getSelectionModel().getSelectedItem();
        if (!rooItem.getChildren().contains(item)) {
            item.getParent().getChildren().remove(item);
        }
    }

    public void selectItem() {
        TreeItem<String> item = (TreeItem<String>) treeview.getSelectionModel().getSelectedItem();
        if (item != null) {
            System.out.println(item.getValue());
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}

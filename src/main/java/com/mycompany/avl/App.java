package com.mycompany.avl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
@SuppressWarnings("unused")
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("secondary"), 640, 480);

        Image img = new Image("title.png");
        stage.setScene(scene);
        stage.getIcons().add(img);
        stage.setTitle("Data Base Creator");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();

        // Arbol avl = new Arbol();
        // Lista list = new Lista();
        // avl.insertar(1);
        // avl.insertar(2);
        // avl.insertar(3);
        // avl.insertar(4);
        // avl.insertar(5);
        // avl.insertar(6);
        // avl.insertar(7);

        // // avl.insertar(1);
        // // avl.insertar(2);
        // // avl.insertar(3);
        // // avl.insertar(4);
        // // avl.insertar(5);
        // // avl.insertar(6);
        // // avl.insertar(7);
        // // avl.insertar(7);

        // Scanner s = new Scanner(System.in);

        // int op = 0;
        // do {
        //     System.out.println("");
        //     System.out.println("Arboles AVL");
        //     System.out.println("0__Par salir");
        //     System.out.println("1__Agregar Automaticamente");
        //     System.out.println("2__Agregar Manualmente");
        //     System.out.println("3__Eliminar un Valor");
        //     System.out.println("4__Recorrido InOrden");
        //     System.out.println("5__Recorrido PreOrden");
        //     System.out.println("6__Recorrido PosOrden");
        //     System.out.println("7__Estado anterior");
        //     System.out.println("8__Estado Posteriro");
        //     System.out.println("9__Ver Arbol");
        //     System.out.println("10__Total de nodos");
        //     System.out.println("11__Limpiar el arbol");
        //     System.out.println("12__Nombre del arbol");
        //     System.out.println("13__Clonar el arbol");
        //     // System.out.println("Arboles AVL");

        //     op = s.nextInt();
        //     switch (op) {
        //         case 0:
        //             System.out.println("Adios");
        //             System.exit(0);
        //             break;
        //         case 1:
        //             System.out.print("Cuantos nodos desea ingresar: ");
        //             int nNodos = s.nextInt();

        //             for (int i = 1; i <= nNodos; i++) {
        //                 avl.insertar(i);
        //                 Arbol aux = new Arbol();
        //                 aux.clonarTo(avl);
        //                 list.addToLasd(aux);
        //             }

        //             break;
        //         case 2:
        //             System.out.print("Ingrese el valor a insertar: ");
        //             avl.insertar(s.nextInt());
        //             break;
        //         case 3:
        //             System.out.print("Ingrese el valor a eliminar:");
        //             avl.eliminar(s.nextInt());
        //             break;
        //         case 4:

        //             System.out.println(avl.inorden());
        //             break;
        //         case 5:
        //             System.out.println(avl.preorden());

        //             break;
        //         case 6:

        //             System.out.println(avl.postorden());
        //             break;
        //         case 7:
        //             avl = list.anterior();
        //             break;
        //         case 8:
        //             avl = list.siguiente();
        //             break;
        //         case 9:
        //             avl.show();
        //             break;
        //         case 10:
        //             System.out.print("Nodos en el arbol: ");
        //             System.out.println(avl.numeroNodos());
        //             break;
        //         case 11:
        //            avl.clear();
        //             break;
        //         case 12:
        //             System.out.println(avl.getName());
        //             break;
        //         case 13:
        //             // System.out.print("Ingrese el nombre del arvol a crear:");

        //             Arbol aux = new Arbol();

        //             aux.clonarTo(avl);
        //             break;

        //         default:
        //             System.out.println("Ingrese un valor del menu");

        //             break;
        //     }
        // } while (op != 0);
    }

}
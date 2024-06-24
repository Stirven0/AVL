package arbolBinario;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ArbolPanel extends Pane {
    private double radio = 15;
    private double espacioVertical = 50;
    private double duration = 5000;
    private TranslateTransition transition = new TranslateTransition(Duration.millis(duration));

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public ArbolPanel() {
        setBackground(Background.fill(Color.AQUA));
    }

    public void show(Nodo raiz) {
        // this.getChildren().clear();
        if (raiz != null) {

            // Circle celector = celecto(getWidth() / 2, espacioVertical);
            // getChildren().add(celector);
            showRec(raiz, getWidth() / 2, espacioVertical, getWidth() / 4);

        }
    }

    private void showRec(Nodo raiz, double x, double y, double espacioHorizontal) {
        if (raiz.hijoIzquierdo != null) {

            Line lineaIzquierda = new Line(x - espacioHorizontal, y + espacioVertical, x, y);
            getChildren().add(lineaIzquierda);

            showRec(raiz.hijoIzquierdo, x - espacioHorizontal, y + espacioVertical, espacioHorizontal / 2);
        }

        if (raiz.hijoDerecho != null) {

            Line LineaDerecha = new Line(x + espacioHorizontal, y + espacioVertical, x, y);
            getChildren().add(LineaDerecha);

            showRec(raiz.hijoDerecho, x + espacioHorizontal, y + espacioVertical, espacioHorizontal / 2);
        }
        getChildren().addAll(nodo(x, y), new Text(x - 4, y + 4, raiz.valor + ""));
    }

    private Circle nodo(double x, double y) {
        Circle circle = new Circle(x, y, radio);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        // getChildren().add(new Text(x - 4, y + 4, node.valor + ""));
        return circle;
    }

    private Circle celecto(double x, double y) {
        Circle circle = new Circle(x, y, radio);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.MAGENTA);
        circle.setStrokeWidth(8);
        return circle;
    }

    private Nodo insertarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return raiz;
        }

        if (dato < raiz.valor) {
            raiz.hijoIzquierdo = insertarRec(raiz.hijoIzquierdo, dato);
        } else if (dato > raiz.valor) {
            raiz.hijoDerecho = insertarRec(raiz.hijoDerecho, dato);
        }

        // raiz = balancearArbol(raiz);
        return raiz;
    }

    public void incertar(Nodo raiz, int valor) {
        if (raiz != null) {

            this.getChildren().clear();
            Circle celector = celecto(getWidth() / 2, espacioVertical);
            this.getChildren().add(celector);
            incerRec(raiz, getWidth() / 4, espacioVertical, getWidth() / 8, celector, valor);
            show(raiz);
        }
    }
    

    private void incerRec(Nodo raiz, double x, double y, double espacioHorizontal, Circle nodo, int valor) {
        if (raiz != null) {
            TranslateTransition transition = new TranslateTransition(Duration.millis(duration), nodo);
            //Ir a la izquierda
            if (raiz.valor > valor) {
                transition.setToX(x*-1); //espacioHorizontal
                transition.setToY(y);
                transition.setOnFinished(evento -> {
                    incerRec(raiz.hijoIzquierdo, x+espacioHorizontal, y + espacioVertical, espacioHorizontal/2 , nodo, valor);

                });
                transition.play();
            }
            //Ir a la derecha
            if (raiz.valor < valor) {
                transition.setToX(x);
                transition.setToY(y);
                transition.setOnFinished(evento -> {
                    incerRec(raiz.hijoDerecho, x + espacioHorizontal, y + espacioVertical, espacioHorizontal / 2,
                            nodo, valor);
                });
                transition.play();
            }
        }
        // getChildren().remove(nodo);

    }
}

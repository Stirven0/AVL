package arbolBinario;

import javafx.animation.PathTransition;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class RotationAnimation {
    /**
     * @param line 
     * @param duration
     * @return
     */
    public static PathTransition createPathTransition(Line line, double duration) {
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(duration));
        pathTransition.setPath(line);
        pathTransition.setCycleCount(1);
        return pathTransition;
    }
}

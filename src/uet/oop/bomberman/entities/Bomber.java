package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Bomber extends Entity {

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {
        //if (handle() )
    }

    public int handle(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.UP)) {
            return 1;
        } else if (ke.getCode().equals(KeyCode.RIGHT)) {
            return 2;
        } else if (ke.getCode().equals(KeyCode.LEFT)) {
            return 3;
        } else if (ke.getCode().equals(KeyCode.DOWN)) {
            return 4;
        } else {
            return 0;
        }
    }
}

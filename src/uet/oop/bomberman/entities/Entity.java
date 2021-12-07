package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;
import java.util.List;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected Image img;


    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();


    public Rectangle getBound() {
        return new Rectangle(x, y, (int)img.getWidth(), (int)img.getHeight());
    }

    public static boolean checkCollision(Entity e, int direction, List<Entity> stillObjects) {
        Rectangle rBomber = e.getBound();
        int x = (int)rBomber.getX();
        int y = (int)rBomber.getY();
        switch (direction){
            case 0: // right
                x = (int)rBomber.getX() + 1;
                break;
            case 1: // down
                y = (int)rBomber.getY() + 1;
                break;
            case 2: // left
                x = (int)rBomber.getX() - 1;
                break;
            case 3: // up
                y = (int)rBomber.getY() - 1;
                break;
        }
        Rectangle nrBomber = new Rectangle(x, y, 32, 32);
        for (Entity entity: stillObjects) {
            Rectangle rEntity = entity.getBound();
            if (nrBomber.intersects(rEntity) && entity instanceof Wall) {
                System.out.println("Va cham");
                return true;
            }
        }

        return false;
    }
}

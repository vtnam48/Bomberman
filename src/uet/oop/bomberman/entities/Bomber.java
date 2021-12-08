package uet.oop.bomberman.entities;

import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Collision;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;
import java.security.Key;
import java.util.List;

import static uet.oop.bomberman.BombermanGame.*;

public class Bomber extends Entity {
    public static final int SPEED = 4;
    final int time = 80;
    static int direction = 0;

    public Bomber(int x, int y, int direction, Image img) {
        super(x, y, img);
        this.direction = direction;
    }

    @Override
    public void update() {
    }

    public void goRight() {
        x += SPEED;
        this.img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, x, time).getFxImage();
    }

    public void goLeft() {
        x -= SPEED;
        this.img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, x, time).getFxImage();
    }

    public void goUp() {
        y -= SPEED;
        this.img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, y, time).getFxImage();
    }

    public void goDown() {
        y += SPEED;
        this.img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, y, time).getFxImage();
    }


    public Image getImage() {
        return this.img;
    }

    public void move(int direction) {
        switch (direction){
            case 0:
                this.goRight();
                break;
            case 1:
                this.goDown();
                break;
            case 2:
                this.goLeft();
                break;
            case 3:
                this.goUp();
                break;
        }
    }

    public void run(Bomber bomber, Scene scene) {
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.RIGHT) {
                direction = 0;
                if (!super.checkCollision(BombermanGame.bomberman, direction, BombermanGame.stillObjects, SPEED))
                    ((Bomber) bomber).move(0);
            }
            if(event.getCode() == KeyCode.LEFT) {
                direction = 2;
                if (!super.checkCollision(BombermanGame.bomberman, direction, BombermanGame.stillObjects, SPEED))

                    ((Bomber) bomber).move(2);
            }
            if(event.getCode() == KeyCode.UP) {
                direction = 3;
                if (!super.checkCollision(BombermanGame.bomberman, direction, BombermanGame.stillObjects, SPEED))

                    ((Bomber) bomber).move(3);
            }
            if(event.getCode() == KeyCode.DOWN) {
                direction = 1;
                if (!super.checkCollision(BombermanGame.bomberman, direction, BombermanGame.stillObjects, SPEED))

                    ((Bomber) bomber).move(1);
            }
            if (event.getCode() == KeyCode.SPACE) {
                int x = (int)(bomber.getBound().getX()/32);
                int y = (int)(bomber.getBound().getY()/32);
                Entity newBomb = new Bomb(x, y, Sprite.bomb.getFxImage());
                bombs.add(newBomb);
                System.out.println("Space");
//                System.out.println(  + " " + );
            }

//            System.out.println(((Bomber) bomber).getImage().getHeight() +" " + ((Bomber) bomber).getImage().getWidth());

        });
    }

//    @Override
//    public Rectangle getBound() {
//        return new Rectangle(x, y, (int)img.getWidth()-2, (int)img.getHeight()-2);
//    }
}

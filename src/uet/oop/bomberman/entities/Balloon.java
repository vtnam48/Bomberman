package uet.oop.bomberman.entities;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.util.Duration;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Balloon extends Entity {
    public Balloon(int x, int y, Image img) {
        super(x, y, img);
    }
    public static final int SPEED = 4;


    @Override
    public void update() {
        Random random = new Random();
        int r = random.nextInt(4);
//        try {
//            TimeUnit.SECONDS.sleep(1);
//
//        } catch (InterruptedException e) {
//            System.out.println("error");
//        }
        if (r == 0) goRight();
        if (r == 1) goLeft();
        if (r == 2) goUp();
        if (r == 3) goDown();
    }

    public void goRight() {
//        Timeline oneSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event1) -> {
//            x += SPEED;
//            this.img = Sprite.balloom_right1.getFxImage();
//        }));

        x += SPEED;
//        this.img = Sprite.balloom_right1.getFxImage();
        this.img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, x, 20).getFxImage();

    }


    public void goLeft() {
        x -= SPEED;
        this.img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, x, 20).getFxImage();
    }

    public void goUp() {
        y -= SPEED;
        this.img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, x, 20).getFxImage();

    }

    public void goDown() {
        y += SPEED;
        this.img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, x, 20).getFxImage();
    }
}

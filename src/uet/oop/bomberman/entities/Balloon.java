package uet.oop.bomberman.entities;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.util.Duration;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Balloon extends Entity {
    public static final int SPEED = 1;
    int direction = 0;
    int time = 0;
    int timeAnimate = 80;
    public Balloon(int x, int y, int direction, Image img) {
        super(x, y, img);
        this.direction = direction;
    }

    @Override
    public void update(){

        if (this.getBound().getX()%32 == 0 && this.getBound().getY()%32 ==0 && time < 0) {
            Random random = new Random();
            this.direction = random.nextInt(4);
            time = 200;
        }
        run(this);
        time--;
    }

    public void run(Balloon balloon) {
        int direc = balloon.getDirection();
//        System.out.println(direc);
        if (!super.checkCollision(balloon, direc, BombermanGame.stillObjects, SPEED)) {
            if (direction == 0) move(0);
            if (direction == 1) move(1);
            if (direction == 2) move(2);
            if (direction == 3) move(3);
        } else {
            if (direc == 3) {
                balloon.direction = 0;
            } else if (direc == 2){
                balloon.direction = 3;
            } else if (direc == 1) {
                balloon.direction = 2;
            } else {
                balloon.direction = 1;
            }
//            System.out.println("else");
        }
    }

    public void goRight() {
        x += SPEED;
        this.img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, x, timeAnimate).getFxImage();

    }

    public void goLeft() {
        x -= SPEED;
        this.img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, x, timeAnimate).getFxImage();
    }

    public void goUp() {
        y -= SPEED;
        this.img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, x, timeAnimate).getFxImage();

    }

    public void goDown() {
        y += SPEED;
        this.img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, x, timeAnimate).getFxImage();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
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
}

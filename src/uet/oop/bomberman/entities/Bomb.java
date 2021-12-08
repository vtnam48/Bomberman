package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import sun.security.provider.ConfigFile;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends Entity{
    int time;
    public List<Entity> explosion = new ArrayList<>();
    public Bomb(int x, int y, Image img) {
        super(x, y, img);
        time = 300;
        Entity Flame0 = new Flame(x + 1, y, Sprite.explosion_horizontal_right_last.getFxImage());
        Entity Flame1 = new Flame(x, y - 1, Sprite.explosion_vertical_top_last.getFxImage());
        Entity Flame2 = new Flame(x - 1, y, Sprite.explosion_horizontal_left_last.getFxImage());
        Entity Flame3 = new Flame(x, y + 1, Sprite.explosion_vertical_down_last.getFxImage());

        explosion.add(Flame0);
        explosion.add(Flame1);
        explosion.add(Flame2);
        explosion.add(Flame3);
    }

    @Override
    public void update() {
        if (this.time > 50) load();
        if (this.time > 0 && this.time <= 50) explo();

    }

    public void load() {
        this.img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, time--, 80).getFxImage();
    }

    public void explo() {
        this.img = Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1, Sprite.bomb_exploded2, time--, 80).getFxImage();

        for (Entity e: explosion) {
            e.render(BombermanGame.gc);
        }

    }

    public int getTime() {
        return time;
    }
}

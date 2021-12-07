package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.Rectangle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;
    private final static String FILE_URL = "C:\\Users\\vuthe\\Desktop\\Bomberman\\res\\levels\\Level1.txt";

    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();

    public static Entity bomberman;
    Scene scene;

//    int direction;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        try {
            createMap();
        } catch (IOException e) {
            System.out.println(4);
        }

        System.out.println("End");
    }

    public void createMap() throws IOException {
        File file = new File(FILE_URL);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = "";
        line = reader.readLine();

        for (int i = 0; i < 13; i++) {
            line = reader.readLine();

            for (int j = 0; j < line.length(); j++) {
                Entity object;

                if (line.charAt(j) == '#') {
                    object = new Wall(j, i, Sprite.wall.getFxImage());
                } else if (line.charAt(j) == '*') {
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                } else if (line.charAt(j) == 'x') {
                    object = new Portal(j, i, Sprite.portal.getFxImage());
                } else if (line.charAt(j) == 'p') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    bomberman = new Bomber(1, 1, 0, Sprite.player_right.getFxImage());
//                    this.entities.add(bomberman);
                } else if (line.charAt(j) == '1') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    Entity balloon = new Balloon(j, i,0, Sprite.balloom_right1.getFxImage());
                    this.entities.add(balloon);

                } else if (line.charAt(j) == '2') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    Entity oneal = new Oneal(j, i, Sprite.oneal_right1.getFxImage());
                    this.entities.add(oneal);

                } else {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                }

                stillObjects.add(object);
            }
        }
    }

    public void update() {

        entities.forEach(Entity::update);
        ((Bomber) bomberman).run((Bomber) bomberman, scene);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        bomberman.render(gc);
    }


}

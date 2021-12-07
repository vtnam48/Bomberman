package uet.oop.bomberman;

import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Wall;

import java.awt.*;
import java.util.List;

public class Collision {
//    public static boolean checkCollision(Entity e, int direction, List<Entity> stillObjects) {
//        Rectangle rBomber = e.getBound();
//        int x = (int)rBomber.getX();
//        int y = (int)rBomber.getY();
//        switch (direction){
//            case 0: // right
//                x = (int)rBomber.getX() + 2;
//                break;
//            case 1: // down
//                y = (int)rBomber.getY() + 2;
//                break;
//            case 2: // left
//                x = (int)rBomber.getX() - 2;
//                break;
//            case 3: // up
//                y = (int)rBomber.getY() - 2;
//                break;
//        }
//        Rectangle nrBomber = new Rectangle(x, y, 32, 32);
//        for (Entity entity: stillObjects) {
//            Rectangle rEntity = entity.getBound();
//            if (nrBomber.intersects(rEntity) && entity instanceof Wall) {
//                System.out.println("Va cham");
//                return true;
//            }
//        }
//
//        return false;
//    }
}

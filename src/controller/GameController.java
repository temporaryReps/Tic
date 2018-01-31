package controller;

import model.Field;
import model.Point;
import model.User;
import view.GameWindow;

public class GameController {
    public static GameWindow window;
    public static User user;

    public static void doShoot(Point point, Field.Type type) {
        User.setPoint(point);
        User.setIsShoot(true);
    }

    public static void showResume(String s) {
        window.showResume(s);
    }

    public static void setPoint(Point point, String s) {
        window.showCell(point.getX(), point.getY(), s);
    }
}

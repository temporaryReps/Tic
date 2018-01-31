package model;

import model.Point;

/**
 * Created by igor on 21.08.16.
 */
public class Computer {

    public Point getShootPoint() {
        return Point.getRandomPoint();
    }
}

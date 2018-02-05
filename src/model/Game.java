package model;

import controller.GameController;

/**
 * Created by igor on 21.08.16.
 */
public class Game {
    Field field;
    User user;
    Computer computer;

    public void start() {
        field = new Field();
        user = new User();
        computer = new Computer();
        GameController.user = user;

        field.init();
        field.showField();

        while (true) {
            synchronized (GameController.key) {
                try {
                    GameController.key.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("start iteration");

            field.shoot(user.getShootPoint(), Field.Type.X);
            field.showField();
            if (field.whoIsWinner() == Field.Type.X) {
                GameController.showResume("Победил " + Field.Type.X);
                break;
            }

            field.shoot(computer.getShootPoint(), Field.Type.O);
            field.showField();
            if (field.whoIsWinner() == Field.Type.O) {
                GameController.showResume("Победил " + Field.Type.O);
                break;
            }
        }
    }
}

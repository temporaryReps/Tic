package model;


import controller.GameController;

/**
 * Created by igor on 21.08.16.
 */
public class Field {
    public static final int SIZE = 3;

    public enum Type {
        X, O, NONE
    }

    Type[][] cells = new Type[SIZE][SIZE];

    public void init() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = Type.NONE;
            }
        }
    }

    public void showField() { // todo убрать во View
        System.out.println("show");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                switch (cells[i][j]) {
                    case NONE:
                        GameController.setPoint(new Point(i, j), ".");
                        break;
                    case X:
                        GameController.setPoint(new Point(i, j), "X");
                        break;
                    case O:
                        GameController.setPoint(new Point(i, j), "O");
                        break;
                }
            }
        }
    }

    //    void shoot(int x, int y, Type who) {
    public void shoot(Point point, Type who) {
        //todo DZ проверить границы
        //todo DZ проверить не ходил ли кто? Запрет на повторный ход в занятую ячейку
        if (point.getX() > SIZE || point.getY() > SIZE
                || point.getX() < 0 || point.getY() < 0) {
            return;
        }

        if (!cells[point.getX()][point.getY()].equals(Type.NONE)) {
            GameController.showResume("Ячейка уже занята");
            return;
        }

        GameController.showResume("Играем!");
        cells[point.getX()][point.getY()] = who;
    }

    public Type whoIsWinner() {
        if (checkWin(Type.X)) {
            return Type.X;
        }
        if (checkWin(Type.O)) {
            return Type.O;
        }
        return Type.NONE;
    }

    private boolean checkWin(Type t) {
        // todo DZ еще 7 вариантов

        for (int i = 0; i < SIZE; i++) {
            if (cells[0][i] == t && cells[1][i] == t && cells[2][i] == t) {
                return true;
            }

            if (cells[i][0] == t && cells[i][1] == t && cells[i][2] == t) {
                return true;
            }
        }

        if (cells[0][0] == t && cells[1][1] == t && cells[2][2] == t) {
            return true;
        }

        return cells[0][2] == t && cells[1][1] == t && cells[2][0] == t;
    }
}

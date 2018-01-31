
import model.Game;
import view.GameWindow;


public class Main {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.init();

        Game game = new Game();
        game.start();
    }
}

import javax.swing.*;

public class SnakeMain {
    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        JFrame frame = new JFrame("Snake Game");
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        game.init();
    }
}


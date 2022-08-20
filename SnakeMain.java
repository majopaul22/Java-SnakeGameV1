import javax.swing.*;
import java.awt.*;

public class SnakeMain {
    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        JFrame frame = new JFrame("Snake Game");
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(400, 400));
        game.init();
    }
}


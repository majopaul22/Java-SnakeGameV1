import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Token {
    int x, y, score;
    Snake snake;
    Token(Snake s) {
        x = (int) (Math.random() * 395);
        y = (int) (Math.random() * 395);
        snake = s;
    }
    public void changePosition() {
        x = (int) (Math.random() * 395);
        y = (int) (Math.random() * 395);
    }
    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 6, 6);
    }
    public int getScore() {
        return score;
    }
    public boolean snakeCollision() {
        int snakeX  = snake.getX() + 2;
        int snakeY  = snake.getY() + 2;
        if (snakeX >= x - 1 && snakeX <= (x+7)) {
            if (snakeY >= y - 1 && snakeY <= (y+7)) {
                changePosition();
                score++;
                snake.setElongated(true);
                System.out.println("snake collides token: " + score);
                return true;
            }
        }
        return false;
    }
}


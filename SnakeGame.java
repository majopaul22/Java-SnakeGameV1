import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends Applet implements Runnable, KeyListener {

    Graphics gfx;
    Image img;
    Thread thread;
    Snake snake;
    Token token;
    boolean gameOver;

    public void init(){
//        this.resize(400, 400);
        img = createImage(400, 400);
        gfx = img.getGraphics();
        this.addKeyListener(this);
        snake = new Snake();
        token = new Token(snake);
        thread = new Thread(this);
        thread.start();
        gameOver = false;
    }
    public void paint(Graphics g){
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, 400, 400);
        if(!gameOver) {
            snake.draw(gfx);
            token.draw(gfx);
        } else {
            gfx.setColor(Color.RED);
            gfx.drawString("Game Over!", 150, 150);
            gfx.drawString("Score: " + token.getScore(), 150, 180);
        }
        g.drawImage(img,0,0,null);
    }
    public void repaint(Graphics g){
        paint(g);
    }
    public void update(Graphics g){
        paint(g);
    }

    public void checkGameOver() {
        if (snake.getX() < 0 || snake.getX() > 397)
            gameOver = true;
        if (snake.getY() < 0 || snake.getY() > 397)
            gameOver = true;
        if (snake.snakeCollision())
            gameOver = true;

    }

    public void run() {
        for(;;){
            if(!gameOver) {
                snake.move();
                this.checkGameOver();
                token.snakeCollision();
            }
            this.repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(!snake.isMoving){
            if(e.getKeyCode()==KeyEvent.VK_UP||
            e.getKeyCode()==KeyEvent.VK_DOWN||
            e.getKeyCode()==KeyEvent.VK_RIGHT){
                snake.setMoving(true);
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_UP){
            if (snake.getyDir() != 1){
                snake.setyDir(-1);
                snake.setxDir(0);
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            if (snake.getyDir() != -1){
                snake.setyDir(1);
                snake.setxDir(0);
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            if (snake.getxDir() != 1){
                snake.setxDir(-1);
                snake.setyDir(0);
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            if (snake.getxDir() != -1){
                snake.setxDir(1);
                snake.setyDir(0);
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}

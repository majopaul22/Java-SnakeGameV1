import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends Applet implements Runnable, KeyListener {

    Graphics gfx;
    Image img;
    Thread thread;
    Snake snake;

    public void init(){
        this.resize(400, 400);
        img = createImage(400, 400);
        gfx = img.getGraphics();
        this.addKeyListener(this);
        snake = new Snake();
        thread = new Thread(this);
        thread.start();
    }
    public void paint(Graphics g){
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, 400, 400);
        snake.draw(gfx);
        g.drawImage(img,0,0,null);
    }
    public void repaint(Graphics g){

    }
    public void update(Graphics g){

    }

    public void run() {
        for(;;){
            snake.move();
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
        System.out.println(snake.isMoving + ", " + snake.getxDir() + ", " + snake.getyDir());
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

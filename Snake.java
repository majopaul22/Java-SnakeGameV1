import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    int xDir, yDir;

    boolean isMoving, elongated;
    final int STARTSIZE = 20, STARTX = 150, STARTY = 150;
    List<Point> snakePoints;

    public Snake(){
        xDir = 0;
        yDir = 0;
        isMoving = false;
        elongated = false;
        snakePoints = new ArrayList<Point>();
        snakePoints.add(new Point(STARTX, STARTY));
        for (int i = 1; i < STARTSIZE; i++) {
            snakePoints.add(new Point(STARTX - i * 4, STARTY));
        }
    }

    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }
    public int getX(){
        return snakePoints.get(0).getX();
    }
    public int getY(){
        return snakePoints.get(0).getY();
    }

    public int getxDir(){
        return xDir;
    }

    public int getyDir() {
        return yDir;
    }

    public boolean snakeCollision() {
        int x = this.getX();
        int y = this.getY();
        for (int i = 1; i < snakePoints.size(); i++) {
            if (snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y)
                return true;
        }
        return false;
    }
    public boolean isMoving() {
        return isMoving;
    }

    public void setElongated(boolean elongated) {
        this.elongated = elongated;
    }
    public void setMoving(boolean moving) {
        isMoving = moving;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        for(Point p : snakePoints){
            g.fillRect(p.getX(), p.getY(), 4, 4);
        }
    }
    public void move(){
        if(isMoving) {
            Point temp = snakePoints.get(0);
            Point last = snakePoints.get(snakePoints.size()-1);
            Point newStart = new Point(temp.getX()+ xDir *4, temp.getY()+ yDir *4);
            for (int i = snakePoints.size()-1; i >= 1; i--) {
                snakePoints.set(i, snakePoints.get(i - 1));
            }
            snakePoints.set(0, newStart);
            if(elongated) {
                snakePoints.add(last);
                elongated = false;
            }
        }
    }
}


public class Point {
    private int x, y;
    Point(){
        x = 0;
        y = 0;
    }
    Point(int x1, int y1){
        x = x1;
        y = y1;
    }
    void setX(int x1){
        x = x1;
    }
    void setY(int y1){
        y = y1;
    }
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
}


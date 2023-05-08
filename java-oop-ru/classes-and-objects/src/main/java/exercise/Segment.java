package exercise;

// BEGIN
public class Segment {
    private Point p1;
    private Point p2;

    Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getBeginPoint() {
        return p1;
    }

    public Point getEndPoint() {
        return p2;
    }

    public Point getMidPoint() {
        int newX = (p1.getX() + p2.getX())/2;
        int newY = (p1.getY() + p2.getY())/2;
        return new Point(newX, newY);
    }
}
// END

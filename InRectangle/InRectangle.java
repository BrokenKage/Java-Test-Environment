package InRectangle;

public class InRectangle {
    
    public static boolean isInRectangle(int x1, int x2, int y1, int y2, int pointx, int pointy) {
        double A = -(y2 - y1);
        double B = x2 - x1;
        double C = -(A * x1 + B * y1);

        double D = (A * pointx) + (B * pointy) + C;
        //double D = (x2 - x1) * (pointy - y1) - (pointx - x1) * (y2 - y1);
        if(D > 0) { return false; }
        if(D < 0) { return true; }
        return true;
    }

    public static boolean rectangleTest(int x1, int x2, int y1, int y2, int pointx, int pointy) {
        //(x1,y1) -> (x2,y1)
        boolean test1 = isInRectangle(x1, x2, y1, y1, pointx, pointy);
        //(x2,y1) -> (x2,y2)
        boolean test2 = isInRectangle(x2, x2, y1, y2, pointx, pointy);
        //(x2,y2) -> (x1,y2)
        boolean test3 = isInRectangle(x2, x1, y2, y2, pointx, pointy);
        //(x1,y2) -> (x1,y1)
        boolean test4 = isInRectangle(x1, x1, y2, y1, pointx, pointy);

        if(test1 && test2 && test3 && test4) { return true; }
        return false;
    }

    public static void main(String[] args) {
        boolean b = rectangleTest(4, 1, 1, 4, 2, 2);
        System.out.println(String.valueOf(b));
    }

}
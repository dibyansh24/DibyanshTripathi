public class PolygonGeometry {
    static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
        Point subtract(Point p) { return new Point(x - p.x, y - p.y); }
        double cross(Point p) { return x * p.y - y * p.x; }
    }

    public static double computeArea(Point[] poly) {
        double area = 0;
        for (int i = 0; i < poly.length; i++) {
            area += poly[i].cross(poly[(i + 1) % poly.length]);
        }
        return Math.abs(area) / 2.0;
    }

    public static void main(String[] args) {
        Point[] poly = {
            new Point(0,0),
            new Point(1,0),
            new Point(1,1),
            new Point(0,1)
        };
        System.out.println("Polygon Area: " + computeArea(poly));
    }
}


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private final LineSegment[] segments;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException();
        }
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) throw new IllegalArgumentException();
            }
        }

        ArrayList<LineSegment> segList = new ArrayList<>();
        Point[] p = Arrays.copyOf(points, points.length);
        ArrayList<Point> pointList = new ArrayList<>();

        for (int i = 0; i < p.length; i++) {
            Arrays.sort(p);
            Arrays.sort(p, p[i].slopeOrder());

            Point origin = p[0];
            for (int j = 0; j < p.length - 1; j++) {
                pointList.add(p[j]);
                while (j < p.length - 1 && origin.slopeTo(p[j]) == origin.slopeTo(p[j + 1])) {
                    pointList.add(p[j+1]);
                    j++;
                }
                if (pointList.size() >= 3 && origin.compareTo(pointList.get(0)) < 0) {
                    segList.add(new LineSegment(origin, pointList.get(pointList.size() - 1)));
                }
                pointList.clear();
            }
        }
        segments = new LineSegment[segList.size()];
        segList.toArray(segments);

    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return Arrays.copyOf(this.segments, this.segments.length);
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}

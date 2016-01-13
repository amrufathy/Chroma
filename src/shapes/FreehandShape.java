/*
 * The MIT License
 *
 * Copyright 2015 Ghannam.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Ghannam
 */
public class FreehandShape extends Shape {

    public ArrayList<Point> points = new ArrayList<>();
    private final String type = "freehand";

    public FreehandShape() {
        super(new Point(0, 0), null);
    }

    public FreehandShape(Point basePoint, Color color) {
        super(basePoint, color);
    }

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < points.size() - 1; i++) {
            g.setColor(color);
            g.drawLine(points.get(i).getX(), points.get(i).getY(), points.get(i + 1).getX(), points.get(i + 1).getY());

        }
    }

    @Override
    public void paint(Graphics g) {
    }

    @Override
    public void selectionView(Graphics2D g2d) {
    }

    @Override
    public void move(Point BasePoint, Point endPoint) {
    }

    @Override
    public boolean isSelected(Selection select) {
        for (Point p : points) {
            if (p.getX() < select.x || p.getX() > select.X || p.getY() > select.Y || p.getY() < select.y) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void resize(Point BasePoint, Point endPoint) {

    }
}

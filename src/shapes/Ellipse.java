/*
 * The MIT License
 *
 * Copyright 2015 amr.
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

/**
 *
 * @author amr
 */
public class Ellipse extends Shape {

    private int radius1;
    private int radius2;
    private Point P1;
    private Point P2;
    private Point P3;
    private Point P4;
    private String type = "ellipse";

    public int getRadius1() {
        return radius1;
    }

    public int getRadius2() {
        return radius2;
    }

    public Ellipse(Point endPoint, Point basePoint, Color color) {
        super(basePoint, color);

        this.radius1 = Math.abs(endPoint.getX() - basePoint.getX());
        this.radius2 = Math.abs(endPoint.getY() - basePoint.getY());

        P1 = new Point(basePoint.getX() + radius1, basePoint.getY());
        P2 = new Point(basePoint.getX(), basePoint.getY() - radius2);
        P3 = new Point(basePoint.getX(), basePoint.getY() + radius2);
        P4 = new Point(basePoint.getX() - radius1, basePoint.getY());
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawOval(this.basePoint.getX() - radius1, this.basePoint.getY() - radius2, (2 * radius1), (2 * radius2));
    }

    @Override
    public boolean isSelected(Selection select) {
        return P1.isSelected(select) && P2.isSelected(select) && P3.isSelected(select) && P4.isSelected(select);
    }

    @Override
    public void selectionView(Graphics2D g2d) {
        P1.selectionView(g2d);
        P2.selectionView(g2d);
        P3.selectionView(g2d);
        P4.selectionView(g2d);
    }

    @Override
    public void move(Point BasePoint, Point endPoint) {
        int deltaX = endPoint.getX() - BasePoint.getX();
        int deltaY = endPoint.getY() - BasePoint.getY();

        basePoint.setX(basePoint.getX() + deltaX);
        basePoint.setY(basePoint.getY() + deltaY);

        P1.setX(P1.getX() + deltaX);
        P1.setY(P1.getY() + deltaY);
        P2.setX(P2.getX() + deltaX);
        P2.setY(P2.getY() + deltaY);
        P3.setX(P3.getX() + deltaX);
        P3.setY(P3.getY() + deltaY);
        P4.setX(P4.getX() + deltaX);
        P4.setY(P4.getY() + deltaY);
    }

    @Override
    public void resize(Point BasePoint, Point endPoint) {
        int deltaX = (endPoint.getX() - BasePoint.getX());
        int deltaY = (endPoint.getY() - BasePoint.getY());
        int x1 = BasePoint.getX();
        int x2 = endPoint.getX();
        int y1 = BasePoint.getY();
        int y2 = endPoint.getY();

        radius1 += deltaX;
        radius2 += deltaY;
    }

    public boolean hasPoint(Point p) {
        return p.equals(P1) || p.equals(P2) || p.equals(P3) || p.equals(P4);
    }
}

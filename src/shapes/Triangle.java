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

public class Triangle extends Shape {

    Point P1;
    Point P2;
    Point P3;
    int Temp;
    int x;
    int y;
    private final String type = "triangle";

    public Triangle(Point basePoint, Color color, Point secondPoint) {
        super(basePoint, color);
        P1 = this.basePoint;
        P2 = secondPoint;
        Temp = Math.abs(P1.getX() - P2.getX());
        x = P1.getX() > P2.getX() ? P1.getX() + Temp : P1.getX() - Temp;
        y = P2.getY();
        P3 = new Point(x, y);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.drawLine(P1.getX(), P1.getY(), P2.getX(), P2.getY());
        g2.drawLine(P1.getX(), P1.getY(), P3.getX(), P3.getY());
        g2.drawLine(P3.getX(), P3.getY(), P2.getX(), P2.getY());
    }

    @Override
    public boolean isSelected(Selection select) {
        return P1.isSelected(select) && P2.isSelected(select) && P3.isSelected(select);
    }

    @Override
    public void selectionView(Graphics2D g2d) {
        P1.selectionView(g2d);
        P2.selectionView(g2d);
        P3.selectionView(g2d);
    }

    @Override
    public void move(Point BasePoint, Point endPoint) {
        int deltaX = (endPoint.getX() - BasePoint.getX());
        int deltaY = (endPoint.getY() - BasePoint.getY());

        P1.setX(P1.getX() + deltaX);
        P1.setY(P1.getY() + deltaY);
        P2.setX(P2.getX() + deltaX);
        P2.setY(P2.getY() + deltaY);
        P3.setX(P3.getX() + deltaX);
        P3.setY(P3.getY() + deltaY);
    }

    @Override
    public void resize(Point BasePoint, Point endPoint) {
        P2 = endPoint;
        Temp = Math.abs(P1.getX() - P2.getX());
        x = P1.getX() > P2.getX() ? P1.getX() + Temp : P1.getX() - Temp;
        y = P2.getY();
        P3 = new Point(x, y);
    }

    public Point getSecondPoint() {
        return P2;
    }

    public Point getThirdPoint() {
        return P3;
    }

    public boolean hasPoint(Point p) {
        return p.equals(P1) || p.equals(P2) || p.equals(P3);
    }

}

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

public class Rectangle extends Shape {

    private int width;
    private int length;
    private int X;
    private int Y;
    private int x;
    private int y;
    private Point P1;
    private Point P2;
    private Point P3;
    private Point P4;
    private final String type = "rectangle";

    public Rectangle(Point basePoint, Color color, Point endPoint) {
        super(basePoint, color);

        this.X = basePoint.getX() > endPoint.getX() ? basePoint.getX() : endPoint.getX();
        this.Y = basePoint.getY() > endPoint.getY() ? basePoint.getY() : endPoint.getY();
        this.x = basePoint.getX() < endPoint.getX() ? basePoint.getX() : endPoint.getX();
        this.y = basePoint.getY() < endPoint.getY() ? basePoint.getY() : endPoint.getY();

        this.width = X - x;
        this.length = Y - y;

        P1 = new Point(x, y);
        P2 = new Point(x + width, y);
        P3 = new Point(x + width, y + length);
        P4 = new Point(x, y + length);
    }

    @Override
    public void resize(Point BasePoint, Point endPoint) {
        int deltaX = (endPoint.getX() - BasePoint.getX());
        int deltaY = (endPoint.getY() - BasePoint.getY());
        int x1 = BasePoint.getX();
        int x2 = endPoint.getX();

        width += deltaX;
        length += deltaY;
    }

    @Override
    public boolean isSelected(Selection select) {
        return P1.isSelected(select) && P2.isSelected(select) && P3.isSelected(select) && P4.isSelected(select);
    }

    @Override
    public void draw(Graphics g) {
        //where end point is the second click of the mouse
        Graphics2D g2 = (Graphics2D) g;
        g2.drawRect(this.x, this.y, this.width, this.length);
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
        int deltaX = (endPoint.getX() - BasePoint.getX());
        int deltaY = (endPoint.getY() - BasePoint.getY());

        x = x + deltaX;
        y = y + deltaY;
        P1.setX(x);
        P1.setY(y);
        P2.setX(x + width);
        P2.setY(y);
        P3.setX(x + width);
        P3.setY(y + length);
        P4.setX(x);
        P4.setY(y + length);
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public boolean hasPoint(Point p) {
        return p.equals(P1) || p.equals(P2) || p.equals(P3) || p.equals(P4);
    }

}

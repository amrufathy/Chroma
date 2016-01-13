/*
 * The MIT License
 *
 * Copyright 2015 ahmedmasoud.
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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author ahmedmasoud
 */
public class Selection extends Shape {

    private int width;
    private int height;
    protected int X;
    protected int Y;
    protected int x;
    protected int y;
    private Point P1;
    private Point P2;
    private Point P3;
    private Point P4;
    final static float segment1[] = {
        10.0f
    };
    final static BasicStroke segment = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, segment1, 0.0f);

    public Selection(Point basePoint, Color color, Point endPoint) {
        super(basePoint, color);

        this.X = basePoint.getX() > endPoint.getX() ? basePoint.getX() : endPoint.getX();
        this.Y = basePoint.getY() > endPoint.getY() ? basePoint.getY() : endPoint.getY();
        this.x = basePoint.getX() < endPoint.getX() ? basePoint.getX() : endPoint.getX();
        this.y = basePoint.getY() < endPoint.getY() ? basePoint.getY() : endPoint.getY();
        P1 = new Point(x, y);
        P2 = new Point(X, y);
        P3 = new Point(x, Y);
        P4 = new Point(x, Y);

    }

    @Override
    public boolean isSelected(Selection select) {
        return true;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(segment);
        this.width = X - x;
        this.height = Y - y;
        g2.drawRect(P1.getX(), P1.getY(), width, height);
    }

    @Override
    public void selectionView(Graphics2D g2d) {
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
        P4.setX(P4.getX() + deltaX);
        P4.setY(P4.getY() + deltaY);
    }

    public boolean has(Point pt) {
        return pt.getX() > x && pt.getX() < X && pt.getY() > y && pt.getY() < Y;
    }

    @Override
    public void resize(Point BasePoint, Point endPoint) {
    }

}

/*
 * The MIT License
 *
 * Copyright 2015 ahmed.
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
 * @author ahmed
 */
public class Triangle extends Shape {

    Point P1;
    Point P2;
    Point P3;
    int Temp;
    int x;
    int y;

    public Point getSecondPoint() {
        return P2;
    }

    public Point getThirdPoint() {
        return P3;
    }

    public void setSecondPoint(Point P2) {
        this.P2 = P2;
    }

    public void setThirdPoint(Point P3) {
        this.P3 = P3;
    }
    
    public Triangle(Point basePoint, Color color, Point secondPoint) {
        super(basePoint, color);
        this.P2 = secondPoint;
        P1 = this.basePoint;
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
    public void resize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void move(Point newBasePoint, Point endPoint) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

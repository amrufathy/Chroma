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
public class Square extends Shape {

    Point endPoint;
    protected int X;
    protected int Y;
    protected int x;
    protected int y;
    protected Point P1;
    protected Point P2;
    protected Point P3;
    protected Point P4;
    int length;
    
    public int getWidth() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Square(Point basePoint, Color color, Point endPoint) {
        super(basePoint, color);
        this.X = basePoint.getX() > endPoint.getX() ? basePoint.getX() : endPoint.getX();
        this.Y = basePoint.getY() > endPoint.getY() ? basePoint.getY() : endPoint.getY();
        this.x = basePoint.getX() < endPoint.getX() ? basePoint.getX() : endPoint.getX();
        this.y = basePoint.getY() < endPoint.getY() ? basePoint.getY() : endPoint.getY();
        length = X - x > Y - y ? X - x : Y - y;
        P1 = new Point(x, y);
        P2 = new Point(x + length, y);
        P3 = new Point(x + length, y + length);
        P4 = new Point(x, y + length);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.drawRect(x, y, length, length);

    }

    @Override
    public boolean isSelected(Selection select) {
        if (P1.isSelected(select) && P2.isSelected(select) && P3.isSelected(select) && P4.isSelected(select)) {
            return true;
        }
        return false;
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

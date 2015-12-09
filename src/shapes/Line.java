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
public class Line extends Shape {
    
    private Point secondPoint;

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Line(Point secondPoint, Point basePoint, Color color) {
        super(basePoint, color);
        this.secondPoint = secondPoint;
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);
        g2.drawLine(basePoint.getX(), basePoint.getY(), secondPoint.getX(), secondPoint.getY());

    }

    @Override
    public boolean isSelected(Selection select) {
        return basePoint.isSelected(select) && secondPoint.isSelected(select);
    }

    @Override
    public void resize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void move(Point newBasePoint, Point endPoint) {
        int deltaX = endPoint.getX() - newBasePoint.getX();
        int deltaY = endPoint.getY() - newBasePoint.getY();
        basePoint.setX(basePoint.getX() + deltaX);
        basePoint.setY(basePoint.getY() + deltaY);
        endPoint.setX(endPoint.getX() + deltaX);
        endPoint.setY(endPoint.getY() + deltaY);
    }

    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

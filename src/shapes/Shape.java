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

/**
 *
 * @author amr
 */
public abstract class Shape {
    protected Point basePoint;
    protected Color color;

    public Shape() {
    }

    public Shape(Point basePoint) {
        this.basePoint = basePoint;
    }
    
    public Shape(Color color) {
        this.color = color;
    }

    public Shape(Point basePoint, Color color) {
        this.basePoint = basePoint;
        this.color = color;
    }

    public Point getBasePoint() {
        return basePoint;
    }

    public void setBasePoint(Point basePoint) {
        this.basePoint = basePoint;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public abstract void draw(Graphics g);
    
    public abstract boolean isSelected();
    
    public abstract void resize();
    
    public abstract void move(Point newBasePoint);
    
    public abstract void paint(Graphics g);
    
}

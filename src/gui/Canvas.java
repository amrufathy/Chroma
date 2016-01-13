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
package gui;

import shapes.FreehandShape;
import com.alee.laf.panel.WebPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import shapes.Shape;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import shapes.Circle;
import shapes.Ellipse;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import shapes.Selection;
import shapes.Square;
import shapes.Triangle;

/**
 *
 * @author amr
 */
public class Canvas extends WebPanel {

    public Color masterColor;
    Graphics2D g2d;
    public int shakl = -1;
    //el color dah hayetgab men el main window
    Color c = Color.BLACK;
    //el stroke dah hayetgab men el dialogue
    BasicStroke stroke = new BasicStroke(2);
    public boolean reColor = false;
    boolean doneSelecting = false;
    ArrayList<Shape> shapes = new ArrayList<>();
    ArrayList<Shape> selectedshapes = new ArrayList<>();
    ArrayList<FreehandShape> freehands = new ArrayList<>();

    FreehandShape fhnow = new FreehandShape(null, c);
    FreehandShape eraser = new FreehandShape(null, Color.WHITE);

    Point basePoint;
    Point endPoint;
    Point Temp;
    Shape TempShape;
    Selection Select;
    BasicStroke dash;
    boolean undoo = false;
    boolean redoo = false;
    final static float segment1[] = {
        10.0f
    };
    final static BasicStroke segment = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, segment1, 0.0f);

    Shape toDraw;
    MouseListener m1;
    MouseMotionListener m2;

    public Canvas(final MainWindow mainWindow) {
        super();

        setBackground(Color.WHITE);

        m1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                basePoint = new Point(e.getX(), e.getY());
                Temp = basePoint;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endPoint = new Point(e.getX(), e.getY());

                switch (shakl) {
                    case 1:
                        toDraw = new Line(basePoint, c, endPoint);
                        break;
                    case 2:
                        toDraw = new Triangle(basePoint, c, endPoint);
                        break;
                    case 3:
                        toDraw = new Rectangle(basePoint, c, endPoint);
                        break;
                    case 4:
                        toDraw = new Square(basePoint, c, endPoint);
                        break;
                    case 5:
                        toDraw = fhnow;
                        freehands.add(fhnow);
                        fhnow = new FreehandShape(null, c);
                        break;
                    case 6:
                        selectedshapes.removeAll(shapes);
                        break;
                    case 7:
                        toDraw = eraser;
                        freehands.add(fhnow);
                        eraser = new FreehandShape(null, Color.white);
                        break;
                    case 8:
                        toDraw = new Ellipse(endPoint, basePoint, c);
                        break;
                    case 9:
                        toDraw = new Circle(endPoint, basePoint, c);
                        break;
                    default:
                        break;
                }

                if (toDraw != null) {
                    shapes.add(toDraw);
                }

                repaint();
                updateGraphics();
                update(g2d);
                mainWindow.update();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        this.addMouseListener(m1);
        m2 = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endPoint = new Point(e.getX(), e.getY());
                switch (shakl) {
                    case 1:
                        TempShape = new Line(basePoint, c, endPoint);
                        break;
                    case 2:
                        TempShape = new Triangle(basePoint, c, endPoint);
                        break;
                    case 3:
                        TempShape = new Rectangle(basePoint, c, endPoint);
                        break;
                    case 4:
                        TempShape = new Square(basePoint, c, endPoint);
                        break;
                    case 5:
                        fhnow.addPoint(endPoint.getX(), endPoint.getY());
                        basePoint.setX(endPoint.getX());
                        basePoint.setY(endPoint.getY());
                        TempShape = fhnow;
                        break;
                    case 6:
                        for (Shape x : shapes) {
                            if (x.isSelected(Select)) {
                                selectedshapes.add(x);
                            }
                        }

                        if (!selectedshapes.isEmpty()) {
                            for (Shape x : selectedshapes) {
                                x.move(Temp, endPoint);
                                TempShape = x;
                            }
                        }
                        break;
                    case 7:
                        eraser.addPoint(endPoint.getX(), endPoint.getY());
                        basePoint.setX(endPoint.getX());
                        basePoint.setY(endPoint.getY());
                        TempShape = eraser;
                        break;
                    case 8:
                        TempShape = new Ellipse(endPoint, basePoint, c);
                        break;
                    case 9:
                        TempShape = new Circle(endPoint, basePoint, c);
                        break;
                    case 10:
                        for (Shape x : shapes) {
                            if (x.isSelected(Select)) {
                                selectedshapes.add(x);
                            }
                        }
                        doneSelecting = true;

                        if (!selectedshapes.isEmpty()) {
                            for (Shape x : selectedshapes) {
                                x.resize(Temp, endPoint);
                                TempShape = x;
                                Select.move(basePoint, endPoint);
                            }
                        }
                    default:
                        Select = new Selection(basePoint, c, endPoint);
                        Select.setColor(Color.BLACK);
                        break;
                }
                Temp = endPoint;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        };

        this.addMouseMotionListener(m2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D) g;

        if (undoo) {
            clear(g2d);
            undoo = false;
        }

        if (redoo) {
            shapes.get(shapes.size() - 1).draw(g);
            redoo = false;
        }

        g2d.setStroke(stroke);

        for (Shape x : shapes) {
            g2d.setColor(x.getColor());
            x.draw(g);
            if (shakl == 0) {
                if (x.isSelected(Select)) {
                    x.selectionView(g2d);
                }
            }
        }

        if (TempShape != null) {
            TempShape.draw(g);

        }

        if (Select != null) {
            Select.draw(g);

        }

    }

    public void clear(Graphics2D g) {
        g.setPaint(Color.white);
        g.fillRect(0, 0, getSize().width, getSize().height);
        g.setPaint(c);
        repaint();
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public Graphics2D getGraphics2D() {
        return g2d;
    }

    public Shape getTempShape() {
        return TempShape;
    }

    public void setTempShape(Shape TempShape) {
        this.TempShape = TempShape;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public void updateGraphics() {
        g2d.clearRect(0, 0, getSize().width, getSize().height);

        g2d.setStroke(stroke);

        if (g2d != null) {
            for (Shape x : shapes) {
                g2d.setColor(x.getColor());
                x.draw(g2d);
                if (shakl == 0) {
                    if (x.isSelected(Select)) {
                        x.selectionView(g2d);
                    }
                }
            }
        }

        if (shapes.isEmpty()) {
            Select = null;
        }

        TempShape = null;
        repaint();
    }

}

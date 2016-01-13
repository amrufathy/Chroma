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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

/**
 *
 * @author amr
 */
public class ToolBar extends JToolBar {

    public JButton newFile = new JButton(
            new ImageIcon("res/images/new.png"));
    public JButton open = new JButton(
            new ImageIcon("res/images/open.png"));
    public JButton save = new JButton(
            new ImageIcon("res/images/save.png"));
    public JButton saveAs = new JButton(
            new ImageIcon("res/images/saveAs.png"));

    public JButton copy = new JButton(
            new ImageIcon("res/images/copy.png"));
    public JButton cut = new JButton(
            new ImageIcon("res/images/cut.png"));
    public JButton paste = new JButton(
            new ImageIcon("res/images/paste.png"));

    public JButton redo = new JButton(
            new ImageIcon("res/images/redo.png"));
    public JButton undo = new JButton(
            new ImageIcon("res/images/undo.png"));

    public JButton pencil = new JButton(
            new ImageIcon("res/images/freehand.png"));

    public JButton eraser = new JButton(
            new ImageIcon("res/images/eraser.png"));
    public JButton bucket = new JButton(
            new ImageIcon("res/images/fill-color.png"));

    public JButton line = new JButton(
            new ImageIcon("res/images/draw-line.png"));
    public JButton square = new JButton(
            new ImageIcon("res/images/draw-square.png"));
    public JButton rectangle = new JButton(
            new ImageIcon("res/images/draw-rectangle.png"));
    public JButton triangle = new JButton(
            new ImageIcon("res/images/draw-triangle.png"));
    public JButton circle = new JButton(
            new ImageIcon("res/images/draw-circle.png"));
    public JButton ellipse = new JButton(
            new ImageIcon("res/images/draw-ellipse.png"));

    public JButton select = new JButton(
            new ImageIcon("res/images/select.png"));
    public JButton move = new JButton(
            new ImageIcon("res/images/move.png"));
    public JButton resize = new JButton(
            new ImageIcon("res/images/resize.png"));
    public JButton delete = new JButton(
            new ImageIcon("res/images/delete.png"));

    public ToolBar() {
        super();

        setFloatable(false);

        newFile.setToolTipText("New");
        open.setToolTipText("Open");
        save.setToolTipText("Save");
        //saveAs.setToolTipText("Save As");

        //copy.setToolTipText("Copy");
        //cut.setToolTipText("Cut");
        //paste.setToolTipText("Paste");
        redo.setToolTipText("Redo");
        undo.setToolTipText("Undo");

        pencil.setToolTipText("Pencil");
        eraser.setToolTipText("Eraser");
        bucket.setToolTipText("Color");

        line.setToolTipText("Draw Line");
        square.setToolTipText("Draw Square");
        rectangle.setToolTipText("Draw Rectangle");
        triangle.setToolTipText("Draw Triangle");
        circle.setToolTipText("Draw Circle");
        ellipse.setToolTipText("Draw Ellipse");

        select.setToolTipText("Select Shape(s)");
        move.setToolTipText("Move Shape(s)");
        resize.setToolTipText("Resize Shape(s)");
        delete.setToolTipText("Delete Shape(s)");

        add(newFile);
        add(open);
        add(save);
        //this.add(saveAs);
        add(new JSeparator(SwingConstants.VERTICAL));
        add(undo);
        add(redo);
        add(new JSeparator(SwingConstants.VERTICAL));
        //this.add(cut);
        //this.add(copy);
        //this.add(paste);
        //add(new JSeparator(SwingConstants.VERTICAL));
        add(pencil);
        add(eraser);
        add(bucket);
        add(new JSeparator(SwingConstants.VERTICAL));
        add(line);
        add(square);
        add(rectangle);
        add(triangle);
        add(circle);
        add(ellipse);
        add(new JSeparator(SwingConstants.VERTICAL));
        add(select);
        add(move);
        add(resize);
        add(delete);

    }
}

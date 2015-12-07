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
            new ImageIcon("res/new.png"));
    public JButton open = new JButton(
            new ImageIcon("res/open.png"));
    public JButton save = new JButton(
            new ImageIcon("res/save.png"));
    public JButton saveAs = new JButton(
            new ImageIcon("res/saveAs.png"));
    
    public JButton copy = new JButton(
            new ImageIcon("res/copy.png"));
    public JButton cut = new JButton(
            new ImageIcon("res/cut.png"));
    public JButton paste = new JButton(
            new ImageIcon("res/paste.png"));
    
    public JButton redo = new JButton(
            new ImageIcon("res/redo.png"));
    public JButton undo = new JButton(
            new ImageIcon("res/undo.png"));
    
    public JButton pencil = new JButton(
            new ImageIcon("res/freehand.png"));
    public JButton eraser = new JButton(
            new ImageIcon("res/eraser.png"));
    public JButton bucket = new JButton(
            new ImageIcon("res/fill-color.png"));
    
    public JButton line = new JButton(
            new ImageIcon("res/draw-line.png"));
    public JButton square = new JButton(
            new ImageIcon("res/draw-square.png"));
    public JButton rectangle = new JButton(
            new ImageIcon("res/draw-rectangle.png"));
    public JButton triangle = new JButton(
            new ImageIcon("res/draw-triangle.png"));
    public JButton polygon = new JButton(
            new ImageIcon("res/draw-polygon.png"));
    
    
    
    public ToolBar() {
        super();
        
        setFloatable(false);

        newFile.setToolTipText("New");
        open.setToolTipText("Open");
        save.setToolTipText("Save");
        saveAs.setToolTipText("Save As");
        
        copy.setToolTipText("Copy");
        cut.setToolTipText("Cut");
        paste.setToolTipText("Paste");
        
        redo.setToolTipText("Redo");
        undo.setToolTipText("Undo");
        
        pencil.setToolTipText("Pencil");
        eraser.setToolTipText("Eraser");
        bucket.setToolTipText("Color");
        
        line.setToolTipText("Draw Line");
        square.setToolTipText("Draw Square");
        rectangle.setToolTipText("Draw Rectangle");
        triangle.setToolTipText("Draw Triangle");
        polygon.setToolTipText("Draw Polygon");
        
        this.add(newFile);
        this.add(open);
        this.add(save);
        this.add(saveAs);
        add(new JSeparator(SwingConstants.VERTICAL));
        this.add(undo);
        this.add(redo);
        add(new JSeparator(SwingConstants.VERTICAL));
        this.add(cut);
        this.add(copy);
        this.add(paste);
        add(new JSeparator(SwingConstants.VERTICAL));
        this.add(pencil);
        this.add(eraser);
        this.add(bucket);
        add(new JSeparator(SwingConstants.VERTICAL));
        this.add(line);
        this.add(square);
        this.add(rectangle);
        this.add(triangle);
        this.add(polygon);
        
    }
}

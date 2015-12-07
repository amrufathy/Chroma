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
package chroma;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author amr
 */
public class MenuBar extends JMenuBar {
    private JMenu fileMenu = new JMenu("File");
    private JMenu editMenu = new JMenu("Edit");
    private JMenu helpMenu = new JMenu("Help");
    
    public JMenuItem newFile = new JMenuItem("New",
            new ImageIcon("res/new.png"));
    public JMenuItem open = new JMenuItem("Open",
            new ImageIcon("res/open.png"));
    public JMenuItem save = new JMenuItem("Save",
            new ImageIcon("res/save.png"));
    public JMenuItem saveAs = new JMenuItem("Save As",
            new ImageIcon("res/saveAs.png"));
    public JMenuItem exit = new JMenuItem("Exit",
            new ImageIcon("res/exit.png"));
    
    public JMenuItem undo = new JMenuItem("Undo",
            new ImageIcon("res/undo.png"));
    public JMenuItem redo = new JMenuItem("Redo",
            new ImageIcon("res/redo.png"));
    public JMenuItem copy = new JMenuItem("Copy",
            new ImageIcon("res/copy.png"));
    public JMenuItem cut = new JMenuItem("Cut",
            new ImageIcon("res/cut.png"));
    public JMenuItem paste = new JMenuItem("Paste",
            new ImageIcon("res/paste.png"));
    
    public JMenuItem about = new JMenuItem("About",
            new ImageIcon("res/about.png"));
    
    private JMenu exportMenu = new JMenu("Export As");
    public JMenuItem exportAsPng = new JMenuItem("PNG Image",
            new ImageIcon("res/export.png"));
    public JMenuItem exportAsJpg = new JMenuItem("JPG Image",
            new ImageIcon("res/export.png"));

    
    
    public MenuBar(){
        fileMenu.add(newFile);
        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(save);
        fileMenu.add(saveAs);
        fileMenu.addSeparator();
        fileMenu.add(exportMenu);
        exportMenu.add(exportAsJpg);
        exportMenu.add(exportAsPng);
        fileMenu.addSeparator();
        fileMenu.add(exit);
        
        add(fileMenu);
        
        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.addSeparator();
        editMenu.add(undo);
        editMenu.add(redo);
        
        add(editMenu);
        
        helpMenu.add(about);
        
        add(helpMenu);
    }
}

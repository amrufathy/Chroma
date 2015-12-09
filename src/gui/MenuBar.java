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

import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
        newFile.setMnemonic('N');
        newFile.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_N,
                        Event.CTRL_MASK));
        fileMenu.add(open);
        open.setMnemonic('O');
        open.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_O,
                        Event.CTRL_MASK));
        fileMenu.addSeparator();
        fileMenu.add(save);
        save.setMnemonic('S');
        save.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_S,
                        Event.CTRL_MASK));
        fileMenu.add(saveAs);
        saveAs.setAccelerator(
                KeyStroke.getKeyStroke("control alt S"));
        fileMenu.addSeparator();
        fileMenu.add(exportMenu);
        exportMenu.add(exportAsJpg);
        exportMenu.add(exportAsPng);
        fileMenu.addSeparator();
        fileMenu.add(exit);
        exit.setMnemonic('E');
        exit.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_F4,
                        Event.ALT_MASK));

        
        add(fileMenu);
        
        editMenu.add(cut);
        cut.setMnemonic('X');
        cut.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_X,
                        Event.CTRL_MASK));
        editMenu.add(copy);
        copy.setMnemonic('C');
        copy.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_C,
                        Event.CTRL_MASK));
        editMenu.add(paste);
        paste.setMnemonic('V');
        paste.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_V,
                        Event.CTRL_MASK));
        editMenu.addSeparator();
        editMenu.add(undo);
        undo.setMnemonic('U');
        undo.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_Z,
                        Event.CTRL_MASK));
        editMenu.add(redo);
        redo.setMnemonic('R');
        redo.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_Y,
                        Event.CTRL_MASK));        
        
        add(editMenu);
        
        helpMenu.add(about);
        about.setMnemonic('A');
        about.setAccelerator(
                KeyStroke.getKeyStroke("F1"));
        
        add(helpMenu);
    }
}

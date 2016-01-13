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

import com.alee.laf.colorchooser.WebColorChooser;
import com.alee.laf.filechooser.WebFileChooser;
import com.alee.laf.panel.WebPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import com.alee.laf.rootpane.WebFrame;
import files.Load;
import files.Save;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import shapes.Shape;

/**
 *
 * @author amr
 */
public class MainWindow extends WebFrame {

    public MainWindow() {

        setTitle("Chroma - Bibo, Inc.");

        setIconImage(new ImageIcon("res/icon.png").getImage());

        setSize(
                (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400,
                (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 400);

        setMinimumSize(new Dimension(500, 500));
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        initMenuBar();
        initToolBar();
        initCanvas();
        update();

    }

    private void initMenuBar() {
        menuBar = new MenuBar();

        menuBar.open.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                update();
            }
        });

        menuBar.about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                About about = new About();
                about.show();
            }
        });

        menuBar.undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (canvas.getShapes().size() > 0) {
                    undoStack.push(canvas.getShapes().remove(canvas.getShapes().size() - 1));
                    canvas.repaint();
                }
                canvas.undoo = true;

                canvas.updateGraphics();
                canvas.update(canvas.getGraphics2D());
                update();
            }
        });

        menuBar.redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!undoStack.isEmpty()) {
                    canvas.getShapes().add((Shape) undoStack.pop());
                    canvas.repaint();
                }

                canvas.redoo = true;

                canvas.updateGraphics();
                canvas.update(canvas.getGraphics2D());
                update();
            }
        });

        menuBar.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                save.makeFile(canvas);
                save.save(MainWindow.this);
            }
        });

        menuBar.open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                load.loadFile(MainWindow.this);
                canvas = load.loadCanvas(MainWindow.this, canvas);
            }
        });

        menuBar.exportAsPng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                WebFileChooser fileChooser = new WebFileChooser();

                fileChooser.setDialogTitle("Export As PNG");
                fileChooser.setFileFilter(
                        new FileNameExtensionFilter(
                                "PNG Image", "png"));

                int returnVal = fileChooser.showSaveDialog(MainWindow.this);

                if (returnVal == WebFileChooser.APPROVE_OPTION) {

                    BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = image.createGraphics();
                    canvas.printAll(g);
                    g.dispose();
                    try {
                        ImageIO.write(image, "png", new File(
                                fileChooser.getSelectedFile().
                                getAbsolutePath() + ".png"));
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
        });

        menuBar.exportAsJpg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                WebFileChooser fileChooser = new WebFileChooser();

                fileChooser.setDialogTitle("Export As JPG");
                fileChooser.setFileFilter(
                        new FileNameExtensionFilter(
                                "JPG Image", "jpg"));

                int returnVal = fileChooser.showSaveDialog(MainWindow.this);

                if (returnVal == WebFileChooser.APPROVE_OPTION) {

                    BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = image.createGraphics();
                    canvas.printAll(g);
                    g.dispose();
                    try {
                        ImageIO.write(image, "jpg", new File(
                                fileChooser.getSelectedFile().
                                getAbsolutePath() + ".jpg"));
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
        });

        menuBar.newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shapes = new ArrayList<>();
                canvas.updateGraphics();
                canvas.update(canvas.getGraphics2D());
                update();
            }
        });

        setJMenuBar(menuBar);
    }

    private void initToolBar() {
        toolBar = new ToolBar();

        add(toolBar, BorderLayout.NORTH);

        toolBar.newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.newFile.doClick();
            }
        });

        toolBar.bucket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (canvas.shakl == 0) {
                    for (Shape x : canvas.shapes) {
                        if (x.isSelected(canvas.Select)) {
                            canvas.selectedshapes.add(x);
                        }
                    }
                }

                canvas.masterColor = WebColorChooser.showDialog(null, "Please Choose Color", Color.BLUE);
                canvas.c = canvas.masterColor;
                if (!canvas.selectedshapes.isEmpty()) {
                    for (Shape x : canvas.selectedshapes) {
                        x.setColor(canvas.masterColor);
                        canvas.TempShape = x;
                    }
                }
                canvas.selectedshapes.removeAll(canvas.shapes);
                update();
            }
        });

        toolBar.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.save.doClick();
            }
        });

        toolBar.open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.open.doClick();
                canvas.updateGraphics();
                canvas.update(canvas.g2d);
                update();
            }

        });

        toolBar.move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 6;
            }
        });

        toolBar.select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 0;
                update();
            }
        });

        toolBar.pencil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 5;
                update();
            }
        });

        toolBar.undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.undo.doClick();
                update();
            }
        });

        toolBar.redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.redo.doClick();
                update();
            }
        });

        toolBar.line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 1;
                update();
            }
        });

        toolBar.triangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 2;
                update();

            }
        });

        toolBar.rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 3;
                update();
            }
        });

        toolBar.square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 4;
                update();
            }
        });

        toolBar.eraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 7;
                update();
            }
        });

        toolBar.circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 9;
                update();
            }
        });

        toolBar.ellipse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 8;
                update();
            }
        });

        toolBar.resize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.shakl = 10;
                update();
            }
        });

        toolBar.delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (Shape x : canvas.getShapes()) {
                    if (x.isSelected(canvas.Select)) {
                        canvas.selectedshapes.add(x);
                    }
                }
                if (canvas.selectedshapes.size() > 0) {
                    for (Shape x : canvas.selectedshapes) {
                        canvas.getShapes().remove(x);
                    }
                }
                canvas.updateGraphics();
                canvas.update(canvas.getGraphics2D());
                update();
                canvas.selectedshapes.removeAll(canvas.getShapes());
            }
        });

    }

    private void initCanvas() {
        WebPanel center = new WebPanel();
        center.setLayout(new GridBagLayout());

        canvas = new Canvas(this);

        add(canvas, BorderLayout.CENTER);
        update();
    }

    public void update() {
        if (canvas.shapes.isEmpty()) {
            menuBar.undo.setEnabled(false);
            toolBar.undo.setEnabled(false);
        } else if (firstDrawing) {
            menuBar.undo.setEnabled(true);
            toolBar.undo.setEnabled(true);
            firstDrawing = false;
        } else {
            menuBar.undo.setEnabled(true);
            toolBar.undo.setEnabled(true);
        }

        if (undoStack.isEmpty()) {
            menuBar.redo.setEnabled(false);
            toolBar.redo.setEnabled(false);
        } else {
            menuBar.redo.setEnabled(true);
            toolBar.redo.setEnabled(true);
        }

    }

    private MenuBar menuBar;
    private ToolBar toolBar;
    private Canvas canvas;
    private final Save save = new Save();
    private final Load load = new Load();
    private Stack undoStack = new Stack();
    private boolean firstDrawing = true;

}

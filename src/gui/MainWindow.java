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

//import chroma.Chroma;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import com.alee.laf.rootpane.WebFrame;

/**
 *
 * @author amr
 */
public class MainWindow extends WebFrame {
    
    public MainWindow() {
        
        setTitle("Chroma");
        
        setSize(
                (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400,
                (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 400);

        setMinimumSize(new Dimension(500, 500));
        setLocationRelativeTo(null);
        
        setLayout(new BorderLayout());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        initMenuBar();
        initToolBar();
        setLocationRelativeTo(null);
    }

    private void initMenuBar() {
        menuBar = new MenuBar();
        
        menuBar.about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                About about = new About();
                about.show();
            }
        });
        
        setJMenuBar(menuBar);
    }
    
    private void initToolBar(){
        toolBar = new ToolBar();
        
        add(toolBar, BorderLayout.NORTH);
        
        toolBar.newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.newFile.doClick();
            }
        });
        
        toolBar.open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.open.doClick();
            }
        });
        
        toolBar.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.save.doClick();
            }
        });
        
        toolBar.saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.saveAs.doClick();
            }
        });
        
        toolBar.copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.copy.doClick();
            }
        });
        
        toolBar.cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.cut.doClick();
            }
        });
        
        toolBar.paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.paste.doClick();
            }
        });
        
        toolBar.undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.undo.doClick();
            }
        });
        
        toolBar.redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuBar.redo.doClick();
            }
        });

    }

                     

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form *
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }*/
                  
    private MenuBar menuBar;
    private ToolBar toolBar = null;
    
}

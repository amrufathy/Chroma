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

import com.alee.laf.label.WebLabel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebTextArea;
import javax.swing.ImageIcon;

/**
 *
 * @author amr
 */
public class About extends WebFrame {

    public About() {
        super();

        setSize(250, 250);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("res/icon.png").getImage());
        setTitle("About Chroma");

        WebLabel logo = new WebLabel(new ImageIcon("res/icon.png"));

        WebTextArea team = new WebTextArea(
                "Chroma\nMade By:\n"
                + "Amr Fathy\n"
                + "Ahmed Ehab\n"
                + "Mohamed Ghannam\n"
                + "Alaa Asfour");

        team.setEditable(false);

        add(logo);
        add(team);

        setAlwaysOnTop(true);
    }

}

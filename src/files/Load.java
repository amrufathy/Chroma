/*
 * The MIT License
 *
 * Copyright 2015 Ghannam.
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
package files;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import com.alee.laf.filechooser.WebFileChooser;
import gui.Canvas;
import gui.MainWindow;
import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import shapes.Circle;
import shapes.Ellipse;
import shapes.FreehandShape;
import shapes.Line;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;
import shapes.Triangle;

/**
 *
 * @author Ghannam
 */
public class Load {

    private String jsonString;
    private boolean noFile = false;

    public void loadFile(MainWindow mainWindow) {

        WebFileChooser fileChooser = new WebFileChooser(System.getProperty("user.dir") + "/saves/");

        fileChooser.setDialogTitle("Open Project");

        int returnVal = fileChooser.showOpenDialog(mainWindow);

        if (returnVal == WebFileChooser.APPROVE_OPTION) {
            try {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                Scanner s = new Scanner(file);

                jsonString = "";

                while (s.hasNext()) {
                    jsonString += s.nextLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            noFile = true;
        }

    }

    public Canvas loadCanvas(MainWindow mainWindow, Canvas canvas) {

        try {

            if (noFile) {
                noFile = false;
                return canvas;
            }

            Gson gson = new Gson();

            JSONParser parser = new JSONParser();

            Object jsonObject = parser.parse(jsonString);
            JSONArray shapes = (JSONArray) jsonObject;

            ArrayList<Shape> jsonShapes = new ArrayList<>();

            for (Object shape : shapes) {
                JSONObject currentShape = (JSONObject) shape;
                String jsonObjString = currentShape.toJSONString();
                if (jsonObjString.contains("rectangle")) {
                    jsonShapes.add(gson.fromJson(jsonObjString, Rectangle.class));
                } else if (jsonObjString.contains("circle")) {
                    jsonShapes.add(gson.fromJson(jsonObjString, Circle.class));
                } else if (jsonObjString.contains("ellipse")) {
                    jsonShapes.add(gson.fromJson(jsonObjString, Ellipse.class));
                } else if (jsonObjString.contains("freehand")) {
                    jsonShapes.add(gson.fromJson(jsonObjString, FreehandShape.class));
                } else if (jsonObjString.contains("triangle")) {
                    jsonShapes.add(gson.fromJson(jsonObjString, Triangle.class));
                } else if (jsonObjString.contains("line")) {
                    jsonShapes.add(gson.fromJson(jsonObjString, Line.class));
                } else if (jsonObjString.contains("square")) {
                    jsonShapes.add(gson.fromJson(jsonObjString, Square.class));
                }
            }
            //sheel kol 7aga men 3al graphics
            canvas.getGraphics2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            //fady el shapes list
            canvas.getShapes().removeAll(new ArrayList());
            //sheel a5er 7aga etrasamet
            canvas.setTempShape(null);
            canvas.setShapes(jsonShapes);
            canvas.updateGraphics();
            canvas.update(canvas.getGraphics2D());
            canvas.repaint();
            mainWindow.update();

        } catch (ParseException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }

        return canvas;
    }

}

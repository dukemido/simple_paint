/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Graphics;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import paint.model.Shape;

/**
 *
 * @author Muhammad
 */
public class Engine implements DrawingEngine {

    private final ILoadSave jsonSaver;
    private final ILoadSave xmlSaver;

    public Stack<ArrayList<Shape>> undoStack, redoStack;
    public ArrayList<Shape> myShapes;
    public CustomPanel panel;
    public ArrayList<Shape> pluginShapes;

    public Engine(CustomPanel panel) {
        this.jsonSaver = new FileJSONShape();
        this.xmlSaver = new FileXMLShape();
        this.panel = panel;
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
        this.myShapes = new ArrayList<>();
        this.pluginShapes = new ArrayList<>();
    }

    @Override
    public void refresh(Graphics g) {
        // draw the shapes
        myShapes.forEach((p) -> {
            p.draw(g);
        });

        //draws the current Shape Object if it is not null
        if (panel.currentShapeObject != null) {
            panel.currentShapeObject.draw(g);
        }
    }

    public void loadPlugin(URL[] path) {
        try {
            /* URLClassLoader child = new URLClassLoader(path, this.getClass().getClassLoader());
            Class classToLoad = Class.forName("paint.plugin.RoundRectangle", true, child);
            Method method = classToLoad.getDeclaredMethod("pluginType");
            Object instance = classToLoad.getClass().getDeclaredConstructors(Integer.class).newInstance(1);
            Object result = method.invoke(instance);
            JOptionPane.showMessageDialog(null, result.toString());*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Shape findShape(int x, int y, boolean remove) {
        for (Shape p : myShapes) {
            if (p.contains(x, y)) {
                if (remove) {
                    updateUndoStack();// done
                    myShapes.remove(p);
                }
                return p;
            }
        }
        return null;
    }

    public void updateUndoStack() {
        ArrayList<Shape> u = new ArrayList<>();
        myShapes.forEach((p) -> {
            u.add((Shape) p.Clone());
        });
        undoStack.push((ArrayList<Shape>) u);
    }

    public void updateRedoStack() {
        ArrayList<Shape> u = new ArrayList<>();
        myShapes.forEach((p) -> {
            u.add((Shape) p.Clone());
        });
        redoStack.push((ArrayList<Shape>) u);
    }

    @Override
    public void undo() {
        if (!undoStack.isEmpty()) {
            updateRedoStack();
            myShapes = undoStack.pop();
            panel.repaint();
        }
    }

    @Override
    public void redo() {
        if (!redoStack.isEmpty()) {
            updateUndoStack();
            myShapes = redoStack.pop();
            panel.repaint();
        }
    }

    @Override
    public void clear() {
        myShapes.clear();
        undoStack.clear();
        redoStack.clear();
        panel.repaint();
    }

    @Override
    public void addShape(Shape shape) {
        this.myShapes.add(shape);
    }

    @Override
    public void save(String path) {
        if (path.toLowerCase().endsWith(".json")) {
            jsonSaver.Save(myShapes, path);
        } else if (path.toLowerCase().endsWith(".xml")) {
            xmlSaver.Save(myShapes, path);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Save format.");
            throw new RuntimeException("Invalid format");
        }
    }

    @Override
    public void load(String path) {
        if (path.toLowerCase().endsWith(".json")) {
            myShapes = jsonSaver.Load(path);
        } else if (path.toLowerCase().endsWith(".xml")) {
            myShapes = xmlSaver.Load(path);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Save format.");
            throw new RuntimeException("Invalid format");
        }
        panel.repaint();
    }

    @Override
    public void removeShape(Shape shape) {
        if (myShapes.contains(shape)) {
            myShapes.remove(shape);
        }
    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
        removeShape(oldShape);
        addShape(newShape);
    }

    @Override
    public Shape[] getShapes() {
        return (Shape[]) myShapes.toArray();
    }

}

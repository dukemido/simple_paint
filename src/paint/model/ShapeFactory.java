/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import paint.views.MainForm;

/**
 *
 * @author Muhammad
 */
public class ShapeFactory {
     public static Shape getShape(Shape copiedObject) {
        Shape obj = null;
        if (copiedObject instanceof Circle) {
            obj = (Circle) copiedObject.Clone();
        } else if (copiedObject instanceof Square) {
            obj = (Square) copiedObject.Clone();
        } else if (copiedObject instanceof Rectangle) {
            obj = (Rectangle) copiedObject.Clone();
        } else if (copiedObject instanceof Line) {
            obj = (Line) copiedObject.Clone();
        } else if (copiedObject instanceof Triangle) {
            obj = (Triangle) copiedObject.Clone();
        } else if (copiedObject instanceof Ellipse) {
            obj = (Ellipse) copiedObject.Clone();
        }
        return obj;
    }

    public static Shape getInstance(ShapeTypes currentShapeType, int x, int y) {
        Shape currentShapeObject = null;
        switch (currentShapeType) {
            case Line: {
                currentShapeObject = new Line(x, y,
                        x, y, MainForm.ForeColor, MainForm.BackColor);
                break;
            }
            case Rectangle: {
                currentShapeObject = new Rectangle(x, y,
                        x, y, MainForm.ForeColor, MainForm.BackColor);
                break;
            }
            case Square: {
                currentShapeObject = new Square(x, y,
                        x, y, MainForm.ForeColor, MainForm.BackColor);
                break;
            }
            case Ellipse: {
                currentShapeObject = new Ellipse(x, y,
                        x, y, MainForm.ForeColor, MainForm.BackColor);
                break;
            }
            case Circle: {
                currentShapeObject = new Circle(x, y,
                        x, y, MainForm.ForeColor, MainForm.BackColor);
                break;
            }
            case Triangle: {
                currentShapeObject = new Triangle(x, y,
                        x, y, MainForm.ForeColor, MainForm.BackColor);
                break;
            }

        }
        return currentShapeObject;
    }
}

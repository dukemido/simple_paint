package paint.model;

import java.awt.Color;
import java.awt.Point;
import paint.views.MainForm;

public abstract class Shape implements IShape {

    private int x1, y1, x2, y2;
    private Color backColor, foreColor;
    private final ShapeTypes myShapeType;
    private int pluginId;

    public Shape(ShapeTypes myShapeType, int x1, int y1, int x2, int y2, Color foreColor, Color backColor) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.foreColor = foreColor;
        this.backColor = backColor;
        this.myShapeType = myShapeType;
    }

    public Shape(ShapeTypes myShapeType, int x1, int y1, int x2, int y2, Color foreColor, Color backColor, int pluginId) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.foreColor = foreColor;
        this.backColor = backColor;
        this.myShapeType = myShapeType;
        this.pluginId = pluginId;
    }

    public int getPluginId() {
        return pluginId;
    }

    @Override
    public ShapeTypes getShapeType() {
        return myShapeType;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    // Used in the clone.
    public void updateAllCoords(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public Color getFillColor() {
        return backColor;
    }

    @Override
    public void setFillColor(Color backColor) {
        this.backColor = backColor;
    }

    @Override
    public Color getColor() {
        return foreColor;
    }

    @Override
    public void setColor(Color foreColor) {
        this.foreColor = foreColor;
    }

    @Override
    public int getUpperLeftX() {
        return Math.min(getX1(), getX2());
    }

    @Override
    public int getUpperLeftY() {
        return Math.min(getY1(), getY2());
    }

    @Override
    public int getWidth() {
        return Math.abs(getX1() - getX2());
    }

    @Override
    public int getHeight() {
        return Math.abs(getY1() - getY2());
    }

    @Override
    public Point getPosition() {
        return new Point(getUpperLeftX(), getUpperLeftY());
    }

    @Override
    public void setPosition(Point point) {
        setX1(point.x);
        setY1(point.y);
    }

}

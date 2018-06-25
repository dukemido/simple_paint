package paint.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Shape {

    Ellipse2D.Double shape;

    public Ellipse(int x1, int y1, int x2, int y2, Color fore, Color back) {
        super(ShapeTypes.Ellipse, x1, y1, x2, y2, fore, back);
    }

    @Override
    public void draw(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        shape = new Ellipse2D.Double(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

        g.setColor(getFillColor());
        g.fill(shape);

        g.setColor(getColor());
        g.draw(shape);
    }

    @Override
    public boolean contains(int x, int y) {
        return shape.contains(x, y);
    }

    @Override
    public Ellipse Clone() {
        return new Ellipse(getX1(), getY1(), getX2(), getY2(), getColor(), getFillColor());
    }
}

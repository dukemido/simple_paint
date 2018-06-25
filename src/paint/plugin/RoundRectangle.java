package paint.plugin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import paint.model.Shape;
import paint.model.ShapeTypes;

public class RoundRectangle extends Shape {

    RoundRectangle2D.Double shape;

    public RoundRectangle(int x1, int y1, int x2, int y2, Color fore, Color back, int pluginId) {
        super(ShapeTypes.Plugin, x1, y1, x2, y2, fore, back, pluginId);
    }

    @Override
    public void draw(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        shape = new RoundRectangle2D.Double(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight(), 50, 50);
        g.setColor(getFillColor());
        g.fill(shape);

        g.setColor(getColor());
        g.draw(shape);
    }

    @Override
    public boolean contains(int x, int y) {
        return shape.contains(x, y);

    }

    public String pluginType() {
        return "RoundRectangle";
    }

    @Override
    public RoundRectangle Clone() {
        return new RoundRectangle(getX1(), getY1(), getX2(), getY2(), getColor(), getFillColor(), getPluginId());
    }
}

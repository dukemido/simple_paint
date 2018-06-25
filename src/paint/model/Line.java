package paint.model;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class inherits from MyShape and is responsible for drawing a line.
 */
public class Line extends Shape {

    public Line(int x1, int y1, int x2, int y2, Color fore, Color back) {
        super(ShapeTypes.Line, x1, y1, x2, y2, fore, back);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }

    @Override
    public boolean contains(int x, int y) {
        
        int dxc = x - getX1();
        int dyc = y - getY1();

        int dxl = getX2() - getX1();
        int dyl = getY2() - getY1();

        int cross = dxc * dyl - dyc * dxl;
        return cross == 0;

    }

    @Override
    public Line Clone() {
        return new Line(getX1(), getY1(), getX2(), getY2(), getColor(), getFillColor());
    }
}

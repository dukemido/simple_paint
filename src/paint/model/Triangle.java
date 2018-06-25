/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Muhammad
 */
public class Triangle extends Shape {

    int x3;

    public Triangle(int x1, int y1, int x2, int y2, Color fore, Color back) {
        super(ShapeTypes.Triangle, x1, y1, x2, y2, fore, back);
    }

    @Override
    public void draw(Graphics g) {
        x3 = 2 * getX1() - getX2();
        g.setColor(getFillColor());
        g.fillPolygon(new int[]{getX1(), getX2(), x3}, new int[]{getY1(), getY2(), getY2()}, 3);

        g.setColor(getColor());
        g.drawPolygon(new int[]{getX1(), getX2(), x3}, new int[]{getY1(), getY2(), getY2()}, 3);
    }

    @Override
    public boolean contains(int x, int y) {
        int x1 = getX1(), y1 = getY1();
        int x2 = getX2(), y2 = getY2();
        int y3 = getY2();

        double ABC = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        double ABP = Math.abs(x1 * (y2 - y) + x2 * (y - y1) + x * (y1 - y2));
        double APC = Math.abs(x1 * (y - y3) + x * (y3 - y1) + x3 * (y1 - y));
        double PBC = Math.abs(x * (y2 - y3) + x2 * (y3 - y) + x3 * (y - y2));

        return ABP + APC + PBC == ABC;
    }

    @Override
    public Triangle Clone() {
        return new Triangle(getX1(), getY1(), getX2(), getY2(), getColor(), getFillColor());
    }
}

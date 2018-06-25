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
public interface IShape {

    public ShapeTypes getShapeType();

    public int getUpperLeftX();

    public int getUpperLeftY();

    public int getWidth();

    public int getHeight();

    public void setPosition(java.awt.Point position);

    public java.awt.Point getPosition();

    public Color getFillColor();

    public void setFillColor(Color backColor);

    public Color getColor();

    public void setColor(Color foreColor);

    public void draw(Graphics g);

    public Object Clone();

    public boolean contains(int x, int y);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.util.ArrayList;
import paint.model.Shape;

/**
 *
 * @author Muhammad
 */
public interface ILoadSave {

    public void Save(ArrayList<Shape> shapes, String path);

    public ArrayList<Shape> Load(String path);
}

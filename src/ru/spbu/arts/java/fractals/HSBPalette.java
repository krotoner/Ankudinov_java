package ru.spbu.arts.java.fractals;

import javafx.scene.paint.Color;

public class HSBPalette implements Palette{

    @Override
    public Color paintWithColor(double x) {
        return Color.hsb( x * 100.0, 4, 1);
    }
}

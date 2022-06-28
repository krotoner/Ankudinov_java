package ru.spbu.arts.java.fractals;

public class GradientCircleFractal implements Fractal{

    @Override
    public double paint(double x, double y) {
        double r = Math.sqrt(x * x + y * y);
        if (r > 1)
            r = 1;
        return r;
    }
}

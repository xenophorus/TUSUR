package ru.xeno;

import jdk.jshell.spi.ExecutionControl;

import java.util.Arrays;
import java.util.Objects;

public class Color {

    private double xPosition;
    private double yPosition;
    private int[] color;

    public double getXPosition() {
        return xPosition;
    }

    public void setXPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }

    public void setYPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public void setPointPosition(double xPosition, double yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int[] getColor() {
        return color;
    }

    public void setColor(int[] color) {
        this.color = this.colorHandler(color);
    }

    private int[] colorHandler(int[] color) {
        /** Функция задает цвет точки в формате RGB в виде массива целых чисел.
         *  Если цветов указано меньше, недостающие будут нулями.
         *  Если число цвета больше 255, оно будет уменьшено до 255, если меньше нуля, то будет нулем.          *
         * @color - массив цветов в формате RGB
         * */
        int[] col = new int[] {0, 0, 0};
        int colorQuantity = Math.min(color.length, 3);
        for (int i = 0; i < colorQuantity; i++) {
            int c = color[i];
            col[i] = Math.max(Math.min(c, 255), 0);
        }
        return col;
    }

    Color() {
        this.xPosition = 0;
        this.yPosition = 0;
        this.color = new int[] {0, 0, 0};
    }

    Color(double x, double y) {
        this.xPosition = x;
        this.yPosition = y;
        this.color = new int[] {0, 0, 0};
    }

    Color(double x, double y, int[] color) {
        this.xPosition = x;
        this.yPosition = y;
        this.color = this.colorHandler(color);
    }

    Color(int[] color) {
        this.xPosition = 0;
        this.yPosition = 0;
        this.color = this.colorHandler(color);
    }

    @Override
    public String toString() {
        return String.format("Точка (%.3f, %.3f), цвет (RGB) #%02x%02x%02x",
                this.xPosition,
                this.yPosition,
                this.color[0], this.color[1], this.color[2]
        );
    }

    public Color add(Color other) {
        return new Color(this.xPosition + other.getXPosition(),
                this.yPosition + other.getYPosition(),
                this.colorHandler(new int[] {
                        this.color[0] + other.color[0],
                        this.color[1] + other.color[1],
                        this.color[2] + other.color[2]
                }));
    }

    public Color sub(Color other) {
        return new Color(this.xPosition - other.getXPosition(),
                this.yPosition - other.getYPosition(),
                this.colorHandler(new int[] {
                        this.color[0] - other.color[0],
                        this.color[1] - other.color[1],
                        this.color[2] - other.color[2]
                }));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Color other)) {
            return false;
        }
        return this.xPosition == other.getXPosition() &&
                this.yPosition == other.getYPosition() &&
                this.color[0] == other.color[0] &&
                this.color[1] == other.color[1] &&
                this.color[2] == other.color[2];
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPosition, yPosition, Arrays.hashCode(color));
    }
}



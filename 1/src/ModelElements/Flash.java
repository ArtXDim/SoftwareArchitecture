package ModelElements;

import java.awt.*;

/**
 * Класс, представляющий вспышку (flash).
 */
public class Flash {
    /** Положение вспышки в трехмерном пространстве. */
    Point3D location;

    /** Угол ориентации вспышки. */
    Angle3D angle;

    /** Цвет вспышки. */
    Color color;

    /** Мощность вспышки. */
    Float power;

    /**
     * Метод для вращения вспышки на заданный угол.
     *
     * @param angle Угол, на который нужно вращать вспышку.
     */
    public void rotate(Angle3D angle){
        this.angle = angle;
    }

    /**
     * Метод для перемещения вспышки в заданную точку.
     *
     * @param point Точка, в которую нужно переместить вспышку.
     */
    public void move(Point3D point){
        this.location = point;
    }
}
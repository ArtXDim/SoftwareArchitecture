package ModelElements;

/**
 * Класс, представляющий камеру.
 */
public class Camera {
    /** Положение камеры в трехмерном пространстве. */
    Point3D location;

    /** Угол ориентации камеры. */
    Angle3D angle;

    /**
     * Метод для вращения камеры на заданный угол.
     *
     * @param angle Угол, на который нужно вращать камеру.
     */
    public void rotate(Angle3D angle){
        this.angle = angle;
    }

    /**
     * Метод для перемещения камеры в заданную точку.
     *
     * @param point Точка, в которую нужно переместить камеру.
     */
    public void move(Point3D point){
        this.location = point;
    }
}

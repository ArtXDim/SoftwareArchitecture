package ModelElements;

/**
 * Класс, представляющий сцену с моделью, вспышкой и камерой.
 */
public class Scene {
    /** Уникальный идентификатор сцены. */
    public int id;

    /** Модель сцены. */
    PoligonalModel models;

    /** Вспышка на сцене. */
    Flash flashes;

    /** Камера на сцене. */
    Camera camera;

    /**
     * Конструктор для создания экземпляра Scene с указанием модели, вспышки и камеры.
     *
     * @param models  Модель сцены.
     * @param flashes Вспышка на сцене.
     * @param camera  Камера на сцене.
     */
    public Scene(PoligonalModel models, Flash flashes, Camera camera) {
        this.models = models;
        this.flashes = flashes;
        this.camera = camera;
    }

    /**
     * Получает объект камеры на сцене.
     *
     * @return Объект Camera, представляющий камеру на сцене.
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * Устанавливает уникальный идентификатор сцены.
     *
     * @param id Уникальный идентификатор сцены.
     */
    public void setId(int id) {
        this.id = id;
    }
}
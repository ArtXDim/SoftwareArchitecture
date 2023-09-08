package InMemoryModel;

import ModelElements.*;

/**
 * Класс, представляющий хранилище модели и реализующий интерфейс IModelChanger.
 */
public class ModelStore implements IModelChanger {
    public PoligonalModel models;
    public Scene scenes;
    public Flash flashes;
    public Camera cameras;
    /**
     * Конструктор для создания экземпляра ModelStore с передачей наблюдателя изменений.
     *
     * @param changeObserver Наблюдатель изменений модели.
     */
    public ModelStore(IModelChangedObserver changeObserver) {
        this.models = new PoligonalModel(new Poligone());
        this.flashes = new Flash();
        this.cameras = new Camera();

        this.scenes = new Scene(this.models, this.flashes, this.cameras);
    }

    /**
     * Получает сцену по индексу.
     *
     * @param n Индекс сцены.
     * @return Объект Scene.
     */
    public Scene getScene(int n) {
        return this.scenes;
    }

    @Override
    public void notifyChange(IModelChanger sender) {
    }
}
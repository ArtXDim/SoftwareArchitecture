package InMemoryModel;

/**
 * Интерфейс для изменения модели и уведомления о изменениях.
 */
public interface IModelChanger {
    /**
     * Метод, который уведомляет о изменении модели.
     *
     * @param sender Объект, инициирующий изменение модели.
     */
    void notifyChange(IModelChanger sender);
}
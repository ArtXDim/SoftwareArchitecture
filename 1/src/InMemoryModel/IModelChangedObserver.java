package InMemoryModel;

public interface IModelChangedObserver {
    /**
     * Метод, который вызывается для применения обновления модели.
     */
    public void applyUpdateModel();
}
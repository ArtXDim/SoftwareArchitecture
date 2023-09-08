package src;

import InMemoryModel.*;
import ModelElements.*;

/**
 * Главный класс приложения для демонстрации работы с моделью.
 */
public class Main {
    /**
     * Главный метод приложения.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        // Создаем экземпляр наблюдателя изменений модели
        IModelChangedObserver observer = new IModelChangedObserver() {
            @Override
            public void applyUpdateModel() {
                // Реализация обновления модели при изменениях
                System.out.println("Модель была изменена.");
            }
        };

        // Создаем хранилище модели с передачей наблюдателя изменений
        ModelStore modelStore = new ModelStore(observer);

        // Производим операции с объектами модели
        Angle3D angle = new Angle3D();
        Point3D point = new Point3D();
        modelStore.cameras.rotate(angle);
        modelStore.cameras.move(point);
        modelStore.flashes.rotate(angle);
        modelStore.flashes.move(point);

        // Выводим информацию о модели
        Scene scene = modelStore.getScene(1);
        System.out.println("ID сцены: " + scene.id);

        // Вызываем метод уведомления о изменении модели
        modelStore.notifyChange(modelStore);
    }
}

package ModelElements;

/**
 * Класс, представляющий полигональную модель.
 */
public class PoligonalModel {
    /** Полигоны модели. */
    Poligone poligons;

    /** Текстуры модели. */
    Textures texture;

    /**
     * Конструктор для создания экземпляра PoligonalModel с указанием полигонов.
     *
     * @param poligons Полигоны модели.
     */
    public PoligonalModel(Poligone poligons) {
        this.poligons = poligons;
    }
}
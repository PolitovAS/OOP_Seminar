package Classes;

import Interfaces.iActorBehaviour;
import Interfaces.iReturnOrder;
/*
 * Абстрактный класс, описывающий покупателя в магазине
 */
public abstract class Actor implements iActorBehaviour, iReturnOrder{
    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;
    protected boolean isCanReturn;
    /**
     * Конструктор класса
     * @param name имя покупателя
     */
    public Actor(String name) {
        this.name = name;
    }
    /**
     * Абстрактный метод для получения имени покупателя
     * @return имя покупателя
     */
    public abstract String getName(); 

    

}

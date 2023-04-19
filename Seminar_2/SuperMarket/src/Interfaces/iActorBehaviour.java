package Interfaces;

import Classes.Actor;

/**
 * Интерфейс, описывающий поведение покупателей в магазине.
 */
public interface iActorBehaviour {
    /**
     * Метод для установки флага создания заказа.
     * @param makeOrder флаг создания заказа.
     */
    void setMakeOrder(boolean makeOrder);
    
    /**
     * Метод для установки флага взятия заказа.
     * @param pickUpOrder флаг взятия заказа.
     */
    void setTakeOrder(boolean pickUpOrder);
    
    /**
     * Метод для получения значения флага создания заказа.
     * @return true, если заказ создан, иначе false.
     */
    boolean isMakeOrder();
    
    /**
     * Метод для получения значения флага взятия заказа.
     * @return true, если заказ взят, иначе false.
     */
    boolean isTakeOrder();
    
    /**
     * Метод для получения объекта покупателя.
     * @return объект покупатель.
     */
    Actor getActor();
}
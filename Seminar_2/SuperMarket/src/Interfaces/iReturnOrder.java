package Interfaces;

/**
 * Интерфейс iReturnOrder определяет поведение возврата товара.
 */
public interface iReturnOrder {
    
    /**
     * Метод для проверки возможности возврата товара.
     * @return true - если возврат возможен, false - если нет.
     */
    boolean isCanReturn();

    /**
     * Возвращает заказ от клиента
     * @param canReturn флаг возврата заказа.
     */
    void setReturnOrder(boolean canReturn);
}
package Interfaces;

/*
 * Интерфейс iQueueBehaviour определяет поведение очереди в магазине.
 */
public interface iQueueBehaviour {

    /**
     * Добавляет клиента в очередь.
     * @param actor клиент, которого нужно добавить в очередь
     */
    void takeInQueue(iActorBehaviour actor);

    /*
     * Удаляет клиента из очереди.
     */
    void releaseFromQueue();

    /*
     * Принимает заказ от клиента в очереди.
     */
    void takeOrder();

    /*
     * Дает заказ клиенту в очереди.
     */
    void giveOrder();

    /*
     * Возвращает заказ клиента.
     */
    void returnOrder();
    
    /*
     * проверка на акцию
     */
    void checkPromo(iActorBehaviour actor);
}
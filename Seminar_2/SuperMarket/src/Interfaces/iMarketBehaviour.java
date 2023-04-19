package Interfaces;

import java.util.List;

import Classes.Actor;

/*
 * Интерфейс iMarketBehaviour определяет поведение магазина
 */
public interface iMarketBehaviour {

    /**
     * Добавляет клиента в магазин.
     * @param actor клиент, которого нужно добавить в магазин
     */
    void acceptToMarket(iActorBehaviour actor);

    /**
     * Удаляет клиентов из магазина.
     * @param actors список клиентов, которых нужно удалить из магазина
     */
    void releaseFromMarket(List<Actor> actors);

    /**
     * Обновляет состояние магазина.
     */
    void update();    
}
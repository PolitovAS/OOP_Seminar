package Classes;

import java.util.ArrayList;
import java.util.List;

import Interfaces.iActorBehaviour;
import Interfaces.iMarketBehaviour;
import Interfaces.iQueueBehaviour;
import Interfaces.iReturnOrder;
/*
 * Класс Market реализует интерфейсы iMarketBehaviour и iQueueBehaviour.
 * Он представляет собой магазин, в котором клиенты могут делать заказы и ждать своей очереди.
 */
public class Market implements iMarketBehaviour,iQueueBehaviour{
    // Список клиентов, которые находятся в очереди
    private List<iActorBehaviour> queue;

    /*
     * Конструктор класса создает новый экземпляр класса ArrayList<iActorBehaviour> для хранения очереди клиентов.
     */
    public Market() {
        this.queue = new ArrayList<iActorBehaviour>();
    }

    /**
     * Метод acceptToMarket принимает клиента и добавляет его в магазин.
     * @param actor - клиент, который пришел в магазин
     */
    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        System.out.printf("Клиент %s пришел в магазин\n", actor.getActor().getName());
        takeInQueue(actor);
    }

    /**
     * Метод takeInQueue добавляет клиента в очередь.
     * @param actor - клиент, который ждет своей очереди
     */
    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        System.out.printf("Клиент %s встал в очередь\n", actor.getActor().getName());
    }

    /**
     * Метод releaseFromMarket удаляет клиента из магазина.
     * @param actors - список клиентов, которые уходят из магазина
     */
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(Actor actor:actors)
        {
            System.out.printf("Клиент %s ушел из магазина\n", actor.getName());
            queue.remove(actor);
        }
        
    }

    /**
     * Метод update вызывает методы takeOrder, giveOrder, returnOrder и releaseFromQueue.
     */
    @Override
    public void update() {
        takeOrder();
        giveOrder();
        returnOrder();
        releaseFromQueue();
    }

    /**
     * Метод giveOrder выдает заказ клиенту, если он сделал заказ.
     */
    @Override
    public void giveOrder() {
        for(iActorBehaviour actor: queue)
        {
            if(actor.isMakeOrder())
            {
                actor.setTakeOrder(true);
                System.out.printf("Клиент %s получил свой заказ\n", actor.getActor().getName());
            }
        }
        
    }

    /**
     * Метод releaseFromQueue удаляет клиента из очереди, если он получил свой заказ.
     */
    @Override
    public void releaseFromQueue() {
       List<Actor> releaseActors = new ArrayList<>();
       for(iActorBehaviour actor:queue)
       {
        if(actor.isTakeOrder())
        {
            releaseActors.add(actor.getActor());
            System.out.printf("Клиент %s ушел из очереди\n", actor.getActor().getName());
        }

       }
    releaseFromMarket(releaseActors);
    }

    /**
     * Метод takeOrder принимает заказ от клиента, если он еще не сделал заказ.
     */
    @Override
    public void takeOrder() {
        for(iActorBehaviour actor:queue)
        {
            if(!actor.isMakeOrder()){
            actor.setMakeOrder(true);
            System.out.printf("Клиент %s сделал заказ\n", actor.getActor().getName());
            }
        }
        
    }

    /**
     * Метод returnOrder возвращает заказ от клиента, если есть возможность.
     */
    @Override
    public void returnOrder(){
        for(iActorBehaviour actor: queue)
        {
            if(!((iReturnOrder) actor).isCanReturn())
            {
                ((iReturnOrder) actor).setReturnOrder(true);
                System.out.printf("Клиент %s вернул свой заказ\n", actor.getActor().getName());
            }
        }
    }

    /**
     * Метод проверяет, являются ли клиенты в очереди на обслуживание участниками акции и 
     * если количество участников акции достигло максимального значения, то такие
     * клиенты будут удалены из очереди и получат сообщение об отказе в обслуживании.
     */
    @Override
    public void checkPromo(iActorBehaviour actor){
        List<Actor> looserActors = new ArrayList<>();
        
        if (actor.getActor() instanceof PromoClient && PromoClient.getPromoNumber() >= PromoClient.getMaxPromoClients()) {
            looserActors.add(actor.getActor());
            System.out.printf("Извините, %s, акция заполнена. В настоящее время мы не можем вас обслужить.\n", actor.getActor().getName());
        }
        
        releaseFromMarket(looserActors);
        
        
    }
}
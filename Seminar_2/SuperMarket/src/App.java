import Classes.Market;
import Classes.OrdinaryClient;
import Classes.PromoClient;
import Classes.SpecialClient;
import Interfaces.iActorBehaviour;
/*
 * Главный класс приложения.
 */
public class App {
    /**
     * Метод main, запускающий приложение.
     * @param args аргументы командной строки.
     * @throws Exception возможные исключения.
     */
    public static void main(String[] args) throws Exception {

       Market market = new Market();
       iActorBehaviour item1 = new OrdinaryClient("Boris");
       iActorBehaviour item2 = new SpecialClient("Fedor", 1101);
       iActorBehaviour item3 = new PromoClient("Dasha", "1+1=1", 11);

       /*
        * Обычный клиент, пройдет все этапы
        */
       market.acceptToMarket(item1);
       market.update();

       /*
        * ВИП клиент, пройдет все этапы, исключая возврат товара
        */
       market.acceptToMarket(item2);
       market.takeOrder();
       market.giveOrder();
       market.releaseFromQueue();

       /*
        * Акционный клиент, получает отказ в обслуживании
        */
       market.acceptToMarket(item3);
       market.checkPromo(item3);      
       
    }
}
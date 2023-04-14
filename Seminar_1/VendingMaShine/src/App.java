import Products.BottleOfWater;
import Products.Product;
import VendingMachines.VendingMachine;
import Products.HotDrink;

public class App {
    public static void main(String[] args) throws Exception {

        Product item1 = new Product("Cola",88.0);
        item1.setPrice(98.0);
        VendingMachine itemMachine = new VendingMachine(300);
        itemMachine.addProduct(item1);
        itemMachine.addProduct(new Product("Чипсы", 60.0));        
        itemMachine.addProduct(new Product("Масло", 50.0));
        itemMachine.addProduct(new Product("Хлеб", 40.0));
        itemMachine.addProduct(new Product("Снек", 20.0));
        itemMachine.addProduct(new BottleOfWater("Cola", 88.0, 500));
        itemMachine.addProduct(new BottleOfWater("Water", 188.0, 1500));

        itemMachine.addProduct(new HotDrink("Кофе капучино", 32.60, 0.18, 65));
        itemMachine.addProduct(new HotDrink("Кофе американо", 35.90, 0.12, 75));
        itemMachine.addProduct(new HotDrink("Черный чай", 25.00, 0.2, 80));
        itemMachine.addProduct(new HotDrink("Зеленый чай", 27.10, 0.2, 75));

        for (Product product : itemMachine.getProductAll()) {
            System.out.println(product.toString());
            }

        new VendingMachinesUI(itemMachine);
        }         
}

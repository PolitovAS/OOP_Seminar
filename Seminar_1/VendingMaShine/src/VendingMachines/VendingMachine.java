package VendingMachines;

import Products.Product;
import java.util.*;

public class VendingMachine {
    private int volume;
    private List<Product> products;
    private List<String> workLog;
    private Double money;
    

    /**
     * Конструктор с новым параметром
     * @param volume объем бутылки
     */
    public VendingMachine(int volume){
        this.volume = volume;
        products = new ArrayList<Product>();
        workLog = new ArrayList<String>();
    }
    
    public void addProduct(Product prod)
    {
        products.add(prod);
    }

    public void addSales(String line)
    {
        workLog.add(line);
    }
    
    public Product getProdByName(String name){
        for (Product product : products) {
            if (product.getName().contains(name)){
                return product;
            }
        }

        return null;
    }

    public List<Product> getProductAll(){
        return products;
    }

    public String buy(Product product, Double money) {
        if (money >= product.getPrice()) {
            Double change = money - product.getPrice();
            money = 0.0;
            return "Вы успешно купили " + product.getName() + ". Ваша сдача: " + change + " руб.";
        } else {
            return "У вас недостаточно денег для покупки.";
        }
    }
}

package VendingMachines;

import Products.Product;
import java.util.*;

public class VendingMachine {
    private int volume;
    private List<Product> products;
    private List<String> workLog;

    /**
     * конструктор продукта 2 параметра
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
    
    public Product gerProdByName(String name){
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
}

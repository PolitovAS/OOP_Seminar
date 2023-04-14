package Products;

public class HotDrink extends Product{

    private int temp;
    private Double volume;

    public HotDrink(String name, Double price, Double volume, int temp){
        super(name, price);
        this.volume = volume;
        this.temp = temp;
        if ((temp <= 0) || (temp >= 100)) {
            throw new IllegalStateException(String.format("Темпереатура указана некорректно: %d", temp));
        }
    }
     
    public int getTemp(){ 
        return temp;         
    } 

    public void setTemp(int value)
    {
        if (value <= 0) {
            throw new IllegalStateException(String.format("Темпереатура указана некорректно: %d", value));
        }
        temp = value;
    }

    public Double getVolume(){ 
        return volume;         
    } 

    public void setVolume(Double value)
    {
        volume = value;
    }
    /**
     * переопределение вывода продукта
     */
    @Override
    public String toString()
    {
        return  "Product{" +
        "name='" + super.getName() + '\'' +
        ", cost=" + super.getPrice() +
        ", volume=" + volume +
        ", temperature=" + temp +
        '}';
    }
}

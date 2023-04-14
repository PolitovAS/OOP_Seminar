import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Products.*;
import VendingMachines.*;


public class VendingMachinesUI extends JFrame {
    private VendingMachine vendingMachines;
    private DefaultListModel<Product> productListModel;
    private JList<Product> productList;
    private JTextField moneyInputField;
    private JButton buyButton;

    public VendingMachinesUI(VendingMachine vendingMachines) {
        super("Vending Machines");
        this.vendingMachines = vendingMachines;

        // Создаем список продуктов
        productListModel = new DefaultListModel<>();
        for (Product product : vendingMachines.getProductAll()) {
            productListModel.addElement(product);
        }
        productList = new JList<>(productListModel);

        // Создаем поле ввода наличности
        moneyInputField = new JTextField(10);
        // moneyInputField.setToolTipText("Выберите товар и введите сумму, затем нажмите \"Купить товар\"");

        // Создаем кнопку "Купить товар"
        buyButton = new JButton("Купить товар");
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получаем выбранный продукт и введенную наличность
                Product selectedProduct = productList.getSelectedValue();
                Double money = Double.parseDouble(moneyInputField.getText());

                // Покупаем продукт и выводим результат в диалоговом окне
                String result = vendingMachines.buy(selectedProduct, money);
                JOptionPane.showMessageDialog(VendingMachinesUI.this, result);
            }
        });

        // Создаем панель для размещения элементов интерфейса
        JPanel panel = new JPanel(new BorderLayout());
        JLabel instructionLabel = new JLabel("Выберите товар и введите сумму, затем нажмите \"Купить товар\"");
        panel.add(instructionLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(productList), BorderLayout.CENTER);
        panel.add(moneyInputField, BorderLayout.AFTER_LAST_LINE);
        panel.add(buyButton, BorderLayout.AFTER_LINE_ENDS);

        // Добавляем панель на форму
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        
    }
}

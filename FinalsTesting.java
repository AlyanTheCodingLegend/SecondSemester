import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

enum Cereals {
    CORNFLAKES(1), FROSTIES(2), CHEERIOS(3), RICE_KRISPIES(4), SHREDDED_WHEAT(5);

    private final int id;

    Cereals(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }
}

abstract class Food {
    abstract void produce();
    abstract void consume();

    void giveDetails() {
        System.out.println("This is a food item.");
    }
}

interface DairyProduct {
    float price=0;

    void produce();
    void consume();
    void getPrice();
}

class Milk extends Food implements DairyProduct{
    private float price;

    public Milk(float price) {
        this.price=price;
    }

    public void produce() {
        System.out.println("Milk is produced.");
    }

    public void consume() {
        System.out.println("Milk is consumed.");
    }

    public void getPrice() {
        System.out.println("Price of milk: " + price);
    }
}

class MyException extends Error {
    public MyException(String message) {
        super(message);
    }
}

public class FinalsTesting{
    public static void main(String[] args) throws MyException{
        int c = Cereals.RICE_KRISPIES.getId();
        System.out.println(c);

        Milk m = new Milk(2.5f);
        try{
            m.consume();
            throw new MyException("Exception thrown.");
        } catch (Error e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        m.produce();
        m.getPrice();
        m.giveDetails();

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        
        for (String s : list) {
            System.out.print(s+" ");
        }

        JFrame frame = new JFrame("Hello World");
        BorderLayout layout = new BorderLayout();
        JButton button = new JButton("Click me");
        JPanel panel = new JPanel();
        panel.add(button);;
        button.addActionListener(e -> {
            System.out.println("Button clicked.");
        });
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();
        frame.setLayout(layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
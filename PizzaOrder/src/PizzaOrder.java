import javax.swing.*;
import javax.swing.border.*;

public class PizzaOrder extends JFrame
{
    public static void main(String [] args)
    {
        new PizzaOrder();
    }

    private JButton buttonOK;
    private JRadioButton small, medium, large;
    private JCheckBox pepperoni, mushrooms, meaty;
    public PizzaOrder()
    {
        this.setSize(320,200);
        this.setTitle("WELCOME please Order Your Pizza");
        this.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

        JPanel sizePanel = new JPanel();
        Border b1 =
                BorderFactory.createTitledBorder("Size");
        sizePanel.setBorder(b1);

        ButtonGroup sizeGroup = new ButtonGroup();

        small = new JRadioButton("Small");
        small.setSelected(true);
        sizePanel.add(small);
        sizeGroup.add(small);

        medium = new JRadioButton("Medium");
        sizePanel.add(medium);
        sizeGroup.add(medium);

        large = new JRadioButton("Large");
        sizePanel.add(large);
        sizeGroup.add(large);

        mainPanel.add(sizePanel);

        JPanel topPanel = new JPanel();
        Border b2 =
                BorderFactory.createTitledBorder(
                        "Toppings");
        topPanel.setBorder(b2);

        pepperoni = new JCheckBox("Pepperoni");
        topPanel.add(pepperoni);

        mushrooms = new JCheckBox("Mushrooms");
        topPanel.add(mushrooms);

        meaty = new JCheckBox("Meaty");
        topPanel.add(meaty);

        mainPanel.add(topPanel);

        buttonOK = new JButton("OK");
        buttonOK.addActionListener(e -> buttonOKClick() );
        mainPanel.add(buttonOK);
        this.add(mainPanel);

        this.setVisible(true);
    }

    public void buttonOKClick()
    {
        String tops = "";
        if (pepperoni.isSelected())
            tops += "Pepperoni\n";
        if (mushrooms.isSelected())
            tops += "Mushrooms\n";
        if (meaty.isSelected())
            tops += "Meaty\n";

        String msg = "You ordered a ";
        if (small.isSelected())
            msg += "small pizza with ";
        if (medium.isSelected())
            msg += "medium pizza with ";
        if (large.isSelected())
            msg += "large pizza with ";

        if (tops.equals(""))
            msg += "no toppings.";
        else
            msg += "the following toppings:\n"
                    + tops;
        JOptionPane.showMessageDialog(
                buttonOK, msg, "Your Order",
                JOptionPane.INFORMATION_MESSAGE);

        pepperoni.setSelected(false);
        mushrooms.setSelected(false);
        meaty.setSelected(false);
        small.setSelected(true);
    }
}

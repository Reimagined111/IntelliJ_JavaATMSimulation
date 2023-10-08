import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndPage extends JFrame {
    private JLabel label0 = new JLabel("Now withdrawing " + Hundreds.numHundreds + " hundreds, " + Fifties.numFifties + " fifties, " + Twenties.numTwenties + " twenties, " + Tens.numTens + " tens, " + Fives.numFives + " fives, " + Ones.numOnes + " ones, and $" + String.format("%.2f", WelcomePage.withdrawAmount) + " in change.");
    private JLabel label1 = new JLabel("You now have $" + String.format("%.2f", Main.amountAccount) + " in your account.");
    private JLabel label2 = new JLabel("Thanks for choosing Java Banking! Goodbye!");
    EndPage(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.add(label0);
        this.add(label1);
        this.add(label2);
        this.pack();
        this.setVisible(true);
    }
}
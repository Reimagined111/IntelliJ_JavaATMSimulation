import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.*;
import java.util.regex.*;
import static java.lang.System.exit;


public class WelcomePage extends JFrame implements ActionListener{
    private JButton confirm;
    private JTextField amntWithdraw;
    public static double withdrawAmount;
    public static String withdrawString;
    private JLabel label = new JLabel("Welcome to Java Banking! How much would you like to withdraw (numbers ONLY)? You currently have $" + Main.amountAccount + " in your account.");
    WelcomePage(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.add(label);

        confirm = new JButton("Confirm");
        confirm.addActionListener(this);

        amntWithdraw = new JTextField();
        amntWithdraw.setPreferredSize(new Dimension(250,40));
        amntWithdraw.setFont(new Font("Consolas",Font.PLAIN,35));
        amntWithdraw.setForeground(new Color(0x00FF00));
        amntWithdraw.setBackground(Color.black);
        amntWithdraw.setCaretColor(Color.white);

        this.add(confirm);
        this.add(amntWithdraw);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirm) {
            withdrawString = amntWithdraw.getText();
            withdrawAmount = Double.parseDouble(withdrawString);
            withdrawString = String.format("%.2f", withdrawAmount);
            withdrawAmount = Double.parseDouble(withdrawString);
            if (withdrawAmount <= Main.amountAccount) {
                this.dispose();
                ConfirmWindow myWindow = new ConfirmWindow();
            }
            else
            {
                this.dispose();
                new WelcomePage();
            }
        }
    }
}

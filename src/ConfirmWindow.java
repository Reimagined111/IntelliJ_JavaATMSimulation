import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmWindow implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("You have chosen $" + WelcomePage.withdrawAmount +". Is this correct?");
    JButton yes = new JButton("Yes");
    JButton no = new JButton("No");
    ConfirmWindow(){

        label.setBounds(0,0,1000,50);
        label.setFont(new Font("Times New Roman",Font.PLAIN,25));

        frame.add(label);

        yes.setBounds(100,160,200,40);
        yes.setFocusable(false);
        yes.addActionListener(this);
        no.setBounds(300,160,200,40);
        no.setFocusable(false);
        no.addActionListener(this);

        frame.add(yes);
        frame.add(no);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==yes) {
            Main.amountAccount -= WelcomePage.withdrawAmount;
            frame.dispose();
            if(Double.compare(WelcomePage.withdrawAmount, 100.0) >= 0)
            {
                frame.dispose();
                Hundreds hundredsWindow = new Hundreds();
            } else if (Double.compare(WelcomePage.withdrawAmount, 100.0) < 0 && Double.compare(WelcomePage.withdrawAmount, 50.0)>=0) {
                frame.dispose();
                Fifties fiftiesWindow = new Fifties();
            } else if (Double.compare(WelcomePage.withdrawAmount, 50.0) < 0 && Double.compare(WelcomePage.withdrawAmount, 20.0)>=0) {
                frame.dispose();
                Twenties twentiesWindow = new Twenties();
            } else if (Double.compare(WelcomePage.withdrawAmount, 20.0) < 0 && Double.compare(WelcomePage.withdrawAmount, 10.0)>=0) {
                frame.dispose();
                Tens tensWindow = new Tens();
            } else if (Double.compare(WelcomePage.withdrawAmount, 10.0) < 0 && Double.compare(WelcomePage.withdrawAmount, 5.0)>=0) {
                frame.dispose();
                Fives fivesWindow = new Fives();
            } else if (Double.compare(WelcomePage.withdrawAmount, 5.0) < 0 && Double.compare(WelcomePage.withdrawAmount, 1.0) >= 0 ) {
                frame.dispose();
                Ones onesWindow = new Ones();
            } else {
                frame.dispose();
                EndPage endPage = new EndPage();
            }
        }
        else
        {
            frame.dispose();
            new WelcomePage();
        }
    }
}

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConfirmTens extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label;
    JButton yes;
    JButton no;

    ConfirmTens() {
        this.label = new JLabel("You have chosen " + Tens.numTens + " tens. Is this correct?");
        this.yes = new JButton("Yes");
        this.no = new JButton("No");
        this.label.setBounds(0, 0, 1000, 50);
        this.label.setFont(new Font("Times New Roman", 0, 25));
        this.frame.add(this.label);
        this.yes.setBounds(100, 160, 200, 40);
        this.yes.setFocusable(false);
        this.yes.addActionListener(this);
        this.no.setBounds(300, 160, 200, 40);
        this.no.setFocusable(false);
        this.no.addActionListener(this);
        this.frame.add(this.yes);
        this.frame.add(this.no);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setExtendedState(this.frame.getExtendedState() | 6);
        this.frame.setLayout((LayoutManager)null);
        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.yes) {
            WelcomePage.withdrawAmount -= (double)(Tens.numTens * 10);
            if (Double.compare(WelcomePage.withdrawAmount, 5.0) >= 0) {
                this.frame.dispose();
                new Fives();
            } else if (Double.compare(WelcomePage.withdrawAmount, 5.0) < 0 && Double.compare(WelcomePage.withdrawAmount, 1.0) >= 0) {
                this.frame.dispose();
                new Ones();
            } else {
                this.frame.dispose();
                new EndPage();
            }
        } else {
            this.frame.dispose();
            new Tens();
        }

    }
}
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Twenties extends JFrame implements ActionListener {
    JLabel label = new JLabel("Choose the number of twenties you want: ");
    JComboBox<Integer> twentiesBox;
    public static int numTwenties;

    Twenties() {
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        int n = (int)(WelcomePage.withdrawAmount / 20.0);
        Integer[] twenties = new Integer[n + 1];
        int inc = 0;

        for(int i = 0; i <= n; ++i) {
            twenties[i] = inc;
            ++inc;
        }

        this.twentiesBox = new JComboBox(twenties);
        this.twentiesBox.addActionListener(this);
        this.add(this.label);
        this.add(this.twentiesBox);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.twentiesBox) {
            this.dispose();
            numTwenties = this.twentiesBox.getSelectedIndex();
            new ConfirmTwenties();
        }

    }
}
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ones extends JFrame implements ActionListener {
    JLabel label = new JLabel("Choose the number of ones you want: ");
    JComboBox<Integer> onesBox;
    public static int numOnes;

    Ones() {
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        int n = (int)WelcomePage.withdrawAmount;
        Integer[] ones = new Integer[n + 1];
        int inc = 0;

        for(int i = 0; i <= n; ++i) {
            ones[i] = inc;
            ++inc;
        }

        this.onesBox = new JComboBox(ones);
        this.onesBox.addActionListener(this);
        this.add(this.label);
        this.add(this.onesBox);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.onesBox) {
            this.dispose();
            numOnes = this.onesBox.getSelectedIndex();
            new ConfirmOnes();
        }

    }
}

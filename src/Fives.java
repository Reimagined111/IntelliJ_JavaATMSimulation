import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fives extends JFrame implements ActionListener {
    JLabel label = new JLabel("Choose the number of fives you want: ");
    JComboBox<Integer> fivesBox;
    public static int numFives;

    Fives() {
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        int n = (int)(WelcomePage.withdrawAmount / 5.0);
        Integer[] fives = new Integer[n + 1];
        int inc = 0;

        for(int i = 0; i <= n; ++i) {
            fives[i] = inc;
            ++inc;
        }

        this.fivesBox = new JComboBox(fives);
        this.fivesBox.addActionListener(this);
        this.add(this.label);
        this.add(this.fivesBox);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fivesBox) {
            this.dispose();
            numFives = this.fivesBox.getSelectedIndex();
            new ConfirmFives();
        }

    }
}

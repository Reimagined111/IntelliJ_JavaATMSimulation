import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fifties extends JFrame implements ActionListener {
    JLabel label = new JLabel("Choose the number of fifties you want: ");
    JComboBox<Integer> fiftiesBox;
    public static int numFifties;

    Fifties() {
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        int n = (int)(WelcomePage.withdrawAmount / 50.0);
        Integer[] fifties = new Integer[n + 1];
        int inc = 0;

        for(int i = 0; i <= n; ++i) {
            fifties[i] = inc;
            ++inc;
        }

        this.fiftiesBox = new JComboBox(fifties);
        this.fiftiesBox.addActionListener(this);
        this.add(this.label);
        this.add(this.fiftiesBox);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fiftiesBox) {
            this.dispose();
            numFifties = this.fiftiesBox.getSelectedIndex();
            new ConfirmFifties();
        }

    }
}
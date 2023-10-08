import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tens extends JFrame implements ActionListener {
    JLabel label = new JLabel("Choose the number of tens you want: ");
    JComboBox<Integer> tensBox;
    public static int numTens;

    Tens() {
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        int n = (int)(WelcomePage.withdrawAmount / 10.0);
        Integer[] tens = new Integer[n + 1];
        int inc = 0;

        for(int i = 0; i <= n; ++i) {
            tens[i] = inc;
            ++inc;
        }

        this.tensBox = new JComboBox(tens);
        this.tensBox.addActionListener(this);
        this.add(this.label);
        this.add(this.tensBox);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.tensBox) {
            this.dispose();
            numTens = this.tensBox.getSelectedIndex();
            new ConfirmTens();
        }

    }
}
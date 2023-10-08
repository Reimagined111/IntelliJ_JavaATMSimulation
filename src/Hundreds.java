import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hundreds extends JFrame implements ActionListener {
    JLabel label = new JLabel("Choose the number of hundreds you want: ");
    JComboBox<Integer> hundredsBox;
    public static int numHundreds;

    Hundreds() {
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        int n = (int)(WelcomePage.withdrawAmount / 100.0);
        Integer[] hundreds = new Integer[n + 1];
        int inc = 0;

        for(int i = 0; i <= n; ++i) {
            hundreds[i] = inc;
            ++inc;
        }

        this.hundredsBox = new JComboBox(hundreds);
        this.hundredsBox.addActionListener(this);
        this.add(this.label);
        this.add(this.hundredsBox);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.hundredsBox) {
            this.dispose();
            numHundreds = this.hundredsBox.getSelectedIndex();
            new ConfirmHundreds();
        }

    }
}
/*import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private static JLabel label;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static JTextField owners;
    private static JTextField Eircode;
    private static JTextField Estimatedvalue;
    private static JLabel sucess;
    int start = 0;

    public GUI(int Start) {
        start = Start;
        if (start == 1) {
            JPanel panel = new JPanel();
            JFrame frame = new JFrame();
            frame.setSize(1920, 1080);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.add(panel);
            panel.setLayout(null);
            // temp labels
            label = new JLabel("Enter infomation");
            label2 = new JLabel("Owner(s)");
            label3 = new JLabel("Estimated value");
            label4 = new JLabel("Eircode");
            label.setBounds(10, 20, 150, 25);
            label2.setBounds(10, 40, 150, 25);
            label3.setBounds(10, 60, 150, 25);
            label4.setBounds(10, 80, 150, 25);
            panel.add(label);
            panel.add(label2);
            panel.add(label3);
            panel.add(label4);
            // Data Fields
            owners = new JTextField(20);
            owners.setBounds(110, 40, 165, 20);
            panel.add(owners);
            Estimatedvalue = new JTextField(20);
            Estimatedvalue.setBounds(110, 60, 165, 20);
            panel.add(Estimatedvalue);
            Eircode = new JTextField(20);
            Eircode.setBounds(110, 80, 165, 20);
            panel.add(Eircode);
            // input button
            JButton button = new JButton("Submit");
            button.setBounds(10, 100, 80, 25);
            button.addActionListener(new GUI(3));
            panel.add(button);
            JButton button2 = new JButton("Get tax info");
            button2.setBounds(10, 150, 170, 25);
            button2.addActionListener(new GUI(2));
            panel.add(button2);
            sucess = new JLabel("");
            sucess.setBounds(100, 110, 300, 25);
            panel.add(sucess);

        }
    }

    String owner2;
    Propertys test;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (start == 3) {
            owner2 = owners.getText();
            int estvalue = Integer.parseInt(Estimatedvalue.getText());
            String eircode = Eircode.getText();
            test = new Propertys(owner2, estvalue, "City", 'Y');
            sucess.setText("Info collected");
            System.out.println(owner2);
        }
        if (start == 2) {
            owner2 = owners.getText();
            int estvalue = Integer.parseInt(Estimatedvalue.getText());
            String eircode = Eircode.getText();
            test = new Propertys(owner2, estvalue, "City", 'Y');
            sucess.setText("Tax total is:" + test.get("calvin"));
            System.out.println(owner2);
        }
        if (start == 4){

        }
    }
}
 */
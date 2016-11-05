import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Yoko on 05.11.2016.
 */
public class ShowResultSelectTovarNaSklade extends JFrame {
    private JPanel panel;
    private JTextArea textArea2;
    private JButton показатьButton;
    private JTextField nameTovar;
    String list;

    public ShowResultSelectTovarNaSklade() {
        setContentPane(panel);
        setVisible(true);
        setSize(800, 600);
        показатьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list = SelectData.findSkladWhoHaveTovar(nameTovar.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                textArea2.setText(null);

                try {
                    textArea2.append(list);

                } catch (NullPointerException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}

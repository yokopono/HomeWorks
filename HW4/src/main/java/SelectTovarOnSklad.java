import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Yoko on 06.11.2016.
 */
public class SelectTovarOnSklad extends JFrame{

    private JTextArea textArea2;
    private JButton показатьButton;
    private JTextField nameTovar;
    private JPanel panel;
    ArrayList<String> list1;

    public SelectTovarOnSklad() {
        setContentPane(panel);
        setVisible(true);
        setSize(800, 600);
        показатьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list1 = SelectData.selectTovarOnSklad(nameTovar.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                textArea2.setText(null);

                for (String foundThink : list1) {
                    textArea2.append(foundThink +"\n");
                }

            }
        });
    }
}

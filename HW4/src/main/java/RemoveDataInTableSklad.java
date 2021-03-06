import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Yoko on 05.11.2016.
 */
public class RemoveDataInTableSklad extends JFrame {
    private JTextField nameNew;
    private JPanel mainPanel;
    private JButton addButton;
    private boolean result;

    public boolean isResult() {
        return result;
    }

    public RemoveDataInTableSklad() {
        setContentPane(mainPanel);
        setVisible(true);
        setSize(800, 600);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameNew.getText() == null) {
                    JOptionPane.showMessageDialog(null, "Введи имя!");
                } else {
                    try {
                        RemoveData.removeDataInTableSklad(nameNew.getText());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                setVisible(false);
                dispose();
            }
        });
    }
}
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Yoko on 05.11.2016.
 */
public class AddTables extends JFrame {
    private JPanel mainPanel;
    private JButton addButton;
    private JButton addTableTovarButton;
    private JTextField добавлениеТаблицВБДTextField;
    private boolean result;

    public boolean isResult() {
        return result;
    }

    public AddTables(){
        setContentPane(mainPanel);
        setVisible(true);
        setSize(600,200);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddTable.createTableSklad();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        addTableTovarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddTable.createTableTovar();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }



}
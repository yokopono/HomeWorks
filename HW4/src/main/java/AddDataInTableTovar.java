import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Yoko on 05.11.2016.
 */
public class AddDataInTableTovar  extends JFrame {
    private JTextField price;
    private JPanel mainPanel;
    private JButton addButton;
    private JTextField nameTovar;
    private JTextField kolichestvo;
    private JTextField idSklada;
    private boolean result;

    public boolean isResult() {
        return result;
    }

    public AddDataInTableTovar() {
        setContentPane(mainPanel);
        setVisible(true);
        setSize(800, 600);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int priceInt = Integer.parseInt(price.getText());
                int kolichestvoInt = Integer.parseInt(kolichestvo.getText());
                if (nameTovar.getText() == null && price.getText() == null && kolichestvo.getText() == null
                        &&idSklada.getText() == null) {
                    JOptionPane.showMessageDialog(null, "Заполни все поля!");
                } else {
                    try {
                        InsertData.insertDataInTableTovar(nameTovar.getText(),priceInt,
                                kolichestvoInt,idSklada.getText());
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
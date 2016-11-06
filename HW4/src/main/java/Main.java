import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Yoko on 04.11.2016.
 */
public class Main extends JFrame{

    private JButton addTables;
    private JButton addTovarButton;
    private JButton removeTovarButton;
    private JButton getListOfTovarButton;
    private JButton addSkladButton;
    private JButton removeSkladButton;
    private JPanel panel;
    private JButton selectTovarOnSkladButton;

    public Main() {
        setContentPane(panel);
        setVisible(true);
        setSize(500,500);
        addTables.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            AddTables form1 = new AddTables();
            }
        });
        addSkladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDataInTableSklad formAddDataInTableSklad = new AddDataInTableSklad();
            }
        });
        removeSkladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveDataInTableSklad formRemoveDataInTableSklad = new RemoveDataInTableSklad();
            }
        });
        addTovarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDataInTableTovar formAddDataInTableTovar = new AddDataInTableTovar();
            }
        });
        removeTovarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveDataInTableTovar formRemoveDataInTableTovar = new RemoveDataInTableTovar();
            }
        });
        getListOfTovarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowResultSelectTovarNaSklade formShowResultSelectTovarNaSklade = new ShowResultSelectTovarNaSklade();
            }
        });
        selectTovarOnSkladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectTovarOnSklad formSelectTovarOnSklad = new SelectTovarOnSklad();
            }
        });
    }

}

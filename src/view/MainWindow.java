package view;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame implements ActionListener {
    
    private JButton btnInsert_, btnQuery_;
    private JTable tblResults_;
    private JScrollPane scrlResults_;

    private FlowLayout screen_;

    private InsertWindow insertW_;

    public MainWindow()
    {
        setTitle("Proyectos");
        
        setBounds(0, 0, 300, 100);
        setLocationRelativeTo(null);

        insertW_ = new InsertWindow();
        
        btnQuery_ = new JButton("Consultar");
        btnQuery_.setBounds(10, 10, 115, 25);
        btnQuery_.addActionListener(this);
        add(btnQuery_);
        
        btnInsert_ = new JButton("Agregar Lider");
        btnInsert_.setBounds(10, 10, 115, 25);
        btnInsert_.addActionListener(this);
        add(btnInsert_);

        screen_ = new FlowLayout(FlowLayout.CENTER, 5, 20);
        setLayout(screen_);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void execute()
    {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnInsert_) {
            System.out.println("Insert");
            insertW_.execute();
        }
        if (e.getSource() == btnQuery_) {
            System.out.println("Query");
        }
    }
}

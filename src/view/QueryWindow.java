package view;

import javax.swing.JFrame;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryWindow extends JFrame implements ActionListener {

    private JPanel btnsPnl_;
    private JPanel tblPnl_;
    private JButton leadrsBtn_;
    private JButton materialsBtn_;
    private JButton clearBtn_;
    private JTable  resultsTbl_;
    private DefaultTableModel  resultsDfltTbl_;
    private JScrollPane resultsScrl_;
    FlowLayout layout_;

    private void addButton(JButton button, String name)
    {
        button = new JButton(name);
        button.addActionListener(this);
        btnsPnl_.add(button);

        // This is needed. Passed by value NOT by reference
        switch (button.getText()) {
            case "Lideres":
                leadrsBtn_ = button;
                break;
            case "Materiales":
                materialsBtn_ = button;
                break;
            case "Limpiar":
                clearBtn_ = button;
                break;
            default:
            System.out.println("[addButton] -> Assignation error.");
                break;
        }
    }

    private void buttonsInit()
    {
        addButton(leadrsBtn_, "Lideres");
        addButton(materialsBtn_, "Materiales");
        addButton(clearBtn_, "Limpiar");
    }

    private void dataPanelInit()
    {
        btnsPnl_ = new JPanel();
        btnsPnl_.setPreferredSize(new Dimension(605, 80));
        btnsPnl_.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        btnsPnl_.setBackground(Color.GREEN);
        {
            var fl = new FlowLayout(FlowLayout.CENTER, 100, 30);
            btnsPnl_.setLayout(fl);
        }
        add(btnsPnl_);
        
        buttonsInit();
        
        tblPnl_ = new JPanel();
        tblPnl_.setPreferredSize(new Dimension(605, 335));
        tblPnl_.setBackground(Color.CYAN);
        {
            var fl = new FlowLayout(FlowLayout.CENTER, 200, 11);
            tblPnl_.setLayout(fl);
        }
        add(tblPnl_);

        tableInit();
    }

    private void tableInit()
    {
        resultsDfltTbl_ = new DefaultTableModel();
        resultsTbl_ = new JTable(resultsDfltTbl_);
        
        resultsScrl_ = new JScrollPane(resultsTbl_);
        resultsScrl_.setPreferredSize(new Dimension(595, 315));
        
        tblPnl_.add(resultsScrl_);
    }

    public QueryWindow()
    {
        layout_ = new FlowLayout(FlowLayout.CENTER, 10, 10);
        setLayout(layout_);
        setTitle("Consultas");
        setMinimumSize(new Dimension(640, 480));
        setLocationRelativeTo(null);
        setResizable(false);

        dataPanelInit();
    }

    public void execute()
    {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leadrsBtn_)
        {
            System.out.println("leaders");
        }
        
        if(e.getSource() == materialsBtn_)
        {
            System.out.println("materials");
        }
        
        if(e.getSource() == clearBtn_)
        {
            System.out.println("clear");
        }
        
    }
}

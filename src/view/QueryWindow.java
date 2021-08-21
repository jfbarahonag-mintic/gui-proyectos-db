package view;

import javax.swing.JFrame;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryWindow extends JFrame implements ActionListener {

    private JPanel btnsPnl_;
    private JPanel tblPnl_;
    private JButton leadrsBtn_;
    private JButton materialsBtn_;
    private JTable resultsTbl_;
    private JScrollPane resultsScrl_;

    private void buttonsInit()
    {
        leadrsBtn_ = new JButton("Lideres");
        leadrsBtn_.addActionListener(this);
        btnsPnl_.add(leadrsBtn_);
        
        materialsBtn_ = new JButton("Materiales");
        materialsBtn_.addActionListener(this);
        
        btnsPnl_.add(materialsBtn_);
    }

    private void dataPanelInit()
    {
        btnsPnl_ = new JPanel();
        btnsPnl_.setBounds(10, 10, 605, 80);
        btnsPnl_.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        btnsPnl_.setBackground(Color.GREEN);
        var fl = new FlowLayout(FlowLayout.CENTER, 200, 30);
        fl.setAlignOnBaseline(true);
        btnsPnl_.setLayout(fl);
        add(btnsPnl_);
        
        buttonsInit();
        
        tblPnl_ = new JPanel();
        tblPnl_.setLayout(null);
        tblPnl_.setBounds(10, 100, 605, 335);
        tblPnl_.setBackground(Color.CYAN);
        add(tblPnl_);
    }

    private void tableInit()
    {
        resultsTbl_ = new JTable();
        
        resultsScrl_ = new JScrollPane(resultsTbl_);
        resultsScrl_.setBounds(10, 10, 585, 315);
        
        tblPnl_.add(resultsScrl_);
    }

    public QueryWindow()
    {
        setLayout(null);
        setTitle("Consultas");
        setBounds(0, 0, 640, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        dataPanelInit();
        tableInit();
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
        
    }
}

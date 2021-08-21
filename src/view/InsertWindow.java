package view;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertWindow extends JFrame implements ActionListener {
    
    private JPanel dataPanel_;
    private GridLayout dataGL_;
    private JButton confirmBtn_;

    private JPanel[] panelsArray_;

    private void dataPanelInit()
    {
        dataPanel_ = new JPanel();
        dataGL_ = new GridLayout(6,2);
        dataPanel_.setLayout(dataGL_);
        add(dataPanel_);
    }

    private void addContent(int i, String labels[])
    {
        panelsArray_[i] = new JPanel();
            var internalGL = new GridLayout(2, 1);
            panelsArray_[i].setLayout(internalGL);
            panelsArray_[i].setPreferredSize(new Dimension(10,10));
            panelsArray_[i].setBorder(new LineBorder(Color.WHITE));

            JLabel s = new JLabel(labels[i]);
            s.setBounds(0, 0, 500, 30);
            panelsArray_[i].add(s);
            
            JTextField t = new JTextField();
            t.setBounds(0, 0, 500, 30);
            t.setPreferredSize(new Dimension(100,15));
            panelsArray_[i].add(t);
            dataPanel_.add(panelsArray_[i]);
    }

    private void addFields()
    {
        panelsArray_ = new JPanel[10];
        String[] labels = new String[] {"ID", "Nombre", "Primer Apellido", "Segundo Apellido", "Salario", "Ciudad de Residencia", "Cargo", "Clasificacion", "Documento de identidad", "Fecha de nacimiento [AAAA-MM-DD]"};
        for (int i = 0; i < panelsArray_.length; i++) {
            addContent(i, labels);
        }
        /* dummy space... Could be used later */
        JPanel p = new JPanel();
        dataPanel_.add(p);

        confirmBtn_ = new JButton("Confirmar");
        confirmBtn_.setFont(new Font("MONOSPACED", Font.BOLD, 16));
        confirmBtn_.addActionListener(this);
        dataPanel_.add(confirmBtn_);
    }
    
    public InsertWindow()
    {
        setTitle("Agregar lider");
        
        setBounds(0, 0, 640, 480);
        setLocationRelativeTo(null);

        dataPanelInit();
        addFields();
    }

    public void execute()
    {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirmBtn_)
        {
            System.out.println("Confirm");
        }
    }
}

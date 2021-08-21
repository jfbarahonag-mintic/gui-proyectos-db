package view;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.*;

public class InsertWindow extends JFrame implements ActionListener {
    
    private JPanel dataPanel_;
    private GridLayout dataGL_;
    private JButton confirmBtn_;

    private JPanel[] panelsArray_;
    private JTextField[] fieldsArray_;

    public static final RequirementsExecuter requirementsHandler = new RequirementsExecuter();

    private boolean areAllFieldsFilled()
    {
        boolean succeed = true;

        for (var field : fieldsArray_) {
            if(field.getText().equals("") == true){
                return false;
            }
        }
        
        return succeed;
    }

    private void dataPanelInit()
    {
        dataPanel_ = new JPanel();
        dataGL_ = new GridLayout(6,2);
        dataPanel_.setLayout(dataGL_);
        add(dataPanel_);
    }

    private void addContent(int i, String labels[])
    {
        /* Instance the objects */
        panelsArray_[i] = new JPanel();
        fieldsArray_[i] = new JTextField();

        var internalGL = new GridLayout(2, 1);
        panelsArray_[i].setLayout(internalGL);
        panelsArray_[i].setPreferredSize(new Dimension(10,10));
        panelsArray_[i].setBorder(new LineBorder(Color.WHITE));

        JLabel s = new JLabel(labels[i]);
        panelsArray_[i].add(s);
        
        fieldsArray_[i].setPreferredSize(new Dimension(100,15));
        panelsArray_[i].add(fieldsArray_[i]);
        
        dataPanel_.add(panelsArray_[i]);
    }

    private void addFields()
    {
        panelsArray_ = new JPanel[10];
        fieldsArray_ = new JTextField[10];
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
            if (!areAllFieldsFilled())
            {
                JOptionPane.showMessageDialog(this, "Se deben llenar todos los campos", "Insertar lider", JOptionPane.ERROR_MESSAGE);
                return;
            }
            executeInsert();
        }
    }

    private void cleanAllFields()
    {
        for (var field : fieldsArray_) {
            field.setText("");
        }
    }

    private void executeInsert()
    {
        try {
            //TODO: Please protect teh code against bad inputs!!!!!
            int counter = 0;
            Integer ID = Integer.parseInt(fieldsArray_[counter++].getText());
            String nombre = fieldsArray_[counter++].getText();
            String primerApellido = fieldsArray_[counter++].getText();
            String segundoApellido = fieldsArray_[counter++].getText();
            Integer salario = Integer.parseInt(fieldsArray_[counter++].getText());
            String ciudadResidencia = fieldsArray_[counter++].getText();
            String cargo = fieldsArray_[counter++].getText();
            Integer clasificacion = Integer.parseInt(fieldsArray_[counter++].getText());
            String documentoIdentidad = fieldsArray_[counter++].getText();
            String fechaNacimiento = fieldsArray_[counter++].getText();
            
            boolean ok = requirementsHandler.insertRequirement(requirementsHandler.fillLeaderData(ID, nombre, primerApellido, segundoApellido, salario, ciudadResidencia, cargo, clasificacion, documentoIdentidad, fechaNacimiento));

            String saved = (ok == true) ? "Lider agregado" : "Error. Lider no agregado";
            JOptionPane.showMessageDialog(this, saved, "Insertar lider", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(saved);

            if(ok == true) cleanAllFields();
            
        } catch (Exception e) {
            System.out.println("Error handled... Message :\r\n" + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error con los parametros recibidos. Por favor revise", "Insertar lider", JOptionPane.ERROR_MESSAGE);
        }
    }
}

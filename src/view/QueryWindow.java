package view;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.*;

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

    private boolean tableLoaded_ = false;

    public static final RequirementsExecuter requirementsHandler = new RequirementsExecuter();

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
        resetResultsTable();
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
            onLeadersBtnPressed();
        }
        
        if(e.getSource() == materialsBtn_)
        {
            System.out.println("materials");
            onMaterialsBtnPressed();
        }
        
        if(e.getSource() == clearBtn_)
        {
            System.out.println("clear");
            onClearBtnPressed();
        }
        
    }
    
    private void resetResultsTable()
    {
        if(tableLoaded_)
        {
            tblPnl_.remove(resultsScrl_);
            tableLoaded_ = false;
        }
        resultsDfltTbl_ = null;
        resultsTbl_ = null;
        resultsScrl_ = null;
        
        resultsDfltTbl_ = new DefaultTableModel();
        resultsTbl_ = new JTable(resultsDfltTbl_);

        // resultsDfltTbl_.addColumn("new one");

        resultsScrl_ = new JScrollPane(resultsTbl_);
        resultsScrl_.setPreferredSize(new Dimension(595, 315));
        
        tblPnl_.add(resultsScrl_);
        tableLoaded_ = true;

        SwingUtilities.updateComponentTreeUI(this);
    }

    private void fillMaterialsTableData()
    {
        String[] columns = new String[] {"ID Proyecto", "Nombre Material", "Precio por Unidad"};
        
        for (String column : columns) {
            resultsDfltTbl_.addColumn(column);
        }

        try {
            var response = requirementsHandler.queryMaterialsRequirement();
            for (var material : response) {
                String[] rowData = new String[] {material.getIdProyecto().toString(), material.getNombreMaterial(), material.getPrecioUnidad().toString()};
                resultsDfltTbl_.addRow(rowData);
            }
        } catch (Exception e) {
            System.out.println("Error handled... Message :\r\n" + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error con los parametros recibidos. Por favor revise", "Consulta Lider", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void fillLeadersTableData()
    {
        String[] columns = new String[] {"ID Lider", "Salario", "Ciudad de residencia"};
        
        for (String column : columns) {
            resultsDfltTbl_.addColumn(column);
        }

        try {
            var response = requirementsHandler.queryLeadersRequirement();
            for (var material : response) {
                String[] rowData = new String[] {material.getIDLider().toString(), material.getSalario().toString(), material.getCiudadResidencia()};
                resultsDfltTbl_.addRow(rowData);
            }
        } catch (Exception e) {
            System.out.println("Error handled... Message :\r\n" + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error con los parametros recibidos. Por favor revise", "Consulta Lider", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onLeadersBtnPressed()
    {
        resetResultsTable();
        fillLeadersTableData();
    }
    
    private void onMaterialsBtnPressed()
    {
        resetResultsTable();
        fillMaterialsTableData();
    }
    
    private void onClearBtnPressed()
    {
        resetResultsTable();
    }
}

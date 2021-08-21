package model.DAO;

import java.sql.SQLException;

import model.VO.insertLeaderVO;
import util.JDBCUtilities;

public class insertLeaderDAO {
    public boolean insertLeader(insertLeaderVO leader) throws SQLException
    {
        boolean succeed = true;

        String sql = "INSERT INTO Lider " + 
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try(var conn = JDBCUtilities.getConnection();
            var ps = conn.prepareStatement(sql);) {
                int counter = 1;
                ps.setInt(counter++, leader.getID());
                ps.setString(counter++, leader.getNombre());
                ps.setString(counter++, leader.getPrimerApellido());
                ps.setString(counter++, leader.getSegundoApellido());
                ps.setInt(counter++, leader.getSalario());
                ps.setString(counter++, leader.getCiudadResidencia());
                ps.setString(counter++, leader.getCargo());
                ps.setInt(counter++, leader.getClasificacion());
                ps.setString(counter++, leader.getDocumentoIdentidad());
                ps.setString(counter++, leader.getFechaNacimiento());
                var rs = ps.executeUpdate();
                if (rs <= 0) {
                    succeed = false;
                }
        }

        return succeed;
    }
}

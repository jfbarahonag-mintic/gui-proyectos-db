package model.DAO;

import java.sql.SQLException;

import model.VO.insertLeaderVO;
import util.JDBCUtilities;

public class insertLeaderDAO {
    public boolean insertLeader() throws SQLException
    {
        boolean succeed = true;

        String sql = "INSERT INTO Lider " + 
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try(var conn = JDBCUtilities.getConnection();
            var ps = conn.prepareStatement(sql);) {
                var rs = ps.executeUpdate();
                if (rs <= 0) {
                    succeed = false;
                }
        }

        return succeed;
    }
}

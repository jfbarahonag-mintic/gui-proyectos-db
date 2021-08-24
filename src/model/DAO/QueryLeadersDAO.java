package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import model.VO.QueryLeadersVO;
import util.JDBCUtilities;

public class QueryLeadersDAO {
    public ArrayList<QueryLeadersVO> execute() throws SQLException
    {
        ArrayList<QueryLeadersVO> response = new ArrayList<QueryLeadersVO>();
        
        String sql =    "SELECT l.ID_Lider , l.Salario , l.Ciudad_Residencia " +
                        "FROM Lider l " +
                        "WHERE l.Salario < (SELECT AVG(l2.Salario) " +
                                            "FROM Lider l2) " +
                        "ORDER BY l.Salario ASC;";
        try (var connection = JDBCUtilities.getConnection();
            var stmt = connection.prepareStatement(sql);
            var rs = stmt.executeQuery();)
        {
        while (rs.next()) {
                QueryLeadersVO req = new QueryLeadersVO();
                req.setIDLider(rs.getInt("ID_Lider"));
                req.setSalario(rs.getInt("Salario"));
                req.setCiudadResidencia(rs.getString("Ciudad_Residencia"));
                response.add(req);
            }
        }
        return response;
    }
}

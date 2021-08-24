package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import model.VO.QueryMaterialsVO;
import util.JDBCUtilities;

public class QueryMaterialsDAO {
    
    public ArrayList<QueryMaterialsVO> execute() throws SQLException
    {
        ArrayList<QueryMaterialsVO> response = new ArrayList<QueryMaterialsVO>();

        String sql =    "SELECT c.ID_Proyecto , mc.Nombre_Material , mc.Precio_Unidad " +
                        "FROM Compra c NATURAL JOIN MaterialConstruccion mc " +
                        "WHERE c.ID_Proyecto IN (23, 38, 50) " +
                        "ORDER BY c.ID_Proyecto ASC;";

        try (var connection = JDBCUtilities.getConnection();
            var stmt = connection.prepareStatement(sql);
            var rs = stmt.executeQuery();)
        {
            while (rs.next()) {
                QueryMaterialsVO req = new QueryMaterialsVO();
                req.setIdProyecto(rs.getInt("ID_Proyecto"));
                req.setNombreMaterial(rs.getString("Nombre_Material"));
                req.setPrecioUnidad(rs.getInt("Precio_Unidad"));
                response.add(req);
            }
        }
        return response;
    }
}

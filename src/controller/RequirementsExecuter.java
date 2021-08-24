package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.VO.*;
import model.DAO.*;

public class RequirementsExecuter {
    private final InsertLeaderDAO requirement1DAO;
    private final QueryLeadersDAO requirement2DAO;
    private final QueryMaterialsDAO requirement3DAO;

    public RequirementsExecuter()
    {
        requirement1DAO = new InsertLeaderDAO();
        requirement2DAO = new QueryLeadersDAO();
        requirement3DAO = new QueryMaterialsDAO();
    }

    public InsertLeaderVO fillLeaderData(Integer ID,
                                            String nombre,
                                            String primerApellido,
                                            String segundoApellido,
                                            Integer salario,
                                            String ciudadResidencia,
                                            String cargo,
                                            Integer clasificacion,
                                            String documentoIdentidad,
                                            String fechaNacimiento
                                            )
    {
        InsertLeaderVO newLeader = new InsertLeaderVO();

        newLeader.setID(ID);
        newLeader.setNombre(nombre);
        newLeader.setPrimerApellido(primerApellido);
        newLeader.setSegundoApellido(segundoApellido);
        newLeader.setSalario(salario);
        newLeader.setCiudadResidencia(ciudadResidencia);
        newLeader.setCargo(cargo);
        newLeader.setClasificacion(clasificacion);
        newLeader.setDocumentoIdentidad(documentoIdentidad);
        newLeader.setFechaNacimiento(fechaNacimiento);

        return newLeader;
    } 

    public boolean insertRequirement(InsertLeaderVO leader) throws SQLException
    {
        return requirement1DAO.insertLeader(leader);
    }

    public ArrayList<QueryLeadersVO> queryLeadersRequirement() throws SQLException
    {
        return requirement2DAO.execute();
    }
    
    public ArrayList<QueryMaterialsVO> queryMaterialsRequirement() throws SQLException
    {
        return requirement3DAO.execute();
    }
}

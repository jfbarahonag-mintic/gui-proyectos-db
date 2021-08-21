package controller;

import java.sql.SQLException;

import model.VO.*;
import model.DAO.*;

public class RequirementsExecuter {
    private final InsertLeaderDAO requirement1DAO;

    public RequirementsExecuter()
    {
        requirement1DAO = new InsertLeaderDAO();
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
}

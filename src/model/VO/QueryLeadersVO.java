package model.VO;

public class QueryLeadersVO {

    private String ciudadResidencia;
    private Integer salario;
    private Integer ID_lider;
    
    public String getCiudadResidencia() {
        return ciudadResidencia;
    }
    public void setCiudadResidencia(String ciudad_residencia) {
        this.ciudadResidencia = ciudad_residencia;
    }
    public Integer getSalario() {
        return salario;
    }
    public void setSalario(Integer salario) {
        this.salario = salario;
    }
    public Integer getIDLider() {
        return ID_lider;
    }
    public void setIDLider(Integer iD_lider) {
        ID_lider = iD_lider;
    }
}

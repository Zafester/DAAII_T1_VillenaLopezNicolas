package pe.edu.cibertec.DAAII_T1_VillenaLopezNicolas.model.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer idusuario;
    private String nomusuario;
    private String nombres;
    private String apellidos;
    private Boolean activo;
    private String email;
}

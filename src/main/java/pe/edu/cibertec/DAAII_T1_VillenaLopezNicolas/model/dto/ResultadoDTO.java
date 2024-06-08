package pe.edu.cibertec.DAAII_T1_VillenaLopezNicolas.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultadoDTO {
    private Boolean respuesta;
    private String mensaje;
}

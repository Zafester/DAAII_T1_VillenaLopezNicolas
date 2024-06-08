package pe.edu.cibertec.DAAII_T1_VillenaLopezNicolas.service;

import pe.edu.cibertec.DAAII_T1_VillenaLopezNicolas.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario buscarUsuarioPorNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    List<Usuario> listarUsuario();
    Usuario buscarUsuarioPorIdUsuario(Integer idusuario);
}

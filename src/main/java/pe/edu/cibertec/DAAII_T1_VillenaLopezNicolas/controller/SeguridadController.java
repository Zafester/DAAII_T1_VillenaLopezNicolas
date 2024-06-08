package pe.edu.cibertec.DAAII_T1_VillenaLopezNicolas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAAII_T1_VillenaLopezNicolas.model.bd.Usuario;
import pe.edu.cibertec.DAAII_T1_VillenaLopezNicolas.model.dto.ResultadoDTO;
import pe.edu.cibertec.DAAII_T1_VillenaLopezNicolas.model.dto.UsuarioDTO;
import pe.edu.cibertec.DAAII_T1_VillenaLopezNicolas.service.UsuarioService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public String frmMantUsuario(Model model){
        model.addAttribute("listaUsuarios", usuarioService.listarUsuario());
        return "seguridad/formusuario}";
    }
    @PostMapping("/usuario")
    @ResponseBody
    public ResultadoDTO registrarUsuario(@RequestBody UsuarioDTO usuarioDto){
        String mensaje = "Usuario registrado!";
        boolean respuesta = true;
        try{
            Usuario usuario = new Usuario();
            usuario.setNombres(usuarioDto.getNombres());
            usuario.setApellidos(usuarioDto.getApellidos());
            if (usuarioDto.getIdusuario() > 0){
                usuario.setIdusuario(usuarioDto.getIdusuario());
                usuario.setActivo(usuarioDto.getActivo());
                usuarioService.actualizarUsuario(usuario);
            }else{
                usuario.setNomusuario(usuarioDto.getNomusuario());
                usuario.setEmail(usuarioDto.getEmail());
                usuarioService.guardarUsuario(usuario);
            }
        }catch (Exception ex){
            mensaje = "Este usuario no esta registrado";
            respuesta = false;
        }
        return ResultadoDTO.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario frmMantUsuario(@PathVariable("id")int id){
        return usuarioService.buscarUsuarioPorIdUsuario(id);
    }
    @GetMapping("/usuariosall")
    @ResponseBody
    public List<Usuario> listaUsuario(){
        return usuarioService.listarUsuario();
    }
}

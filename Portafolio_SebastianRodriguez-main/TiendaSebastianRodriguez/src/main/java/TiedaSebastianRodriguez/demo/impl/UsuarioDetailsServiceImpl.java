/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiedaSebastianRodriguez.demo.impl;

import TiedaSebastianRodriguez.demo.dao.UsuarioDao;
import TiedaSebastianRodriguez.demo.domain.Rol;
import TiedaSebastianRodriguez.demo.domain.Usuario;
import TiedaSebastianRodriguez.demo.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tanyr
 */
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //busca elusuario x nombre en la tabla
        
        Usuario usuario = usuarioDao.findByUsername(username);
        //si no existe el usuario lanza una excepcion
        if (usuario ==null){
            throw new UsernameNotFoundException(username);
        }
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getUsername());
        //si esta aca es xq el usuario si existe... sacamos los roles que tiene
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()){ //se sacan los roles
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
            
        }
        //se devuelve el user (clase de userdetails)
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}

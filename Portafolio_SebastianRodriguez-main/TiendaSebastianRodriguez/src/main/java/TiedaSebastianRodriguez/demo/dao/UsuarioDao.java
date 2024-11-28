/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TiedaSebastianRodriguez.demo.dao;

import TiedaSebastianRodriguez.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author PC MASTER
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
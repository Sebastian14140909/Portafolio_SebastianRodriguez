/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TiedaSebastianRodriguez.demo.dao;

import TiedaSebastianRodriguez.demo.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tanyr
 */
 public interface ProductoDao extends JpaRepository<Producto, Long> {
}
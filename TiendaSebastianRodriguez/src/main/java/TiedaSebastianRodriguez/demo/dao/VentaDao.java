package TiedaSebastianRodriguez.demo.dao;


import TiedaSebastianRodriguez.demo.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaDao extends JpaRepository <Venta,Long> {
     
}
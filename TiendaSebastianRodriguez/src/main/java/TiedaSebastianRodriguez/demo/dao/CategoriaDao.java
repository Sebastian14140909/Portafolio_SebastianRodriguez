package TiedaSebastianRodriguez.demo.dao;


import TiedaSebastianRodriguez.demo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author adrianchavarriamora
 */
public interface CategoriaDao extends JpaRepository<Categoria,Long>{
    
}
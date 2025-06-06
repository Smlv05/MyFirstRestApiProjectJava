package pl.vistula.myfirstrestapiprojectjava.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.vistula.myfirstrestapiprojectjava.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

package ge.itstep.javaproject.repository;

import ge.itstep.javaproject.model.Pagination;
import ge.itstep.javaproject.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer>,PagingAndSortingRepository<Product,Integer> {
    @Query(value = "SELECT max(id) FROM Product")
    public int GetMaxId();

    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE %?1%")
    public Page<Product> search(String query, Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE p.category_id = :cat_id")
    public Page<Product> GetProductWithCategory(Integer cat_id, Pageable pageable);
}

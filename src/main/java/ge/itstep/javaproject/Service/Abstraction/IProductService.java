package ge.itstep.javaproject.Service.Abstraction;

import ge.itstep.javaproject.model.Pagination;
import ge.itstep.javaproject.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
   // public List<Product> GetAllProduct();
    public Page<Product> GetAllProduct(Pagination pagination);
    public Page<Product> GetProductWithCategory(Integer cat_id, Pagination pagination);
    public Product GetProductById(Integer id);
    public boolean AddProduct(Product product);
    public Page<Product> SearchWithQuery(String query,Pagination pagination);
}
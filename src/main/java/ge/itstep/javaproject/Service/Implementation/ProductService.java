package ge.itstep.javaproject.Service.Implementation;

import ge.itstep.javaproject.Service.Abstraction.IProductService;
import ge.itstep.javaproject.model.Pagination;
import ge.itstep.javaproject.model.Product;
import ge.itstep.javaproject.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService  implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    Product product = new Product();

    @Override
    public Page<Product> GetAllProduct(Pagination pagination){
        Sort sort = Sort.by(pagination.getSortDirection(), pagination.getSortBy());
        Pageable pageable = PageRequest.of(pagination.getPageNumber(),pagination.getPageSize(),sort);
        return productRepository.findAll(pageable);
    }

    public Page<Product> GetProductWithCategory(Integer cat_id,Pagination pagination)  {
        try {
            if(cat_id <= 0){
                throw new IllegalArgumentException("category Id should not be less or equal to zero");
            }
            Sort sort = Sort.by(pagination.getSortDirection(), pagination.getSortBy());
            Pageable pageable = PageRequest.of(pagination.getPageNumber(),pagination.getPageSize(),sort);
          return productRepository.GetProductWithCategory(cat_id,pageable);
        }catch (IllegalArgumentException ex){
            log.error(ex.getMessage() + ex);
        }
        return  null;

    }

    @Override
    public Product GetProductById(Integer id)  {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("Id should not be less or equal to zero");
            }
            if (id > productRepository.GetMaxId()) {
                throw new NoSuchElementException("No record found on this ID");
            }
            return   product = productRepository.findById(id).get();
        } catch (Exception ex) {
            log.error(ex.getMessage() + ex);
        }
        return  null;
    }

    @Override
    public boolean AddProduct(Product product) {
        try {
            if(CheckNull(product) == false){
                throw  new NullPointerException("Product can't be null");
            }
            productRepository.save(product);
            return  true;
        }catch (NullPointerException ex){
            log.error(ex.getMessage() + ex);
        }
        return  false;
    }

    @Override
    public Page<Product> SearchWithQuery(String query,Pagination pagination) {
        try {
            if(query == ""){
                throw new IllegalArgumentException("search query can not be null");
            }
            Sort sort = Sort.by(pagination.getSortDirection(), pagination.getSortBy());
            Pageable pageable = PageRequest.of(pagination.getPageNumber(),pagination.getPageSize(),sort);
          return   productRepository.search(query,pageable);
        }catch (IllegalArgumentException ex){
            log.error(ex.getMessage() + ex);
        }
        return  null;
    }

    public  boolean CheckNull(Product product){
        if(product.getName().isBlank() == true || product.getCategory_id() == 0 || product.getImg_url().isBlank() == true  || product.getPrice() == 0 ){
            return  false;
        }
        return  true;
    }

}

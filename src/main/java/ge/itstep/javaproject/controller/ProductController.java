package ge.itstep.javaproject.controller;

import ge.itstep.javaproject.Service.Abstraction.IProductService;
import ge.itstep.javaproject.Service.Implementation.CategoryService;
import ge.itstep.javaproject.model.Comment;
import ge.itstep.javaproject.model.Pagination;
import ge.itstep.javaproject.model.Product;
import ge.itstep.javaproject.repository.CategoryRepository;
import ge.itstep.javaproject.repository.CommentRepository;
import ge.itstep.javaproject.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//@RestController
@Slf4j
@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IProductService _productService;

    @GetMapping(value = "/")
    public ModelAndView index(ModelAndView mav, Pagination pagination) throws Exception {
        mav.addObject("products",_productService.GetAllProduct(pagination));
        mav.addObject("categories",categoryService.GetAllCategory());
        mav.addObject("query",new String());
        mav.setViewName("index");
        return mav;
    }

    @GetMapping( "/home/{pageNumber}/{pageSize}")
    public ModelAndView getPaged(ModelAndView mav,@Param("pagination") Pagination pagination)throws Exception {
        mav.addObject("products",_productService.GetAllProduct(pagination));
        mav.addObject("categories",categoryService.GetAllCategory());
        mav.addObject("query",new String());
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/show/{id}")
    public ModelAndView show(@PathVariable Integer id , ModelAndView mav) throws Exception {

        var products = _productService.GetProductById(id);
        var categories = categoryService.GetAllCategory();
        mav.addObject("products", products);
        mav.addObject("categories", categories);
        mav.addObject("comments", commentRepository.findAll().stream().filter(x->x.getProduct_id() == id).collect(Collectors.toList()));
        mav.addObject("newComment", new Comment());
        mav.setViewName("show");

        return mav;
    }

    @GetMapping("/AddProduct")
    public  String add(Model model){
        model.addAttribute("newProduct",new Product());
        return "add";
    }

    @PostMapping("/AddProduct")
    public ModelAndView addProduct(@ModelAttribute Product newProduct) {
            _productService.AddProduct(newProduct);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/category/{id}")
    public  ModelAndView getCategory(@PathVariable Integer id, ModelAndView mav,Pagination pagination) throws Exception {
        mav.addObject("categories",categoryService.GetAllCategory());
        mav.addObject("products",_productService.GetProductWithCategory(id,pagination));
        mav.setViewName("index");
        return  mav;
    }

    @GetMapping("/search")
    public ModelAndView Search(@Param("query") String query, Pagination pagination)  {
        var mav = new ModelAndView();
        mav.addObject("categories",categoryService.GetAllCategory());
        mav.addObject("products",_productService.SearchWithQuery(query, pagination));
        mav.setViewName("index");
        return  mav;
    }


}
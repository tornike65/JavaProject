package ge.itstep.javaproject.Service.Implementation;

import ge.itstep.javaproject.Service.Abstraction.ICategoryService;
import ge.itstep.javaproject.model.Category;
import ge.itstep.javaproject.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> GetAllCategory() {
        try {
            return (List<Category>) categoryRepository.findAll();
        }catch (Exception ex){
            log.error("Can not get category  " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean AddCategory(Category category) {
        return false;
    }
}

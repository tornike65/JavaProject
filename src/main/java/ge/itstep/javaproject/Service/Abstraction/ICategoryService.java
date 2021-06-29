package ge.itstep.javaproject.Service.Abstraction;

import ge.itstep.javaproject.model.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> GetAllCategory() throws Exception;
    public boolean AddCategory(Category category);
}

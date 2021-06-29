package ge.itstep.javaproject.controller;

import ge.itstep.javaproject.model.Comment;
import ge.itstep.javaproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CommentController {
    @Autowired
    CommentRepository commentRepository;
    @PostMapping("/AddComment/{id}")
    public ModelAndView AddComment(@ModelAttribute Comment newComment,@PathVariable Integer id){
         newComment.setProduct_id(id);
        newComment.setCreate_date(LocalDateTime.now());
        commentRepository.save(newComment);
        return new ModelAndView("redirect:/show/" + newComment.getProduct_id());
    }
}

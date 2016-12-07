package inno.controller;

import com.sun.javafx.css.CalculatedValue;
import inno.model.Comment;
import inno.model.Post;
import inno.model.User;
import inno.repository.CommentRepository;
import inno.repository.PostRepository;
import inno.security.SecurityUtils;
import inno.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@ContextConfiguration( locations =
                {
                "file:src/test/resources/security-config.xml",
                "file:src/test/resources/persistence-config.xml",
                "file:src/test/resources/dispatcher-context.xml"
                })
@RunWith(SpringJUnit4ClassRunner.class)
@Controller
@RequestMapping("posts/comments")
public class TestCommentControllerTest {

//    @Autowired
//    PostRepository postRepository;
//
//    @Autowired
//    CommentRepository commentRepository;
//
//    @Autowired
//    CommentService commentService;
//
//    @Test
//    @RequestMapping
//    public String getAllPosts(@RequestParam(value = "phrase", required = false) String phrase, ModelMap map) {
//        List<Post> posts = postRepository.findAll();
//        if (phrase != null) {
//            posts = posts.stream().filter(p -> p.getText().contains(phrase)).collect(Collectors.toList());
//        }
//        map.addAttribute("posts", posts);
//        return "posts/index";
//    }
//
    @Test
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addNewCommentPage(ModelMap map) {
        map.addAttribute("comment", new Comment());

    }

//    @Test
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addNewPost(@ModelAttribute @Valid Comment comment, BindingResult result) {
//        if (result.hasErrors()) {
//            return "comments/add";
//        }
//        commentService.saveComment(comment);
//        return "redirect:/posts";
//    }
//
//    @Test
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String showComment(@PathVariable("id") Long id, ModelMap map) {
//        Comment comment = commentRepository.findOne(id);
//        map.addAttribute("comment", comment);
//        return "/posts/show";
//    }
//
//    @Test
//    @Secured("ROLE_ADMIN")
//    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
//    public String deleteComment(@PathVariable("id") Long id) {
//        Comment comment = commentRepository.findOne(id);
//        if (!userCanEditComment(comment)) {
//            throw new AccessDeniedException("Access denied ne rabotaet");
//        }
//        commentRepository.delete(comment);
//        return "redirect:/posts";
//    }
//
//    //    @PostAuthorize("isAuthorized() and #map['post'].user.id eq principal.id")
//    @Test
//    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
//    public String editComment(@PathVariable("id") Long id, ModelMap map) {
//        Comment comment = commentRepository.findOne(id);
//        if (!userCanEditComment(comment)) {
//            throw new AccessDeniedException("Acces denied  ne rabotaet");
//        }
//        map.addAttribute("comment", comment);
//        return "comments/edit";
//    }
//    @Test
//    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
//    public String savePost(@ModelAttribute @Valid Comment comment, BindingResult result) {
//        if (result.hasErrors()) {
//            return "posts/edit";
//        }
//        commentService.saveComment(comment);
//
//
//        return "redirect:/posts";
//    }
//
//    @Test
//    private boolean userCanEditComment(Comment comment) {
//        User currentUser = SecurityUtils.getCurrentUser();
//        return currentUser != null && comment.getUser().getId().equals(currentUser.getId());
//    }
}

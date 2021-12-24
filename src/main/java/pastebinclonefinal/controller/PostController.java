package pastebinclonefinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pastebinclonefinal.model.Post;
import pastebinclonefinal.repository.PostRepository;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/")
    public String CreatePost(Model model) {
        model.addAttribute("listPosts", postRepository.findAll());
        return "Post";
    }
    @GetMapping("/AddPost")
    public String addNewPost(Model model) {
        Post post = new Post();
        model.addAttribute("Post", post);
        return "new_post";
    }
    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("Post") Post post) {
        postRepository.save(post);
        return "redirect:/";
    }

    @GetMapping ("/deletePost/{id}")
    public String deletePost(@PathVariable(value = "id") long id) {
        postRepository.deleteById(id);
        return "redirect:/";
    }

}

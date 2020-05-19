package com.javanto.CursoSpringBoot.Controller;
import com.javanto.CursoSpringBoot.Configuration.Page;
import com.javanto.CursoSpringBoot.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class ControllerBasic {

    public List<Post> getPosts(){
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post(1,
                "Als Webentwicklung bezeichnet man die Softwareentwicklung von Webanwendungen, Webservices oder anderer komplexer Websites.",
                "http://localhost:8080/image/post.jpg", new Date(),"Desarrollo Web aleman, Post 1"));
        post.add(new Post(2,
                "Als Webentwicklung bezeichnet man die Softwareentwicklung von Webanwendungen, Webservices oder anderer komplexer Websites.",
                "http://localhost:8080/image/post.jpg", new Date(),"Desarrollo Web aleman Front End"));
        post.add(new Post(3,
                "Als Webentwicklung bezeichnet man die Softwareentwicklung von Webanwendungen, Webservices oder anderer komplexer Websites.",
                "http://localhost:8080/image/post.jpg", new Date(),"Desarrollo Web aleman Bach-end"));
        post.add(new Post(4,
                "Als Webentwicklung bezeichnet man die Softwareentwicklung von Webanwendungen, Webservices oder anderer komplexer Websites.",
                "http://localhost:8080/image/post.jpg", new Date(),"Desarrollo Web aleman UX/UI"));
        return post;
    }


    @GetMapping(path = {"/posts","/"})
    public String saludar(Model model){

        model.addAttribute("posts", this.getPosts());
        return "index";

    }

    @GetMapping(path = {"/post","/post/p/{post}"})
    public ModelAndView getPostIndividual(

            @PathVariable(required = true, name = "post")int id)
            {

                ModelAndView modelAndView = new ModelAndView(Page.POST);
                List<Post> postsFiltrado = this.getPosts()
                                    .stream()
                                    .filter((p)->{
                                        return p.getId() == id;
                                    }).collect(Collectors.toList());

                modelAndView.addObject("post",postsFiltrado.get(0));
                return modelAndView;
    }


    @GetMapping(path = "/postNew")
    public ModelAndView getForm() {

        ModelAndView modelAndView = new ModelAndView("form").addObject("post", new Post());
        return  modelAndView;

    }

    @PostMapping("/addNewPost")
    public String addNewPost(Post post, Model model){

        List<Post> posts = this.getPosts();
        posts.add(post);
        model.addAttribute("pots", posts);

        return "index";

    }


}

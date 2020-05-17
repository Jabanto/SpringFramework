package com.javanto.CursoSpringBoot.Controller;
import com.javanto.CursoSpringBoot.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/home")
public class ControllerBasic {

    public List<Post> getPost(){
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


    @GetMapping(path = {"/post","/"})
    public String saludar(Model model){

        model.addAttribute("posts", this.getPost());
        return "index";

    }

}

package com.Spring.Annotation.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/krm")
public class HomeController {

    @GetMapping("greet")
    public String greet() {
        return "WELCOME TO KRM";
    }

    @GetMapping("/{id}")
    public int getId(@PathVariable int id) {
        return id;
    }
    @PostMapping("/post")
    public String toPostGreet()
    {
        return  "KRM IS BACK ";
    }
    @GetMapping("/r")
    // http://localhost:8080/krm/r?k=Hello
    public String  request(@RequestParam String k )
    {
        return  " KING KISHORE :" + k;
    }


}

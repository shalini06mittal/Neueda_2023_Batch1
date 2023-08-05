package com.boot.rest.SpringBootWebDemo.web01;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * If using @Controller then to create REST API's you need to add @ResponseBody on the methods
 * to return data as a response
 */

/**
 * Ideally there should not be separate paths for respective HTTP methods. The REST URI should not contain verbs in them.
 * Hence if path is http://localhhost:8080/home,
 * then for the verbs/HTTP methods use respective GET/POST/PUT/DELETE annotations
 */
//@Controller // If using @Controller then @ResponseBody is used to create REST API
@RestController // @Controller + @ResponseBody
/**
 * If the /home is common across the mappings then there can be 1 root mapping as follows:
 * Remove the /home mappings from other annotations
 */
@RequestMapping("/home")
// @Tag is used to display name on swagger UI
@Tag(name = "FIRST-CONTROLLER")
public class FirstController {

    public FirstController(){
        System.out.println("First Controller");
    }

    /**
     * @RequestMapping is a general annotation. To restrict access for different HTTP methods,
     * need to add method attribute separately
     * Instead use more composed annotations [@GetMapping, @PostMapping, @PutMapping, @DeleteMapping]
     * for all HTTP methods
     *
     */
    //@RequestMapping(path = "/home/get", method = RequestMethod.GET)

    //@GetMapping("/home/get")

    /**
     * Just use annotations for respective HTTP methods and no need to put verbs within them
     * @return
     */
   // @GetMapping("/home")

    /**
     * Since the class has root mapping, no need of explicit mapping
     */
    @GetMapping
    public @ResponseBody String getPage()
    {
        return "GET ";
    }

    /**
     * Cannot have 2 methods with same path mapping as it causes ambiguity
     * @return
     */
//    @GetMapping("/get")
//    public @ResponseBody String greet()
//    {
//        return "GREET ";
//    }

    //@RequestMapping(path = "/home/post", method = RequestMethod.POST)
    //@PostMapping("/home/post")
    //@PostMapping("/home")
    @PostMapping
    public @ResponseBody String postPage()
    {
        return "POST ";
    }
//    @RequestMapping(path = "/home/put", method = RequestMethod.PUT)
//    @PutMapping("/home/put")
    //@PutMapping("/home")
    @PutMapping
    public @ResponseBody String putPage()
    {
        return "PUT ";
    }
//    @RequestMapping(path = "/home/delete", method = RequestMethod.DELETE)
    //@DeleteMapping("/home/delete")
    //@DeleteMapping("/home")
    @DeleteMapping
    public @ResponseBody String deletePage()
    {
        return "DELETE ";
    }
}

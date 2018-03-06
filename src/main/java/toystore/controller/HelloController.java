package toystore.controller;

import toystore.domain.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/hello/{name}")
    public Hello sayHi(@PathVariable String name) {


        if ("new".equals(name)) {
            System.exit(1);
        }

        Hello hello = new Hello(String.format("Hello %s", name));
        return hello;
    }
}


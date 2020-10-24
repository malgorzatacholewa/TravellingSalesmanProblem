package pl.sda.TravellingSalesmanProblem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public List<String> hello(){
        List<String> list = new ArrayList<>();
        list.add("Hello");
        return list;
    }
}

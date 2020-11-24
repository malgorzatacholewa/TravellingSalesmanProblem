package pl.sda.TravellingSalesmanProblem.controller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping
@Controller
public class PointController {

    @GetMapping("/route")
    public String routeForm (){
        return "routeForm";
    }
}

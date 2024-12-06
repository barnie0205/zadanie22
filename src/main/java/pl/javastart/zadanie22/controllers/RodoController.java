package pl.javastart.zadanie22.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RodoController {

    @GetMapping("/rodo")
    public String rodo() {
        return "rodo";
    }
}
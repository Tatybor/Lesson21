package ru.IT.controller;

import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.IT.DTO.AuthorDTO;
import ru.IT.services.AuthorServiceImpl;

import java.util.List;

@Controller
@AllArgsConstructor
public class AuthorController {
    private final AuthorServiceImpl authorServiceImpl;
@GetMapping("/authors")
    public List<AuthorDTO> getAllAuthors(@RequestParam(required=false) Long id,
                                         @RequestParam (required=false) String name,
                                         @RequestParam (required=false) String surname,
                                         Model model) {
        List <AuthorDTO> authors = authorServiceImpl.getAllAuthors();
        model.addAttribute("authors", authors);
        return authors;
    }
}

package com.example.csis3275_exam.web;

import com.example.csis3275_exam.entities.Salesman;
import com.example.csis3275_exam.repositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SalesmanController {
    @Autowired
    private SalesmanRepository repo;

    @GetMapping(path = "/")
    public String index(Model model) {
        Salesman salesman = new Salesman();

        List<Salesman> salesmanList = repo.findAll();

        model.addAttribute("s", salesman);
        model.addAttribute("list", salesmanList);

        return "index";
    }

    @PostMapping(path = "/save")
    public String save(Model model, @ModelAttribute Salesman salesman, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/";
        }

        repo.save(salesman);

        return "redirect:/";
    }

    @GetMapping(path = "/edit")
    public String edit(Model model) {
        return "redirect:/";
    }

    @GetMapping(path = "/delete")
    public String delete(Model model, @RequestParam(name = "id", defaultValue = "") Long id) {
        repo.deleteById(id);

        return "redirect:/";
    }
}

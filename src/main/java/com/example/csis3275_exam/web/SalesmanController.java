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

// ------ GITHUB ------
// https://github.com/uFloppyDisk/csis3275-final.git

@Controller
public class SalesmanController {
    @Autowired
    private SalesmanRepository salesmanRepository;

    @GetMapping(path = "/")
    public String index(Model model) {
        Salesman salesman = new Salesman();

        List<Salesman> salesmanList = salesmanRepository.findAll();

        model.addAttribute("new", salesman);
        model.addAttribute("list", salesmanList);

        return "index";
    }

    @PostMapping(path = "/save")
    public String save(Model model, @ModelAttribute Salesman salesman, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/";
        }

        salesmanRepository.save(salesman);

        return "redirect:/";
    }

    @GetMapping(path = "/edit")
    public String edit(Model model, @RequestParam(name = "id", defaultValue = "") Long id) {
        Salesman salesman = salesmanRepository.findById(id).orElse(new Salesman());

        model.addAttribute("s", salesman);
        return "edit";
    }

    @GetMapping(path = "/delete")
    public String delete(Model model, @RequestParam(name = "id", defaultValue = "") Long id) {
        salesmanRepository.deleteById(id);

        return "redirect:/";
    }

    @PostMapping(path = "/edit/save")
    public String editSave(Model mode, Salesman salesman) {
        salesmanRepository.save(salesman);

        return "redirect:/";
    }
}

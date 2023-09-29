package com.example.CarCatalog.Controllers;

import com.example.CarCatalog.Models.Cars;
import com.example.CarCatalog.Repository.CarsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {
    @Autowired
    private CarsRepo carsRepo;

    @GetMapping("/home")
    public String Home(Model model) {
        model.addAttribute("title","Главная страница");
        return "home";
    }
    @GetMapping("/home/porsche")
    public String Porsche(Model model) {
       Iterable<Cars> cars = carsRepo.findAll();
       model.addAttribute("cars",cars);
        return "porsche";
    }
    @GetMapping("home/cars-add")
    public String carsAdd(Model model) {
        return "cars-add";
    }
    @PostMapping("/home/cars-add")
    public String CarsAddPost(@RequestParam String brand,@RequestParam String modelcar,@RequestParam String description,Model model) {
        Cars cars = new Cars(brand,modelcar,description);
        carsRepo.save(cars);
        // Iterable<Cars> cars = carsRepo.findAll();
        return "redirect:/home";
    }
    @GetMapping("home/porsche/{id}")
    public String porsche (@PathVariable(value = "id") Long id, Model model) {
        if(!carsRepo.existsById(id)){
            return "redirect:/home";
        }
        Optional<Cars> cars = carsRepo.findById(id);
        ArrayList<Cars> res = new ArrayList<>();
        cars.ifPresent(res::add);
        model.addAttribute("cars",res);
        return "carPost";

        // Iterable<Cars> cars = carsRepo.findAll();



    }

}
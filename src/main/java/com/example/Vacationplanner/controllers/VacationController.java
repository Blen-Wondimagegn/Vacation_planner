package com.example.Vacation.Planner.controllers;
import ch.qos.logback.core.model.Model;
import com.example.Vacation.Planner.model.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vacations")
public class VacationController {
        @GetMapping("/home")
        public String home()  {
            return "home"; // This will return the "home.html" or "home.jsp" view
        }
    @Autowired
    private ProductService productService;


    @GetMapping
    public String getAllProducts(Model model) {
        List<Vacation> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "vacation-list";
    }

    @GetMapping("/new")
    public String showCreateProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }


//    @GetMapping("/edit/{id}")
//    public String showEditProductForm(@PathVariable Long id, Model model) {
//        Optional<Product> optionalProduct = productService.getProductById(id);
//        if (optionalProduct.isPresent()) {
//            model.addAttribute("product", optionalProduct.get());
//        } else {
//            return "redirect:/products";
//        }
//        return "product-form";
//    }
//
//    @PostMapping("/save")
//    public String saveProduct(@ModelAttribute("product") Product product) {
//        if (product.getId() != null) {
//            productService.updateProduct(product.getId(), product);
//        } else {
//            productService.createProduct(product);
//        }
//        return "redirect:/products";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable Long id) {
//        productService.deleteProduct(id);
//        return "redirect:/products";
//    }

}

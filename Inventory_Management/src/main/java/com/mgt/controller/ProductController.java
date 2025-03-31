package com.mgt.controller;

import com.mgt.model.Product;
import com.mgt.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {

        boolean status = productService.addPro(product);
        if (status) {
            return "Product added successfully.";
        } else {
            return "Failed to add product. Please try again.";
        }
    }

    @GetMapping("/getProduct")
    public List<Product> getProduct() {

        return productService.getAllPro();
    }

    @PutMapping("/updateProduct")
    public String updateProduct(@RequestBody Product product) {
        boolean status = productService.updatePro(product);
        if (status) {
            return "Product Update Successfully";
        } else {
            return "Failed to update product. Please try again.";
        }
    }

    @DeleteMapping("/deleteProduct/{product_id}")
    public String deleteProduct(@PathVariable Integer product_id) {

        boolean status = productService.deletePro(product_id);

        if (status) {
            return "Product Deleted Successfully !!";
        } else {
            return "Failed to delete product. Please try again.";
        }
    }
}

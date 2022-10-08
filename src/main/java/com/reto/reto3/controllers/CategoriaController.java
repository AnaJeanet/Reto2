package com.reto.reto3.controllers;

import com.reto.reto3.dto.Category;
import com.reto.reto3.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Category")
public class CategoriaController {

    private CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(path = "/all")
    public List<Category> getAllCategories(){
        return categoriaService.getAllCategories();
    }

    @PostMapping(path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCategory(@RequestBody Category category){
        categoriaService.saveCategory(category);
    }

    @GetMapping("/(id)")
    public Optional<Category> getCategory(@PathVariable("id") int idCategory){
        return categoriaService.getCategory(idCategory);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoriaService.update(category);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return categoriaService.delete(id);
    }

}

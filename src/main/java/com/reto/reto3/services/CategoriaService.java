package com.reto.reto3.services;

import com.reto.reto3.dto.Category;
import com.reto.reto3.dto.Motorcycle;
import com.reto.reto3.entities.Categoria;
import com.reto.reto3.entities.Motocicleta;
import com.reto.reto3.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Category> getAllCategories(){
        List<Category> retorno = new ArrayList<>();
        Iterable<Categoria> categorias = categoriaRepository.findAll();
        for (Categoria categoria : categorias) {
            Category category = new Category();
            category.setId(categoria.getId());
            category.setDescription(categoria.getDescripcion());
            category.setName(categoria.getNombre());
            List<Motocicleta> motos = categoria.getMotocicletas();
            List<Motorcycle> motorcycleList = new ArrayList<>();
            for (Motocicleta moto : motos) {
                Motorcycle motorcycle = new Motorcycle();
                motorcycle.setId(moto.getId());
                motorcycle.setBrand(moto.getMarca());
                motorcycle.setDescription(moto.getDescripcion());
                motorcycle.setYear(moto.getAnio());
                motorcycle.setName(moto.getNombre());
                motorcycleList.add(motorcycle);
            }
            category.setMotorbikes(motorcycleList);
            retorno.add(category);
        }
        return retorno;
    }

    public void saveCategory(Category category) {
        Categoria categoria = new Categoria();
        categoria.setDescripcion(category.getDescription());
        categoria.setNombre(category.getName());
        categoriaRepository.save(categoria);
    }

    public String deleteById(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()){
            categoriaRepository.delete(categoria.get());
            return "";
        }
        return "Category not found";
    }

    public boolean updateCategory(Category category) {
        Optional<Categoria> categoriaBD = categoriaRepository.findById(category.getId());
        if (categoriaBD.isPresent()){
            Categoria categoria = new Categoria();
            categoria.setId(category.getId());
            categoria.setDescripcion(category.getDescription());
            categoria.setNombre(category.getName());
            categoriaRepository.save(categoria);
            return true;
        }
        return false;

    }
}

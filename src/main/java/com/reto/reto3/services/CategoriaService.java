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
import java.util.stream.Collectors;
//este se agregó
import java.util.Optional

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

    

//Desde aquí agregué...

    public Category update(Category p){
        if(p.getId()!=null){
            Optional<Category> q = categoriaRepository.getCategory(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                categoriaRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Category>p= categoriaRepository.getCategory(id);
        if(p.isPresent()){
            categoriaRepository.delete(p.get());
            flag=true;
        }
        return flag;
}

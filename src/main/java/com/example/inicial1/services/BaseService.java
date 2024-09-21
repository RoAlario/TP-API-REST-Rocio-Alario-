package com.example.inicial1.services;

import java.util.List;

public interface BaseService <E>{
    //Lista de todas las personas que tenemos en la base de datos
    public List<E> findAll() throws Exception;
    //Busca por ID a una persona o entidad
    public E findById(Long id) throws Exception;
    //Crear una nueva entidad
    public E save(E entity) throws Exception;
    //Actualiza una entidad
    public E update(Long id,E entity) throws Exception;
    //Elimina un registro de la base de datos
    public boolean delete(Long id) throws Exception;
}

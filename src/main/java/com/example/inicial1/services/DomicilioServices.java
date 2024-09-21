package com.example.inicial1.services;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.repositories.DomicilioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServices implements BaseService<Domicilio> {

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    @Transactional
    public List<Domicilio> findAll() throws Exception {
        try {
            return domicilioRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio findById(Long id) throws Exception {
        try {
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            return entityOptional.orElseThrow(() -> new Exception("Domicilio no encontrado"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio save(Domicilio entity) throws Exception {
        try {
            return domicilioRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio update(Long id, Domicilio entity) throws Exception {
        try {
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            Domicilio domicilio = entityOptional.orElseThrow(() -> new Exception("Domicilio no encontrado"));
            // Aquí puedes actualizar los campos del domicilio según sea necesario
            return domicilioRepository.save(domicilio);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (domicilioRepository.existsById(id)) {
                domicilioRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("Domicilio no encontrado");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

package dochef.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dochef.model.Receta;
import dochef.repository.RecetaRepository;


@Service
@Transactional
public class RecetaService {

	
    @Autowired
    private RecetaRepository recetaRepository;
    
    @Transactional(readOnly = true)
    public List<Receta> findByAll(){
    	return (List<Receta>) recetaRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Receta findById(Integer id){
    	return recetaRepository.findOne(id);
    }
}

package dochef.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dochef.model.Consejo;
import dochef.repository.ConsejoRepository;


@Service
@Transactional
public class ConsejoService {

    @Autowired
    private ConsejoRepository consejoRepository;
    
    @Transactional(readOnly = true)
    public List<Consejo> findByAll(){
    	return (List<Consejo>) consejoRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Consejo findById(Integer id){
    	return consejoRepository.findOne(id);
    }
}

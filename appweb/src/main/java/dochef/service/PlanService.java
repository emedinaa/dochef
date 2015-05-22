package dochef.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dochef.model.Plan;
import dochef.repository.PlanRepository;

@Service
@Transactional
public class PlanService {

    @Autowired
    private PlanRepository planRepository;
    
    @Transactional(readOnly = true)
    public List<Plan> findByAll(){
    	return (List<Plan>) planRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Plan findById(Integer id){
    	return planRepository.findOne(id);
    }
}

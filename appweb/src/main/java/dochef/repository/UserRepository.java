package dochef.repository;

import org.springframework.data.repository.CrudRepository;

import dochef.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    
    
}

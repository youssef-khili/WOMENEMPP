package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service("IUserService")
public class UserServiceImpl implements IUserService{

    @Autowired
    UserRepository userrepo;

    @Override
    public User addUser(User u) {
        return userrepo.save(u);
    }
}

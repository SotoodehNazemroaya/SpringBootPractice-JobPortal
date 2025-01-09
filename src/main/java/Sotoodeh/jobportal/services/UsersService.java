package Sotoodeh.jobportal.services;

import Sotoodeh.jobportal.Entity.Users;
import Sotoodeh.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

@Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users addNew(Users user){
    user.setActive(true);
    user.setRegistrationDate(new Date(System.currentTimeMillis()));
    return usersRepository.save(user);

    }

    public Optional<Users> getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }
}

package Sotoodeh.jobportal.services;

import Sotoodeh.jobportal.Entity.JobSeekerProfile;
import Sotoodeh.jobportal.Entity.RecruiterProfile;
import Sotoodeh.jobportal.Entity.Users;
import Sotoodeh.jobportal.repository.JobSeekerProfileRepository;
import Sotoodeh.jobportal.repository.RecruiterProfileRepository;
import Sotoodeh.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

@Autowired
    public UsersService(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository) {
        this.usersRepository = usersRepository;
    this.jobSeekerProfileRepository = jobSeekerProfileRepository;
    this.recruiterProfileRepository = recruiterProfileRepository;
}

    public Users addNew(Users user){
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
       Users savedUser = usersRepository.save(user);
        int userTypeId = savedUser.getUserTypeId().getUserTypeId();
        if(userTypeId == 1){
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        }else{
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }

        return savedUser;

    }

    public Optional<Users> getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }
}

package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import recipes.entity.User;
import recipes.entity.UserDetailsImpl;
import recipes.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Not found: " + email);
        }

        return new UserDetailsImpl(user);
    }

    // Methods related to UserService interface

    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    public void save(User user) {
        userRepo.save(user);
    }

    //boolean existsByEmail(String email){
    //    return true;
    //}

}

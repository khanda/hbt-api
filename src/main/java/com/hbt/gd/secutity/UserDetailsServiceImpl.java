package com.hbt.gd.secutity;

/**
 * Created by quyen on 03/02/2018.
 */

import com.hbt.gd.entity.CoreUser;
import com.hbt.gd.reposity.CoreUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private CoreUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(CoreUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CoreUser applicationUser = applicationUserRepository.findUserByUserName(username);
        if (applicationUser == null || applicationUser.getId()== null) {
            throw new UsernameNotFoundException(username);
        }

        User2 user2 = new User2(applicationUser.getUserName(), applicationUser.getPassword(), emptyList());
        user2.setRole(applicationUser.getUserRole().getName());
        user2.setId(applicationUser.getId());
        return user2;
    }
}
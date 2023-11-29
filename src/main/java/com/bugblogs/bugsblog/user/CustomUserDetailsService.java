package com.bugblogs.bugsblog.user;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bugblogs.bugsblog.types.UserRole;

public class CustomUserDetailsService implements UserDetailsService {

    private IUserRepository userRepository;

    public CustomUserDetailsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> isUser = userRepository.findByEmail(email);

        if (isUser.isPresent()) {
            User user = isUser.get();

            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(), convertRolesToAuthorities(user.getRole()));
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

    }

    private Set<GrantedAuthority> convertRolesToAuthorities(UserRole userRole) {
        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.name()));

        return authorities;
    }

}

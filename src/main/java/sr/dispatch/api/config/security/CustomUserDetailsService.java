package sr.dispatch.api.config.security;

import sr.dispatch.api.model.Account;
import sr.dispatch.api.model.Role;
import sr.dispatch.api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/* * * @author Clint Atmosoerodjo #commander *  */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            // Not found...
            throw new UsernameNotFoundException(
                    "User " + username + " not found.");
        }

        if (account.getRoles() == null || account.getRoles().isEmpty()) {
            // No Roles assigned to user...
            throw new UsernameNotFoundException("User not authorized.");
        }


        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (Role role : account.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        User userDetails = new User(account.getUsername(),
                account.getPassword(), account.isEnabled(),
                !account.isExpired(), !account.isCredentialsexpired(),
                !account.isLocked(), grantedAuthorities);

        return userDetails;
    }

    private final static class UserRepositoryUserDetails extends Account implements UserDetails {

        private static final long serialVersionUID = 1L;



        private UserRepositoryUserDetails(Account user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            for (Role role : getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return grantedAuthorities;
        }

        @Override
        public String getUsername() {
            return getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return !isExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
            return !isLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return !isCredentialsexpired();
        }

        @Override
        public boolean isEnabled() {
            return isEnabled();
        }

        @Override
        public Set<Role> getRoles() {
            return getRoles();
        }
    }
}

package sr.dispatch.api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sr.dispatch.api.config.security.CustomUserDetailsService;

/* * * @author Clint Atmosoerodjo #commander *  */

@Component
public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    /**
     * The Logger for this class.
     */

    /**
     * A Spring Security UserDetailsService implementation based upon the
     * Account entity model.
     */
    @Autowired
    private CustomUserDetailsService userDetailsService;

    /**
     * A PasswordEncoder instance to hash clear test password values.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken token) throws AuthenticationException {
        logger.debug("> additionalAuthenticationChecks");

        if (token.getCredentials() == null || userDetails.getPassword() == null) {
            throw new BadCredentialsException("Credentials may not be null.");
        }

        if (!passwordEncoder.matches((String) token.getCredentials(), userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid credentials.");
        }

        logger.debug("< additionalAuthenticationChecks");
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken token) throws AuthenticationException {
        logger.debug("> retrieveUser");

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        logger.debug("< retrieveUser");
        return userDetails;
    }



}
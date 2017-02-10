package sr.dispatch.api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import sr.dispatch.api.model.Role;
import sr.dispatch.api.service.RoleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Autowired
    private RoleService roleService;

    @Override
    public OAuth2AccessToken enhance(
     OAuth2AccessToken accessToken,
     OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("username", authentication.getName());
        List<Role> roles = new ArrayList<>();

        for (GrantedAuthority authority :authentication.getAuthorities()) {
            if(roleService.findByName(authority.getAuthority()) != null){
                roles.add(roleService.findByName(authority.getAuthority()));
            }
        }

        additionalInfo.put("roles", roles);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
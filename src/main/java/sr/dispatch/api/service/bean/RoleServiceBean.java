package sr.dispatch.api.service.bean;


import sr.dispatch.api.model.Role;
import sr.dispatch.api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sr.dispatch.api.service.RoleService;

/**
 * Manage the data from database from Role table user
 * @author catmosoerodjo
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RoleServiceBean implements RoleService {


    /**
     * The Spring Data repository for Account entities.
     */
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Get by id
     * @param id
     * @return
     */
    @Override
    public Role findById(Long id) {
        Role role = roleRepository.findOne(id);
        return role;
    }

    /**
     * File Role by code
     * @param name - the code of the role
     * @return Role object
     */
    @Override
    public Role findByName(String name) {
       return roleRepository.findByName(name);
    }
}

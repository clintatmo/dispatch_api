package sr.dispatch.api.service;


import sr.dispatch.api.model.Role;

/**

 * @author catmosoerodjo
 *
 */
public interface RoleService {

    Role findById(Long id);

    Role findByCode(String code);

}

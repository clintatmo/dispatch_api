package sr.dispatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sr.dispatch.api.model.Privilege;

/**
 * Created by qualogy-mac on 2/10/17.
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findById(Long id);
}

package sr.dispatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sr.dispatch.api.model.Module;

/**
 * Created by catmosoerodjo on 2/13/17.
 */

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}

package sr.dispatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sr.dispatch.api.model.Module;

import java.util.List;

/**
 * Created by catmosoerodjo on 2/13/17.
 */

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    @Query("SELECT a FROM Module a WHERE a.deleted = 0")
    List<Module> findActiveModules();

}

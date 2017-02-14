package sr.dispatch.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sr.dispatch.api.model.Module;

import java.util.List;

/**
 * Created by catmosoerodjo on 2/13/17.
 */
public interface ModuleService {

    List<Module> findAllModules();

    Page<Module> findAllModulesByPage(Pageable pageable);
}

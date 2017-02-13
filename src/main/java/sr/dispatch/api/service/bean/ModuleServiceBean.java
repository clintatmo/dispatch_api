package sr.dispatch.api.service.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;
import sr.dispatch.api.model.Module;
import sr.dispatch.api.repository.ModuleRepository;
import sr.dispatch.api.service.ModuleService;

import java.util.List;

/**
 * Created by catmosoerodjo on 2/13/17.
 */
@Service
public class ModuleServiceBean implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    @PostFilter("filterObject.deleted() == false")
    public List<Module> findAllModules() {
        return moduleRepository.findAll();
    }
}

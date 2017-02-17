package sr.dispatch.api.service;

import sr.dispatch.api.model.Module;

import java.util.List;

/**
 * Created by catmosoerodjo on 2/13/17.
 */
public interface ModuleService {

    List<Module> findAllModules();


    Module findById(long id);

    void updateModule(Module module);
}

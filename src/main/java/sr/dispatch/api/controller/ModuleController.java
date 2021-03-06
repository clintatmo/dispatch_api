package sr.dispatch.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sr.dispatch.api.dto.ModuleDto;
import sr.dispatch.api.model.Module;
import sr.dispatch.api.service.ModuleService;

import java.util.List;

/**
 * Created by catmosoerodjo on 2/13/17.
 */
@RestController
@RequestMapping(value = "/api/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @Autowired
    private ModelMapper modelMapper;

    //-------------------Retrieve All Modules--------------------------------------------------------

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Module>> listAllModules() {
        List<Module> modules = moduleService.findAllActiveModules();
        if(modules.isEmpty()){
            return new ResponseEntity<List<Module>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Module>>(modules, HttpStatus.OK);
    }

    //-------------------Retrieve All Modules With Pagination--------------------------------------------------------

//    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Page<Module>> listAllModules(Pageable pageable) {
//        Page<Module> modules = moduleService.findAllModulesByPage(pageable);
//        return new ResponseEntity<Page<Module>>(modules, HttpStatus.OK);
//    }


    //-------------------Retrieve Single Module--------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> getModule(@PathVariable("id") long id) {
        System.out.println("Fetching Module with id " + id);
        Module module = moduleService.findById(id);
        if (module == null) {
            System.out.println("Module with id " + id + " not found");
            return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Module>(module, HttpStatus.OK);
    }



    //-------------------Create a Module--------------------------------------------------------

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createModule(@RequestBody ModuleDto moduleDto) {
        System.out.println("Creating Module with name " + moduleDto.getName());

        if (moduleDto.getId() != null) {
            System.out.println("A Module with id " + moduleDto.getId() + " already exist");
            return new ResponseEntity<String>("A Module with id " + moduleDto.getId() + " already exist", HttpStatus.CONFLICT);
        }

        moduleService.updateModule(modelMapper.map(moduleDto, Module.class));

        return new ResponseEntity<String>("Saved!", HttpStatus.CREATED);
    }


    //------------------- Update a Module --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> updateModule(@PathVariable("id") long id, @RequestBody Module module) {
        System.out.println("Updating Module " + id);

        Module currentModule = moduleService.findById(id);

        if (currentModule==null) {
            System.out.println("Module with id " + id + " not found");
            return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
        }

        moduleService.updateModule(module);
        return new ResponseEntity<Module>(module, HttpStatus.OK);
    }

    //------------------- Delete a Module --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Module> deleteModule(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Module with id " + id);

        Module module = moduleService.findById(id);
        if (module == null) {
            System.out.println("Unable to delete. Module with id " + id + " not found");
            return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
        }

        module.setDeleted(true);
        moduleService.updateModule(module);
        return new ResponseEntity<Module>(HttpStatus.NO_CONTENT);
    }


    //------------------- Delete All Modules --------------------------------------------------------

//    @RequestMapping(value = "", method = RequestMethod.DELETE)
//    public ResponseEntity<Module> deleteAllModules() {
//        System.out.println("Deleting All Modules");
//
//        Moduleservice.deleteAllModules();
//        return new ResponseEntity<Module>(HttpStatus.NO_CONTENT);
//    }
}

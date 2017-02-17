package sr.dispatch.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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

    //-------------------Retrieve All Persons--------------------------------------------------------

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Module>> listAllModules() {
        List<Module> modules = moduleService.findAllActiveModules();
        if(modules.isEmpty()){
            return new ResponseEntity<List<Module>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Module>>(modules, HttpStatus.OK);
    }

    //-------------------Retrieve All Persons With Pagination--------------------------------------------------------

//    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Page<Module>> listAllModules(Pageable pageable) {
//        Page<Module> modules = moduleService.findAllModulesByPage(pageable);
//        return new ResponseEntity<Page<Module>>(modules, HttpStatus.OK);
//    }


    //-------------------Retrieve Single Person--------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> getPerson(@PathVariable("id") long id) {
        System.out.println("Fetching Person with id " + id);
        Module module = moduleService.findById(id);
        if (module == null) {
            System.out.println("Module with id " + id + " not found");
            return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Module>(module, HttpStatus.OK);
    }



    //-------------------Create a Person--------------------------------------------------------

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> createPerson(@RequestBody Module module) {
        System.out.println("Creating Module with name " + module.getName());

        if (module.getId() == null) {
            System.out.println("A Module with id " + module.getId() + " already exist");
            return new ResponseEntity<Module>(HttpStatus.CONFLICT);
        }
        moduleService.updateModule(module);

        return new ResponseEntity<Module>(module, HttpStatus.CREATED);
    }


    //------------------- Update a Person --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> updatePerson(@PathVariable("id") long id, @RequestBody Module module) {
        System.out.println("Updating Module " + id);

        Module currentModule = moduleService.findById(id);

        if (currentModule==null) {
            System.out.println("Module with id " + id + " not found");
            return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
        }

        moduleService.updateModule(module);
        return new ResponseEntity<Module>(module, HttpStatus.OK);
    }

    //------------------- Delete a Person --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Module> deletePerson(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Module with id " + id);

        Module module = moduleService.findById(id);
        if (module == null) {
            System.out.println("Unable to delete. Person with id " + id + " not found");
            return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
        }

        module.setDeleted(true);
        moduleService.updateModule(module);
        return new ResponseEntity<Module>(HttpStatus.NO_CONTENT);
    }


    //------------------- Delete All Persons --------------------------------------------------------

//    @RequestMapping(value = "", method = RequestMethod.DELETE)
//    public ResponseEntity<Person> deleteAllPersons() {
//        System.out.println("Deleting All Persons");
//
//        personService.deleteAllPersons();
//        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
//    }
}

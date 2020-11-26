package nl.hva.aquadisbackend.web;

import nl.hva.aquadisbackend.models.DriverEntity;
import nl.hva.aquadisbackend.repo.DriverRepository;
import nl.hva.aquadisbackend.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="drivers")
public class DriverEntityController {
    DriverRepository driverRepository;
    DriverService driverService;

    protected DriverEntityController(){}

    @Autowired
    public DriverEntityController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    /*
    Creates a new driver in the database
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path="/add/{id}/{firstname}/{lastname}/{cost}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDriver(@PathVariable(value="firstname") String firstname,@PathVariable(value="lastname")
            String lastname,@PathVariable(value="cost") Integer cost,@PathVariable(value="id") Integer id) {
        this.driverService = new DriverService(this.driverRepository);
        driverService.createDriver(id,firstname,lastname,cost);
    }

    /*
    Gets all the drivers form the database
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<DriverEntity> getDrivers() {
        return driverRepository.findAll();
    }

    /*
    gets a specific driver based on the id
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path="/{idDriver}")
    public DriverEntity getDriverById(@PathVariable(value = "idDriver") int idDriver) {
        return driverRepository.findByIddriver(idDriver);
    }
}

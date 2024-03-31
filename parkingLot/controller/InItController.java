package projects.parkingLot.controller;

import projects.parkingLot.service.InitializationService;

public class InItController {
    private InitializationService initializationService;

    public InItController(InitializationService initializationService) {
        this.initializationService = initializationService;
    }
    public void inIt()
    {
        initializationService.inIt();
    }
}

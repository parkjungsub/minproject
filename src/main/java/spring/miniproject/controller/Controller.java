package spring.miniproject.controller;

import org.springframework.web.bind.annotation.*;
import spring.miniproject.dto.RequsetDto;
import spring.miniproject.service.Service;

@RestController
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/api/signup")
    public RequsetDto signup(@RequestBody RequsetDto requsetDto) {
        return service.join(requsetDto);
    }

    @PostMapping("/api/login")
    public RequsetDto login(@RequestBody RequsetDto requsetDto){
        RequsetDto dto = service.verification(requsetDto);

        return dto;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody RequsetDto requsetDto){
        service.delete(requsetDto);
    }
}

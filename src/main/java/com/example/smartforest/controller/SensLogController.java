package com.example.smartforest.controller;

import com.example.smartforest.service.SensLogService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/senslog")
public class SensLogController {
    private final SensLogService service;
    public SensLogController(SensLogService service) { this.service = service; }
    @GetMapping(value = "/units", produces = MediaType.APPLICATION_JSON_VALUE)
    public String units() { return service.get("/rest/physicalunits"); }
    @GetMapping(value = "/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public String latest() { return service.get("/rest/observations?user=29&group=vestiena"); }
    @GetMapping(value = "/observations", produces = MediaType.APPLICATION_JSON_VALUE)
    public String observations(@RequestParam String from, @RequestParam String to) { return service.get("/rest/observations?user=29&group=vestiena&from=" + from + "&to=" + to); }
    @GetMapping(value = "/observation", produces = MediaType.APPLICATION_JSON_VALUE)
    public String observation(@RequestParam String id) { return service.get("/rest/observations/" + id); }
}

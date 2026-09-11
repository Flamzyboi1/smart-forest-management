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
    public String units() { return service.get("/unit?user_id=29"); }
    @GetMapping(value = "/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public String latest() { return service.get("/observation/last?group_name=vestiena"); }
    @GetMapping(value = "/observations", produces = MediaType.APPLICATION_JSON_VALUE)
    public String observations(@RequestParam(required = false) String unitId, @RequestParam(required = false) String from, @RequestParam(required = false) String to, @RequestParam(required = false) String sensorId) {
        StringBuilder path = new StringBuilder("/observation?");
        if (unitId != null && !unitId.isBlank()) path.append("unit_id=").append(unitId).append('&');
        if (from != null && !from.isBlank()) path.append("from_time=").append(from).append('&');
        if (to != null && !to.isBlank()) path.append("to_time=").append(to).append('&');
        if (sensorId != null && !sensorId.isBlank()) path.append("sensor_id=").append(sensorId).append('&');
        if (path.charAt(path.length()-1) == '&' || path.charAt(path.length()-1) == '?') path.deleteCharAt(path.length()-1);
        return service.get(path.toString());
    }
}

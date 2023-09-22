package com.esprit.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestAPI {

    private String hello = "Hello I'm Job";

    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }

    @Autowired
    private JobService jobService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.AddJob(job), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Job> updateJob(@PathVariable(value = "id") int id,
                                         @RequestBody Job job) {
        return new ResponseEntity<>(jobService.updateJob(id, job),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteJob(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(jobService.deleteJob(id), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Job>> getJob() {
        List<Job> candidat = jobService.getAllJob();
        if (candidat != null) {
            return new ResponseEntity<>(candidat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

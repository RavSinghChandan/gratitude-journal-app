package com.second.week.journal.controller;


import com.second.week.journal.entity.GratitudeEntry;
import com.second.week.journal.service.GratitudeEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/journal")
@CrossOrigin(origins = "*")
public class GratitudeJournalController {
    @Autowired
    private GratitudeEntryService service;

    public GratitudeJournalController(GratitudeEntryService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<GratitudeEntry> createEntry(@RequestBody Map<String,String> payload){
        String content = payload.get("content");
        if(content == null || content.trim().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
       return ResponseEntity.status(201).body(service.createEntry(content));
    }
    @GetMapping("/allEntries")
    public List<GratitudeEntry> getAllEntries(){
        return service.getAllEntries();
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Void> deleteEntry(@PathVariable Long id){
        service.deleteEntry(id);
        return  ResponseEntity.noContent().build();
    }
}

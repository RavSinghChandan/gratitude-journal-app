package com.second.week.journal.service;

import com.second.week.journal.entity.GratitudeEntry;
import com.second.week.journal.repository.GratitudeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GratitudeEntryServiceImpl implements GratitudeEntryService{

    @Autowired
    private GratitudeEntryRepository repository;

    public GratitudeEntryServiceImpl(GratitudeEntryRepository repository) {
        this.repository = repository;
    }

    @Override

    public GratitudeEntry createEntry(String content) {
        return repository.save(new GratitudeEntry(content));
    }

    @Override
    public List<GratitudeEntry> getAllEntries() {
        return repository.findAll();
    }

    @Override
    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}

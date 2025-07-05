package com.second.week.journal.service;

import com.second.week.journal.entity.GratitudeEntry;

import java.util.List;

public interface GratitudeEntryService {
    public GratitudeEntry createEntry(String content);
    public List<GratitudeEntry> getAllEntries();
    public void deleteEntry(Long id);
}

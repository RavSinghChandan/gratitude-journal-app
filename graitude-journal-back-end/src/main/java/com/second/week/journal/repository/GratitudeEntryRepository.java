package com.second.week.journal.repository;

import com.second.week.journal.entity.GratitudeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GratitudeEntryRepository extends JpaRepository<GratitudeEntry,Long> {
}

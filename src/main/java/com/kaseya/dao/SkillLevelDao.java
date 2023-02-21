package com.kaseya.dao;

import com.kaseya.beans.SkillLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillLevelDao extends JpaRepository<SkillLevel, UUID> {
    List<SkillLevel> findAll();


}

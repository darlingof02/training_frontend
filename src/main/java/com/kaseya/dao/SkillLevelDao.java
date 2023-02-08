package com.kaseya.dao;

import com.kaseya.beans.SkillLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SkillLevelDao extends JpaRepository<SkillLevel, UUID> {
    List<SkillLevel> findAll();
}

package com.kaseya.controllers;

import com.kaseya.beans.SkillLevel;
import com.kaseya.service.SkillLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/skillLevel")
public class SkillController {

    @Autowired
    SkillLevelService skillLevelService;

    @PostMapping
    @CacheEvict(value = "skills", allEntries = true)
    public UUID addANewSkill(@RequestBody SkillLevel skillLevel) {
        SkillLevel skillLevel1 = skillLevelService.addANewSkillLevel(skillLevel);
        return skillLevel1.getSkillLevelID();
    }

    @GetMapping
    @Cacheable(value = "skills")
    public List<SkillLevel> getAllSkill() {
        return skillLevelService.getAllSkillLevel();
    }
}

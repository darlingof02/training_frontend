package com.kaseya.service;

import com.kaseya.beans.SkillLevel;
import com.kaseya.dao.SkillLevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillLevelService {
    @Autowired
    private SkillLevelDao skillLevelDao;

    public SkillLevel addANewSkillLevel(SkillLevel skillLevel) {
        SkillLevel skillLevel1 = skillLevelDao.save(skillLevel);
        return skillLevel1;
    }

    public List<SkillLevel> getAllSkillLevel() {
        return skillLevelDao.findAll();
    }
}

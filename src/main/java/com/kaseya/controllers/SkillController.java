package com.kaseya.controllers;

import com.kaseya.beans.Employee;
import com.kaseya.beans.SkillLevel;
import com.kaseya.service.SkillLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/skillLevel")
public class SkillController {

    @Autowired
    SkillLevelService skillLevelService;
    @PostMapping
    public UUID addANewSkill(@RequestBody SkillLevel skillLevel) {

//        Employee employee1 = employeeService.addNewEmployee(employee);
//        return employee1.getEmployeeID();
        SkillLevel skillLevel1 = skillLevelService.addANewSkillLevel(skillLevel);
        return skillLevel1.getSkillLevelID();
    }

    @GetMapping
    public List<SkillLevel> getAllSkill() {
        return skillLevelService.getAllSkillLevel();
    }
}

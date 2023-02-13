package com.kaseya.beans;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "kaseyatraining.skill_level")
public class SkillLevel implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
//    @SequenceGenerator(name = "SEQ", sequenceName = "CCGG_USER_SEQ")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "BINARY(16)")
    private UUID skillLevelID;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_description")
    private String skillDescription;


    public UUID getSkillLevelID() {
        return skillLevelID;
    }

    public void setSkillLevelID(UUID skillLevelID) {
        this.skillLevelID = skillLevelID;
    }

    public SkillLevel(String skillName, String skillDescription) {
        this.skillName = skillName;
        this.skillDescription = skillDescription;
    }

    public SkillLevel() {

    }



    public String getSkillName() {
        return skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }



    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    @Override
    public String toString() {
        return "SkillLevel{" +
                "skillLevelID=" + skillLevelID +
                ", skillName='" + skillName + '\'' +
                ", skillDescription='" + skillDescription + '\'' +
                '}';
    }
}


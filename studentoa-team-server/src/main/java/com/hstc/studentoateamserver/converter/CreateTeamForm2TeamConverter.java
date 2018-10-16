package com.hstc.studentoateamserver.converter;

import com.hstc.studentoateamserver.form.CreateTeamForm;
import com.hstc.studentoateamserver.pojo.Team;
import com.hstc.studentoateamserver.util.KeyUtil;
import org.springframework.beans.BeanUtils;

public class CreateTeamForm2TeamConverter {
    public static Team convert(CreateTeamForm createTeamForm){
        Team team = new Team();
        BeanUtils.copyProperties(createTeamForm, team);
        team.setId(KeyUtil.genUniqueKey());

        return team;
    }
}

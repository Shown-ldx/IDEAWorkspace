package com.hstc.studentoateamserver.service.impl;

import com.hstc.studentoateamserver.mapper.TeamMapper;
import com.hstc.studentoateamserver.pojo.Team;
import com.hstc.studentoateamserver.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public Team addTeam(Team team) {
        Integer result = teamMapper.addTeam(team);
        if (result >= 1) return team;
        return null;
    }
}

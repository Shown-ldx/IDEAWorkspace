package com.hstc.studentoateamserver.service.impl;

import com.hstc.studentoateamserver.pojo.Team;
import com.hstc.studentoateamserver.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TeamServiceImplTest {
    @Autowired
    private TeamService teamService;

    @Test
    public void addTeam() {
        Team team = new Team();
        team.setId("03");
        team.setDescription("暂无描述");
        team.setTaskname("大任务");
        team.setUserEmail("Ldixing@163.com");
        team.setStartTime(new Date(2018, 11, 1));
        team.setEndTime(new Date(2018, 12, 1));
        Team result = teamService.addTeam(team);
        Assert.assertEquals(result.getId(), team.getId());
    }
}
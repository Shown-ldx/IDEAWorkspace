package com.hstc.studentoateamserver.mapper;

import com.hstc.studentoateamserver.pojo.Team;
import lombok.extern.slf4j.Slf4j;
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
public class TeamMapperTest {
    @Autowired
    private TeamMapper teamMapper;

    @Test
    public void addTeam() {
        Team team = new Team();
        team.setId("02");
        team.setDescription("暂无描述");
        team.setTaskname("大任务");
        team.setUserEmail("Ldixing@163.com");
        team.setStartTime(new Date(2018, 11, 1));
        team.setEndTime(new Date(2018, 12, 1));
        Integer result = teamMapper.addTeam(team);
        log.error(result.toString());
    }
}
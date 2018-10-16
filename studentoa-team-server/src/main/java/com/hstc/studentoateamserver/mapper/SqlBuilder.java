package com.hstc.studentoateamserver.mapper;

import com.hstc.studentoateamserver.pojo.Team;
import org.apache.ibatis.annotations.Param;

public class SqlBuilder {
    public String addTeam(@Param("team") Team team){
        String sql = "insert into team(id, taskname, progress, substack_number, user_email, description, status, start_time, end_time)"
                + "values(#{team.id}, #{team.taskname}, #{team.progress}, #{team.substackNumber}, #{team.userEmail}, "
                + "#{team.description}, #{team.status}, #{team.startTime}, #{team.endTime})";
        return sql;
    }
}

package com.hstc.studentoateamserver.mapper;

import com.hstc.studentoateamserver.pojo.Team;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

public interface TeamMapper {

    @InsertProvider(type = SqlBuilder.class, method = "addTeam")
    public Team addTeam(@Param("team") Team team);

    //根据Email查找团队列表
    //根据团队id查找任务详情
    //更新团队任务
    //删除团队任务
}

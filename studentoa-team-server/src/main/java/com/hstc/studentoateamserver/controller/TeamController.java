package com.hstc.studentoateamserver.controller;

import com.google.gson.Gson;
import com.hstc.studentoateamserver.converter.CreateTeamForm2TeamConverter;
import com.hstc.studentoateamserver.enums.TeamEnum;
import com.hstc.studentoateamserver.exception.TeamException;
import com.hstc.studentoateamserver.form.CreateTeamForm;
import com.hstc.studentoateamserver.pojo.Team;
import com.hstc.studentoateamserver.service.TeamService;
import com.hstc.studentoateamserver.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/team")
@Slf4j
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/create")
    public String CreateTeam(@Valid CreateTeamForm createTeamForm, BindingResult bindingResult, HttpServletResponse response){
        if (bindingResult.hasErrors()){
            log.error("用户注册信息不正确");
            throw new TeamException(TeamEnum.PARAM_ERRER.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        response.setHeader("Access-Control-Allow-Origin", "*");

        Team team = CreateTeamForm2TeamConverter.convert(createTeamForm);

        Team result = teamService.addTeam(team);
        return new Gson().toJson(ResultVOUtil.success(result));
    }
}

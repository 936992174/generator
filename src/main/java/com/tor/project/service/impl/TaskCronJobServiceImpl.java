package com.tor.project.service.impl;

import com.tor.project.mapper.TaskCronJobMapper;
import com.tor.project.entity.TaskCronJob;
import com.tor.project.service.TaskCronJobService;
import com.tor.generator.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Tzx on 2020/04/24.
 */
@Service
@Transactional
public class TaskCronJobServiceImpl extends AbstractService<TaskCronJob> implements TaskCronJobService {
    @Resource
    private TaskCronJobMapper taskCronJobMapper;

}

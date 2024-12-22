package org.example.spzx.manager.service.impl;

import org.example.spzx.manager.mapper.SysOperLogMapper;
import org.example.spzx.manager.service.AsyncOperLogService;
import org.example.spzx.model.entity.system.SysOperLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
@Service
public class AsyncOperLogServiceImpl implements AsyncOperLogService {
    @Autowired
    private SysOperLogMapper sysOperLogMapper;

    @Override
    public void saveSysOperLog(SysOperLog sysOperLog) {
        sysOperLogMapper.insert(sysOperLog);
    }
}

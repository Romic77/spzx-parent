package org.example.spzx.manager.service;

import org.example.spzx.model.entity.system.SysOperLog;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface AsyncOperLogService {
    void saveSysOperLog(SysOperLog sysOperLog);
}

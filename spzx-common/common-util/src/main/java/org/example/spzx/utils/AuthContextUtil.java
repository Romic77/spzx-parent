package org.example.spzx.utils;

import org.example.spzx.model.entity.system.SysUser;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public class AuthContextUtil {
    public static final ThreadLocal<SysUser> threadLocal = new ThreadLocal<>();

    /**
     * 设置认证上下文
     */

    public static void setAuthContext(SysUser user) {
        threadLocal.set(user);
    }

    /**
     * 获取认证上下文
     * @return
     */
    public static SysUser getAuthContext() {
        return threadLocal.get();
    }

    /**
     * 清除认证上下文
     */
    public static void clearAuthContext() {
        threadLocal.remove();
    }

}

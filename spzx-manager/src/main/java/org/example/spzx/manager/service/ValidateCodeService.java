package org.example.spzx.manager.service;

import org.example.spzx.model.vo.system.ValidateCodeVo;

public interface ValidateCodeService {

    // 获取验证码图片
    public ValidateCodeVo generateValidateCode();

}
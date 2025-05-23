package com.september.sunrise.service;

import com.september.sunrise.domain.login.request.SrUserLoginRequest;

public interface SrLoginService {
    String login(SrUserLoginRequest loginVo);
}

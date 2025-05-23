package com.september.sunrise.service;

import com.september.sunrise.domain.register.request.SrUserRegisterRequest;

public interface SrRegisterService {
    void register(SrUserRegisterRequest registerVo);
}

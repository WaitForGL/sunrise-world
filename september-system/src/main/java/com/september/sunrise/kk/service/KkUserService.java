package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkUser;

public interface KkUserService {
    KkUser getByUsername(String username);
}

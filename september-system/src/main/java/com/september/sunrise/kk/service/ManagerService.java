package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.ManagerQueryDto;

import java.util.List;

public interface ManagerService {

    List<KkUser> getManagerList(ManagerQueryDto queryDto);


    void addManager(KkUser user);

    void deleteManager(Long id);

    void leaveManager(Long id);
}

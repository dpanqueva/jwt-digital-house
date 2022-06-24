package com.dh.bd.test.ms.bd.test.service.sp;

import com.dh.bd.test.ms.bd.test.model.sp.UserPerRolEntity;
import com.dh.bd.test.ms.bd.test.repository.sp.IStoredProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SPExecServiceImpl implements ISPExecService {
    @Autowired
    private IStoredProcedureRepository procedureRepository;

    @Override
    public List<UserPerRolEntity> executeSP() {
        return procedureRepository.executeSP();
    }
}

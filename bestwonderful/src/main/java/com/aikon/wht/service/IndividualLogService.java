package com.aikon.wht.service;

import com.aikon.wht.dao.extend.IndividualLogExtendMapper;
import com.aikon.wht.entity.IndividualLog;
import com.aikon.wht.enums.IndividualLogTypeEnum;
import com.aikon.wht.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haitao.wang
 */
@Service
public class IndividualLogService {

    @Autowired
    IndividualLogExtendMapper individualLogExtendMapper;

    public void createIndividualLog(Integer creatorId, String memo, StatusEnum statusEnum, IndividualLogTypeEnum ilte, Integer individualId) {
        IndividualLog individualLog = new IndividualLog();
        individualLog.setCreatorId(creatorId);
        individualLog.setMemo(memo);
        individualLog.setStatus(statusEnum.getCode());
        individualLog.setType(ilte.getCode());
        individualLog.setIndividualId(individualId);
        individualLogExtendMapper.insertSelective(individualLog);

    }

    public IndividualLog getLastSendMailLog(Integer individualId) {
        return individualLogExtendMapper.getLastLog(individualId,IndividualLogTypeEnum.SEND_ACTIVE_MAIL.getCode());
    }
}

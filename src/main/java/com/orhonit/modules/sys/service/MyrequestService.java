package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.MyrequestEntity;
import com.orhonit.modules.sys.vo.MyrequestEntityVo;

import java.util.Map;

/**
 * 我的述求
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-25 16:47:20
 */
public interface MyrequestService extends IService<MyrequestEntity> {

    PageUtils queryPage(Map<String, Object> params, int deptId,int orgId);
    
    PageUtils myRequestPage(Map<String, Object> params, long userId,int isDeptOrOrg);

    MyrequestEntityVo selectInfoMyrequest(Integer myreqId);
}


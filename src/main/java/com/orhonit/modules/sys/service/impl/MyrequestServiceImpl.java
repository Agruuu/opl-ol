package com.orhonit.modules.sys.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.MyrequestDao;
import com.orhonit.modules.sys.entity.MyrequestEntity;
import com.orhonit.modules.sys.service.MyrequestService;
import com.orhonit.modules.sys.vo.MyrequestEntityVo;


@Service("myrequestService")
public class MyrequestServiceImpl extends ServiceImpl<MyrequestDao, MyrequestEntity> implements MyrequestService {
	
	@Autowired
	private MyrequestDao myrequestDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params,int deptId,int orgId) {
    	int myreqIsRes = Integer.parseInt(params.get("myreqIsRes").toString());
    	int myreqDeptororg = Integer.parseInt(params.get("myreqDeptororg").toString());
    	if(myreqDeptororg==0) {
    		Page<MyrequestEntity> page = this.selectPage(
	                new Query<MyrequestEntity>(params).getPage(),
	                new EntityWrapper<MyrequestEntity>().where("myreq_is_res = {0}", myreqIsRes)
	                .where("dept_id={0}", deptId).where("myreq_deptororg={0}", myreqDeptororg).orderBy("myreq_id")
	        );
	        page.setTotal(this.selectCount(new EntityWrapper<MyrequestEntity>().where("myreq_is_res = {0}", myreqIsRes)
	                .where("dept_id={0}", deptId).where("myreq_deptororg={0}", myreqDeptororg)));
	        return new PageUtils(page);
    	}
    	Page<MyrequestEntity> page = this.selectPage(
                new Query<MyrequestEntity>(params).getPage(),
                new EntityWrapper<MyrequestEntity>().where("myreq_is_res = {0}", myreqIsRes)
                .where("org_id={0}", orgId).where("myreq_deptororg={0}", myreqDeptororg).orderBy("myreq_id")
        );
        page.setTotal(this.selectCount(new EntityWrapper<MyrequestEntity>().where("myreq_is_res = {0}", myreqIsRes)
                .where("org_id={0}", orgId).where("myreq_deptororg={0}", myreqDeptororg)));
        return new PageUtils(page);

    }

	@Override
	public PageUtils myRequestPage(Map<String, Object> params, long userId,int isDeptOrOrg) {
        Page<MyrequestEntity> page = this.selectPage(
                new Query<MyrequestEntity>(params).getPage(),
                new EntityWrapper<MyrequestEntity>().where("req_user_id={0}",userId).where("myreq_deptororg={0}", isDeptOrOrg).orderBy("myreq_id DESC")
        );
        return new PageUtils(page);
	}

	@Override
	public MyrequestEntityVo selectInfoMyrequest(Integer myreqId) {
		// TODO Auto-generated method stub
		return myrequestDao.selectInfoMyrequest(myreqId);
	}

}

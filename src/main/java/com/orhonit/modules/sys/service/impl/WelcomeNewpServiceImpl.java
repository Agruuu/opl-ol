package com.orhonit.modules.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dao.WelcomeNewpDao;
import com.orhonit.modules.sys.entity.WelcomeNewpEntity;
import com.orhonit.modules.sys.service.WelcomeNewpService;
import com.orhonit.modules.sys.vo.WelcomeNewpVo;


@Service("welcomeNewpService")
public class WelcomeNewpServiceImpl extends ServiceImpl<WelcomeNewpDao, WelcomeNewpEntity> implements WelcomeNewpService {
	
	@Autowired
	private WelcomeNewpDao welcomeNewpDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params,long userId) {
        int currPage = 1;
		int limit = 20;
		 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
		Page<WelcomeNewpEntity> page = new Page<WelcomeNewpEntity>(currPage, limit);
		int beginLimit = (currPage-1)*limit;
		List<WelcomeNewpEntity> welcomeNewpEntity = welcomeNewpDao.selectWelList(beginLimit,limit,userId);
		if(welcomeNewpEntity!=null) {
			for(WelcomeNewpEntity welce:welcomeNewpEntity) {
				if(welce.getUserTrueName()!=null){
					welce.setNewpTitle("欢迎  "+welce.getUserTrueName()+"  同志加入组织~");
				}else {
					welce.setNewpTitle("欢迎新同志加入组织~");
				}
			}
		}
		page.setRecords(welcomeNewpEntity);
		
        return new PageUtils(page);
    }

	@Override
	public WelcomeNewpVo selectNewpById(Integer newpId) {
		// TODO Auto-generated method stub
		return welcomeNewpDao.selectNewpById(newpId);
	}

}

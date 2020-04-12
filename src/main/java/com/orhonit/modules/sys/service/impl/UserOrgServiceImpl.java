package com.orhonit.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;

import com.orhonit.modules.sys.dao.UserOrgDao;
import com.orhonit.modules.sys.entity.UserOrgEntity;
import com.orhonit.modules.sys.service.UserOrgService;
import com.orhonit.modules.sys.vo.IdAndNameVo;
import com.orhonit.modules.sys.vo.TreeVo;


@Service("userOrgService")
public class UserOrgServiceImpl extends ServiceImpl<UserOrgDao, UserOrgEntity> implements UserOrgService {
	
	@Autowired
	private UserOrgDao userOrgDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserOrgEntity> page = this.selectPage(
                new Query<UserOrgEntity>(params).getPage(),
                new EntityWrapper<UserOrgEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<TreeVo> getOrgTree() {
		List<TreeVo>  entityList = userOrgDao.getOrgList();
		// TODO Auto-generated method stub
		List<TreeVo> resultList = new ArrayList<>();//存储顶层的数据
		
		Map<Object, TreeVo> treeMap = new HashMap<>();
		TreeVo itemTree;
		
		for(int i=0;i<entityList.size()&&!entityList.isEmpty();i++) {
			itemTree = entityList.get(i);
			treeMap.put(itemTree.getTreeId(),itemTree);//把所有的数据放到map当中，id为key
			if(-1==itemTree.getSupperTreeId()) {//把顶层数据放到集合中
				resultList.add(itemTree);
			}
		}
		
		//循环数据，把数据放到上一级的childen属性中
		for(int i = 0; i< entityList.size()&&!entityList.isEmpty();i++) {
			itemTree = entityList.get(i);
			TreeVo data = treeMap.get(itemTree.getSupperTreeId());//在map集合中寻找父亲
			if(data != null) {//判断父亲有没有
				if(data.getChildList() == null) {
					data.setChildList(new ArrayList<>());
				}
				data.getChildList().add(itemTree);//把子节点 放到父节点childList当中
				treeMap.put(itemTree.getSupperTreeId(), data);//把放好的数据放回map当中
			}
		}
		return resultList;
	}

	@Override
	public List<IdAndNameVo> ListByLike(String orgName) {
		// TODO Auto-generated method stub
		return userOrgDao.ListByLike(orgName);
	}

	@Override
	public IdAndNameVo getOrgByOrgId(int userOrg) {
		// TODO Auto-generated method stub
		return userOrgDao.getOrgByOrgId(userOrg);
	}

	@Override
	public List<IdAndNameVo> getDeptByOrgId(int userOrg) {
		// TODO Auto-generated method stub
		return userOrgDao.getDeptByOrgId(userOrg);
	}

}

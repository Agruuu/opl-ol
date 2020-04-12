package com.orhonit.modules.app.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.sys.entity.UserMemorandumEntity;
import com.orhonit.modules.sys.service.UserMemorandumService;

@RestController
@RequestMapping("/app/usermemorandum")
public class AppUserMemorandumController {

	@Autowired
	private UserMemorandumService userMemorandumService;

	/**
	 * APP用戶管理通用-备忘录-查询列表（userId）
	 */
	@Login
	@RequestMapping("/list")
	//@RequiresPermissions("sys:usermemorandum:list")
	public R list(@RequestParam Map<String, Object> params,@RequestAttribute Long userId) {
		PageUtils page = userMemorandumService.queryPage(params,userId);

		return R.ok().put("page", page);
	}

	/**
	 * APP用戶管理通用-备忘录-查询单条（memorandumId）
	 */
	@Login
	@RequestMapping("/info/{memorandumId}")
	//@RequiresPermissions("sys:usermemorandum:info")
	public R info(@PathVariable("memorandumId") Integer memorandumId) {
		UserMemorandumEntity userMemorandum = userMemorandumService.selectById(memorandumId);

		return R.ok().put("userMemorandum", userMemorandum);
	}

	/**
	 * APP用戶管理通用-备忘录-添加备忘录
	 */
	@Login
	@RequestMapping("/save")
	//@RequiresPermissions("sys:usermemorandum:save")
	public R save(@RequestBody UserMemorandumEntity userMemorandum,@RequestAttribute Long userId) {
		userMemorandum.setUserId(userId);
		userMemorandum.setCtrTime(new Date());
		userMemorandumService.insert(userMemorandum);
		
		return R.ok();
	}

	/**
	 * APP用戶管理通用-备忘录-修改备忘录
	 */
	@Login
	@RequestMapping("/update")
	//@RequiresPermissions("sys:usermemorandum:update")
	public R update(@RequestBody UserMemorandumEntity userMemorandum) {
		userMemorandumService.updateById(userMemorandum);

		return R.ok();
	}

	/**
	 * APP用戶管理通用-备忘录-删除备忘录
	 */
	@Login
	@RequestMapping("/delete/{memorandumId}")
	//@RequiresPermissions("sys:usermemorandum:delete")
	public R delete(@PathVariable("memorandumId") Integer memorandumId) {
		//userMemorandumService.deleteBatchIds(Arrays.asList(memorandumIds));
		userMemorandumService.deleteById(memorandumId);
		return R.ok();
	}

}

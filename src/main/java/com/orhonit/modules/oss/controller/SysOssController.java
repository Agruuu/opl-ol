/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.orhonit.modules.oss.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.orhonit.common.exception.RRException;
import com.orhonit.common.utils.ConfigConstant;
import com.orhonit.common.utils.Constant;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.common.validator.ValidatorUtils;
import com.orhonit.common.validator.group.AliyunGroup;
import com.orhonit.common.validator.group.QcloudGroup;
import com.orhonit.common.validator.group.QiniuGroup;
import com.orhonit.modules.app.config.UploadConfig;
import com.orhonit.modules.oss.cloud.CloudStorageConfig;
import com.orhonit.modules.oss.entity.SysOssEntity;
import com.orhonit.modules.oss.service.SysOssService;
import com.orhonit.modules.sys.service.SysConfigService;

/**
 * 文件上传
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-25 12:13:26
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
	@Autowired
	private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;
	@Autowired	
    private UploadConfig uploadConfig;

    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:oss:all")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = sysOssService.queryPage(params);

		return R.ok().put("page", page);
	}


    /**
     * 云存储配置信息
     */
    @GetMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public R config(){
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return R.ok().put("config", config);
    }


	/**
	 * 保存云存储配置信息
	 */
	@PostMapping("/saveConfig")
	@RequiresPermissions("sys:oss:all")
	public R saveConfig(@RequestBody CloudStorageConfig config){
		//校验类型
		ValidatorUtils.validateEntity(config);

		if(config.getType() == Constant.CloudService.QINIU.getValue()){
			//校验七牛数据
			ValidatorUtils.validateEntity(config, QiniuGroup.class);
		}else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
			//校验阿里云数据
			ValidatorUtils.validateEntity(config, AliyunGroup.class);
		}else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
			//校验腾讯云数据
			ValidatorUtils.validateEntity(config, QcloudGroup.class);
		}

        sysConfigService.updateValueByKey(KEY, new Gson().toJson(config));

		return R.ok();
	}
	

	/**
	 * 上传文件
	 */
	@PostMapping("/upload")
	//@RequiresPermissions("sys:oss:all")
	public R upload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new RRException("上传文件不能为空");
		}

		//上传文件
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String fileLocalName = System.currentTimeMillis() + "";
		Date date = new Date();
		SimpleDateFormat dformat = new SimpleDateFormat("yyyyMMdd");
		String dateStr = dformat.format(date);
		//String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);
		String filePath = uploadConfig.getPath() + dateStr + "//";
		try {
			// 创建目录
			File dir = new File(filePath);
			
			dir.mkdirs();

			// 获取文件输入流	
			InputStream in = file.getInputStream();

			// 创建文件并保存
			File f = new File(filePath + fileLocalName + suffix);
			FileOutputStream fos = new FileOutputStream(f);
			byte[] b = new byte[1024];
			int n = 0;
			while ((n = in.read(b)) != -1) {
				fos.write(b, 0, n);				
			}
			fos.close();
			in.close();
//			oele.save(omf);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return R.error();
		}
		//保存文件信息
		SysOssEntity ossEntity = new SysOssEntity();
		ossEntity.setUrl(filePath);
		ossEntity.setCreateDate(new Date());
		sysOssService.insert(ossEntity);

		return R.ok().put("url","http://39.104.121.137:8080/ftp/" + dateStr + "/" + fileLocalName + suffix);
	}


	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@RequiresPermissions("sys:oss:all")
	public R delete(@RequestBody Long[] ids){
		sysOssService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}

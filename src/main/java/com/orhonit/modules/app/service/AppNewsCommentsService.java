package com.orhonit.modules.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.modules.app.vo.AppNewsCommentVo;

public interface AppNewsCommentsService  extends IService<AppNewsCommentVo>{

	AppNewsCommentVo newComAndReply(Map<String, Object> params);
}

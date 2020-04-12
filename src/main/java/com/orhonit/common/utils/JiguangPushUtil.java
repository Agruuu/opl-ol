package com.orhonit.common.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orhonit.modules.app.vo.AppTuiSongVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;

/**
 * 
 * @author 
 * @date	2018年3月28日 上午11:10:08
 */
public class JiguangPushUtil {

	
	 	private static final Logger log = LoggerFactory.getLogger(JiguangPushUtil.class);
	    private static String masterSecret = "de3928e0522d5601cf08e398";
	    private static String appKey = "a2ec0ef13486c0b71750cb39";
	    private static String pushUrl = "https://api.jpush.cn/v3/push";    
	    private static boolean apns_production = true;    
	    private static int time_to_live = 86400*10;
	    
	    /**
	      * 单个推送
	     * @param id 注册id
	     * @param alert 弹窗内容
	     */
	    public static void jiguangPush(List<String> ids,String alert,AppTuiSongVo appTuiSongVo){
	        //String registration_id = id;
	    	//声明注册id
	        try{
	            String result = push(pushUrl,ids,alert,appKey,masterSecret,apns_production,time_to_live,appTuiSongVo);
	            System.out.println(result);
	            JSONObject resData = JSONObject.fromObject(result);
	                if(resData.containsKey("error")){
	                    log.info("针对注册ids的信息推送失败！");
	                    JSONObject error = JSONObject.fromObject(resData.get("error"));
	                    log.info("错误信息为：" + error.get("message").toString());
	                }
	            log.info("针对注册id的信息推送成功！");
	        }catch(Exception e){
	            log.error("针对注册id的信息推送失败！",e);
	        }
	    }
	    
	    /**
	     * 组装极光推送专用json串
	     * @param registration_id	注册id
	     * @param alert	弹窗内容
	     * @param apns_production 推送环境
	     * @param time_to_live 
	     * @param cpcRemind
	     * @return
	     */
	    public static JSONObject generateJson(List<String> ids,String alert,boolean apns_production,int time_to_live,AppTuiSongVo appTuiSongVo){
	        JSONObject json = new JSONObject();
	        JSONArray platform = new JSONArray();//平台
	        platform.add("android");
	        platform.add("ios");
	        
	        JSONObject audience = new JSONObject();//推送目标
	        //JSONArray alias1 = new JSONArray();
	        //alias1.add(registration_id);
	    
	           audience.put("registration_id", ids);
	  
	        JSONObject notification = new JSONObject();//通知内容
	        JSONObject android = new JSONObject();//android通知内容
	        android.put("alert", alert);
//	        android.put("builder_id", 1);
	        JSONObject android_extras = new JSONObject();//android额外参数
	        android_extras.put("meetId", appTuiSongVo.getMeetId());
	        android_extras.put("newId", appTuiSongVo.getNewId());
	        android_extras.put("newpId", appTuiSongVo.getNewpId());
	        android_extras.put("typeCode", appTuiSongVo.getTypeCode());
	        android.put("extras", android_extras);
	        
//	        JSONObject ios = new JSONObject();//ios通知内容
//	        ios.put("alert", alert);
//	        ios.put("sound", "default");
//	        ios.put("badge", "+1");
//	        JSONObject ios_extras = new JSONObject();//ios额外参数
//	        ios_extras.put("提醒支部", cpcRemind.getRemindDeptName());
//	        ios_extras.put("标题", cpcRemind.getRemindTitle());
//	        ios_extras.put("内容", cpcRemind.getRemindContent());
//	        ios_extras.put("提醒时间", cpcRemind.getRemindTime());
	        
//	        ios.put("extras", ios_extras);
	        notification.put("android", android);
//	        notification.put("ios", ios);
	        
	        JSONObject options = new JSONObject();//设置参数
	        options.put("time_to_live", Integer.valueOf(time_to_live));
	        options.put("apns_production", apns_production);
	        json.put("platform", platform);
	        json.put("audience", audience);
	        json.put("notification", notification);
	        json.put("options", options);
	        System.out.println(json.toString());
	        return json;
	        
	    }
	    
	    /**
	     * 推送方法-调用极光API
	     * @param reqUrl
	     * @param alias
	     * @param alert
	     * @return result
	     */
	    public static String push(String reqUrl,List<String> ids,String alert,String appKey,String masterSecret,boolean apns_production,int time_to_live,AppTuiSongVo appTuiSongVo){
	        String base64_auth_string = encryptBASE64(appKey + ":" + masterSecret);
	        String authorization = "Basic " + base64_auth_string;
	        return HttpClientUtil.sendPost(reqUrl,generateJson(ids,alert,apns_production,time_to_live,appTuiSongVo).toString(),"UTF-8",authorization);
	    }
	    
	    /** 
	　　　　* BASE64加密工具
	　　　　*/
	     public static String encryptBASE64(String str) {
	         byte[] key = str.getBytes();
	       BASE64Encoder base64Encoder = new BASE64Encoder();
	       String strs = base64Encoder.encodeBuffer(key);
	         return strs;
	     }
}

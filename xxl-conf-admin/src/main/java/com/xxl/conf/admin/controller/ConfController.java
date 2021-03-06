package com.xxl.conf.admin.controller;

import com.xxl.conf.admin.controller.annotation.PermessionLimit;
import com.xxl.conf.admin.core.model.XxlConfNode;
import com.xxl.conf.admin.core.util.ReturnT;
import com.xxl.conf.admin.service.IXxlConfNodeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 配置管理
 * @author xuxueli
 */
@Controller
@RequestMapping("/conf")
public class ConfController {
	
	@Resource
	private IXxlConfNodeService xxlConfNodeService;
	
	@RequestMapping("")
	@PermessionLimit
	public String index(Model model, String znodeKey){
		return "conf/index";
	}

	@RequestMapping("/pageList")
	@ResponseBody
	@PermessionLimit
	public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
			@RequestParam(required = false, defaultValue = "10") int length, String nodeKey) {
		return xxlConfNodeService.pageList(start, length, nodeKey);
	}
	
	/**
	 * get
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@PermessionLimit
	public ReturnT<String> delete(String nodeKey){
		return xxlConfNodeService.deleteByKey(nodeKey);
	}

	/**
	 * create/update
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	@PermessionLimit
	public ReturnT<String> add(XxlConfNode xxlConfNode){
		return xxlConfNodeService.add(xxlConfNode);
	}
	
	/**
	 * create/update
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	@PermessionLimit
	public ReturnT<String> update(XxlConfNode xxlConfNode){
		return xxlConfNodeService.update(xxlConfNode);
	}
	
}

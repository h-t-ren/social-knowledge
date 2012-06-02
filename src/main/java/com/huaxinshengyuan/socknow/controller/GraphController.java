package com.huaxinshengyuan.socknow.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class GraphController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = LogicRequest.GRAPH, method = RequestMethod.GET, headers=HttpHeaders.HTML)
	public String  generGraph(@RequestParam("id") Long id, Model model) {
		return LogicVeiws.GRAPH;
	}
	

	

}

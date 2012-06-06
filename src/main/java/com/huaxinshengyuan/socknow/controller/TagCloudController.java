package com.huaxinshengyuan.socknow.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huaxinshengyuan.socknow.domain.Keyword;
import com.huaxinshengyuan.socknow.repo.KeywordRepository;


@Controller
public class TagCloudController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired private KeywordRepository keywordRepository;
	
	@RequestMapping(value = LogicRequest.tagCloud
			, method = RequestMethod.GET, headers=HttpHeaders.HTML)
	public String  generGraph( Model model) {
		StringBuilder sb = new StringBuilder();
		for(Keyword k:keywordRepository.findAll())
		{
			sb.append("{text:" +"\""+k.getKeyword()+"\","+" weight: " + k.getFreq()+"},");
		}
		sb.deleteCharAt(sb.length()-1);
		model.addAttribute("array", sb.toString());
		return LogicVeiws.tagCloud;
	}
	

	

}

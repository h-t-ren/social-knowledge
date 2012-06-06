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
public class PublicationController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired private KeywordRepository keywordRepository;
	
	

	

}

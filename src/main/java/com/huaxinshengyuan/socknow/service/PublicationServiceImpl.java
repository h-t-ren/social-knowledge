package com.huaxinshengyuan.socknow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.repo.PublicationRepository;


@Service("publicationService") @Transactional(readOnly=true)
public class PublicationServiceImpl implements PublicationService {
	
	@Autowired private PublicationRepository publicationRepository;

	@Override @Transactional
	public void save(Publication publication) {
		publicationRepository.save(publication);

	}

}

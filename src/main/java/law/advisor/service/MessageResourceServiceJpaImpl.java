package law.advisor.service;

import law.advisor.model.MessageResource;
import law.advisor.repository.MessageResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageResourceServiceJpaImpl implements MessageResourceService {

    @Autowired
    MessageResourceRepository messageResourceRepository;


    @Override
    public List<MessageResource> findAll() {
        return messageResourceRepository.findAll();
    }
}
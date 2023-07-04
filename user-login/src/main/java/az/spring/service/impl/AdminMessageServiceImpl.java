package az.spring.service.impl;

import az.spring.entity.AdminMessage;
import az.spring.entity.NewsData;
import az.spring.repository.AdminMessageRepository;
import az.spring.service.AdminMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminMessageServiceImpl implements AdminMessageService {

    private final AdminMessageRepository adminMessageRepository;
    @Override
    public List<AdminMessage> getAllAdminMessage() {
        return adminMessageRepository.findAll();
    }

    @Override
    public void saveAdminMessage(AdminMessage adminMessage) {
        adminMessageRepository.save(adminMessage);
    }

    @Override
    public void deleteAdminMessage(Long id) {
        adminMessageRepository.deleteById(id);
    }

    @Override
    public AdminMessage getByIdAdminMessage(Long id) {
        AdminMessage existingNews = adminMessageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel not found with ID: " + id));
        return existingNews;
    }
}

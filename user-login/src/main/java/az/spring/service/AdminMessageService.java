package az.spring.service;

import az.spring.entity.AdminMessage;
import az.spring.entity.NewsData;

import java.util.List;

public interface AdminMessageService {

    List<AdminMessage> getAllAdminMessage();

    void saveAdminMessage(AdminMessage adminMessage);

    void deleteAdminMessage(Long id);

    AdminMessage getByIdAdminMessage(Long id);
}

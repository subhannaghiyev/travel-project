package az.spring.controller;

import az.spring.entity.AdminMessage;
import az.spring.service.AdminMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AdminMessageController {
    private final AdminMessageService adminMessageService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AdminMessage> getAllOffers(){
        return adminMessageService.getAllAdminMessage();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOffers(@RequestBody AdminMessage adminMessage){
        adminMessageService.saveAdminMessage(adminMessage);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOffers(@PathVariable Long id){
        adminMessageService.deleteAdminMessage(id);
    }
    @GetMapping("/{id}")
    public AdminMessage getByIdTravel(@PathVariable Long id){
        return adminMessageService.getByIdAdminMessage(id);
    }
}

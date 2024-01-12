package com.train.controller;

import com.train.model.Ticket;
import com.train.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    TrainService ticketService;

    @GetMapping("/get-all")
    public Map<String, Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/view-users-seats/{section}")
    public Map<String, String> viewUsersAndSeats(@PathVariable String section) {
        return ticketService.viewUsersAndSeats(section);
    }

    @PutMapping("/modify-user-seat/{userId}/{newSection}/{newSeat}")
    public String modifyUserSeat(@PathVariable String userId, @PathVariable String newSection, @PathVariable String newSeat) {
        return ticketService.modifyUserSeat(userId, newSection, newSeat);
    }
}


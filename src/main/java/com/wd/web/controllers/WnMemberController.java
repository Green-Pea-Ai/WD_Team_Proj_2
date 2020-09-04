package com.wd.web.controllers;

import com.wd.web.entities.WnMember;
import com.wd.web.services.WnMemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wn_member")
public class WnMemberController {

    final WnMemberService service;

    public WnMemberController(WnMemberService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public String save(WnMember param){
        service.save(param);

        return "SUCCESS";
    }
    @GetMapping("/findById")
    public Optional<WnMember> findById(Long userNo) {
        return service.findById(userNo);
    }

    @GetMapping("/findAll")
    public List<WnMember> findAll() {
        return service.findAll();
    }

    @GetMapping("/count")
    public Long count() {
        return service.count();
    }

    @PutMapping("/update")
    public String update(WnMember param) {
        service.update(param);
        return "SUCCESS";
    }

    @DeleteMapping("/delete")
    public String delete(WnMember param) {
        service.delete(param);
        return "SUCCESS";
    }
}

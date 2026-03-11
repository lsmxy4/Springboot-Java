package com.example.demo.controller;

import com.example.demo.dto.CreateMemberRequest;
import com.example.demo.dto.MemberResponse;
import com.example.demo.dto.UpdateMemberRequest;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public Long create(@RequestBody CreateMemberRequest request){
        return memberService.join(request.name(),request.email());
    }

    @GetMapping("/members")
    public List<MemberResponse> list(){
        return memberService.findAll()
                .stream()
                .map(m -> new MemberResponse(
                        m.getId(),
                        m.getName(),
                        m.getEmail(),
                        m.getCreatedAt()
                ))
                .toList();
    }

    @GetMapping("/members/{id}")
    public MemberResponse findOne(@PathVariable Long id){
        var m = memberService.findById(id);

        return new MemberResponse(
                m.getId(),
                m.getName(),
                m.getEmail(),
                m.getCreatedAt()
                );
    }

    @PatchMapping("/members/{id}")
    public MemberResponse update(@PathVariable Long id,
                                 @RequestBody UpdateMemberRequest request){
        var updated = memberService.update(id,request.name(),request.email());

        return  new MemberResponse(
                updated.getId(),
                updated.getName(),
                updated.getEmail(),
                updated.getCreatedAt()
        );
    }

    @DeleteMapping("/members/{id}")
    public void delete(@PathVariable Long id){
        memberService.delete(id);
    }
}

package com.econv.mentoring24Th.mission01.jongjun;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jongjun")
public class HttpTestController {

    @GetMapping("/query")
    public void query(@RequestParam Long id, @RequestParam String name) {
        System.out.println("By query id = " + id);
        System.out.println("By query name = " + name);
    }

    @PostMapping("/formDataParam")
    public void formDataParam(@RequestParam Long id, @RequestParam String name) {
        System.out.println("By formData Param id = " + id);
        System.out.println("By formData Param name = " + name);
    }

    @PostMapping("/formDataModel")
    public void formDataModel(@ModelAttribute Member member) {
        System.out.println("By formData Model id = " + member.getId());
        System.out.println("By formData Model name = " + member.getName());
    }

    @PostMapping("/requestBodyMember")
    public void requestBodyMember(@RequestBody Member member) {
        System.out.println("By request Body id = " + member.getId());
        System.out.println("By request Body name = " + member.getName());
    }
}

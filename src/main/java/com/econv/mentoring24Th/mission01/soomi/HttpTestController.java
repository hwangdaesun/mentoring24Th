package com.econv.mentoring24Th.mission01.soomi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/soomi")
public class HttpTestController {

    @GetMapping("/query")
    public void query(@RequestParam Long id, @RequestParam String name) {
        System.out.println("id =" + id);
        System.out.println("name =" + name);
    }

    @PostMapping("/formDataParam")
    public void formDataParam(@RequestParam Long id, @RequestParam String name) {
        System.out.println("id =" + id);
        System.out.println("Name =" + name);
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

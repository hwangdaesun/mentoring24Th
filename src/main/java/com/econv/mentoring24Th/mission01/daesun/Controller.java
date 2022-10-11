package com.econv.mentoring24Th.mission01.daesun;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/daesun")
public class Controller {

    @GetMapping("/pathvariable/{id}")
    public void pathVariable1(@PathVariable("id") Long id){
        System.out.println("id = " + id);
    }

    @GetMapping("/pathvariable/{id}/{name}")
    public void pathVariable2(@PathVariable("id") Long id, @PathVariable("name") String name){
        System.out.println("id = " + id);
        System.out.println("name = " + name);
    }

    @PostMapping("/pathvariable/{id1}")
    public void pathVariable3(@PathVariable("id1") Long id){
        System.out.println("id = " + id);
    }

    @PostMapping("/pathvariable/{id1}/{name1}")
    public void pathVariable4(@PathVariable("id1") Long id, @PathVariable("name1") String name){
        System.out.println("id = " + id);
        System.out.println("name = " + name);
    }

    @GetMapping("/query")
    public void query1(@RequestParam Long id,@RequestParam String name){
        System.out.println("id = " + id);
        System.out.println("name = " + name);
    }

    @PostMapping("/query")
    public void query2(@RequestParam Long id,@RequestParam String name){
        System.out.println("id = " + id);
        System.out.println("name = " + name);
    }

    @PostMapping("/formData")
    public void formData(@ModelAttribute Member member){
        System.out.println("Id = " + member.getId());
        System.out.println("Name = " + member.getName());
    }

    @PostMapping("/rawJson")
    public void rawJson(@RequestBody Member member){
        System.out.println("Id = " + member.getId());
        System.out.println("Name = " + member.getName());
    }

}

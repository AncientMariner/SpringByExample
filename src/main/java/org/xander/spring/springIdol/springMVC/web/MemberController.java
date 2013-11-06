package org.xander.spring.springIdol.springMVC.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xander.spring.springIdol.springMVC.domain.Member;
import org.xander.spring.springIdol.springMVC.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
    private MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @RequestMapping("add")
    public String addMember(Model model) {
        Member member = new Member("Nick", new Double(123));
        model.addAttribute("member", member);
        memberService.add(member);
        model.addAttribute("guests", memberService.list());
        return "memberList";
    }
    @RequestMapping(value={"remove","delete"}, method= RequestMethod.GET)
    public String removeMember(
            @RequestParam("memberName") String memberName) {
        memberService.remove(memberName);
        return "redirect:../welcome";
    }
}

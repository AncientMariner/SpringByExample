package org.xander.spring.springIdol.springMVC.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xander.spring.springIdol.springMVC.domain.Member;
import org.xander.spring.springIdol.springMVC.service.MemberService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    private MemberService memberService;
    private static Validator validator;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();

    }


    @RequestMapping("add")
    public String addMember(Model model) {
        Member member = new Member("Nick", new Double(123), "123", "email");
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

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("member") Member member,
                             BindingResult result, Model model) {
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        for (ConstraintViolation<Member> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
        // Add JSR-303 errors to BindingResult
        // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("member",propertyPath,"Invalid "+ propertyPath + "(" + message + ")"));
        }
        if(!result.hasErrors()) {
            return "redirect:reservationSuccess";
        } else {
            return "redirect:/reservationQuery/notAvailable";
        }
    }


}

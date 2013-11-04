package org.xander.spring.springIdol.springMVC.service;

import org.xander.spring.springIdol.springMVC.domain.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberService {

    private List<Member> members;

    public MemberService() {
        members = new ArrayList<>();
        Member member1 = new Member("Number 1", new Double(1234));
        Member member2 = new Member("Number 2", new Double(1233));
        members.add(member1);
        members.add(member2);
    }


    public List<Member> list() {
        List<Member> result = new ArrayList<Member>();
        for (Member member : members) {
            result.add(member);
        }
        return result;
    }

    public void remove(String memberName) {
        for (Member member : members) {
           if(member.getName().equals(memberName));
            members.remove(member);
        }
    }

    public void add(Member member) {
        members.add(member);
    }
}

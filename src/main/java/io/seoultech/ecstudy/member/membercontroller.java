package io.seoultech.ecstudy.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class membercontroller {
    private final MemberRepository memberRepository;

    @GetMapping("/members")
    @ResponseBody
    public String getTest() {
        System.out.println("members 경로로 들어옴");
      return "1"; //1.html을 보낸다는 뜻
    }

    @GetMapping("/test")
    @ResponseBody
    public String getTest2(){
        System.out.println("test 경로로 들어옴");
        return "2";
    };

    @PostMapping("/members")
    @ResponseBody
    public Member postTest(@RequestBody memberRequest request){
        Member member = new Member(request.getUserId(), request.getPassword());
        Member savedMember = memberRepository.save(member);
        System.out.println(request.getUserId() + " " + request.getPassword());
        return savedMember;
    }
}



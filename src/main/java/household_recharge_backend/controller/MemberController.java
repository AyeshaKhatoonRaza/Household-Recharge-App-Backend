package household_recharge_backend.controller;

import household_recharge_backend.dto.MemberRequest;
import household_recharge_backend.model.Member;
import household_recharge_backend.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Add a new member
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Member addMember(@RequestBody MemberRequest request) {
        return memberService.addMember(request);
    }

    // Get all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // Get all members belonging to a household
    @GetMapping("/household/{householdId}")
    public List<Member> getMembersByHouseholdId(
            @PathVariable String householdId
    ) {
        return memberService.getMembersByHouseholdId(householdId);
    }

    // Get member by ID
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable String id) {
        return memberService.getMemberById(id);
    }

    // Delete member
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable String id) {
        memberService.deleteMember(id);
    }
}
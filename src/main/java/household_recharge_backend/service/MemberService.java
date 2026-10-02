package household_recharge_backend.service;

import household_recharge_backend.dto.MemberRequest;
import household_recharge_backend.model.Member;
import household_recharge_backend.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member addMember(MemberRequest request) {

        long currentTime = System.currentTimeMillis();

        Member member = new Member();

        // Connect member to household
        member.setHouseholdId(request.getHouseholdId());

        member.setName(request.getName());
        member.setMobileNumber(request.getMobileNumber());
        member.setPlanDurationDays(request.getPlanDurationDays());
        member.setPlanAmount(request.getPlanAmount());

        // Recharge starts today
        member.setLastRechargeDate(currentTime);

        // Calculate expiry date
        long expiryDate = currentTime
                + (request.getPlanDurationDays() * 24L * 60 * 60 * 1000);

        member.setPlanExpiryDate(expiryDate);

        return memberRepository.save(member);
    }

    // Get all members from all households
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get all members belonging to one household
    public List<Member> getMembersByHouseholdId(String householdId) {
        return memberRepository.findByHouseholdId(householdId);
    }

    public Member getMemberById(String id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public void deleteMember(String id) {
        memberRepository.deleteById(id);
    }
}
package com.rankyeong.jpastart.service;

import com.rankyeong.jpastart.domain.Member;
import com.rankyeong.jpastart.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional    // 클래스에 readOnly = true 옵션 넣고(조회하는 메서드가 더 많아서), 쓰기 메소드에는 따로 @Transactional 붙여주기
    public Long join(Member member) {
        validateDuplicateMember(member);    // 중복 회원 검증 로직
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 해당 이름의 멤버 수를 세서 0보다 크면 에러처리 하는 것이 조금 더 최적화 됨 / 예제에서는 간단하게 하기 위해 아래처럼 구현
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}

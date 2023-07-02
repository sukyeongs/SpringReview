package com.rankyeong.jpastart.repository;

import com.rankyeong.jpastart.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    // JPA 사용 → JPA가 제공하는 표준 어노테이션(@PersistenceContext) 사용
    @PersistenceContext
    private final EntityManager em;    // spring이 엔티티 매니저를 생성하여 주입(injection함)

    // JPA가 저장하는 로직
    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        // 전체로 조회하는 경우 JPQL 작성해야함 (JPQL, 반환타입)
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // :name → parameter binding
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}

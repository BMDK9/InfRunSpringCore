package hello.spring_core.member.repository.impl;

import hello.spring_core.member.entity.Member;
import hello.spring_core.member.repository.MemberRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 new ConcurrentHashMap 사용
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

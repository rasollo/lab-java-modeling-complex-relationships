package com.ironhack.complex.relationships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ironhack.complex.relationships.model.Member.MemberStatus;
import com.ironhack.complex.relationships.repository.ChapterRepository;
import com.ironhack.complex.relationships.repository.MemberRepository;

@SpringBootTest
public class NursesAssociationTests {

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testChapterCreation() {
        Chapter chapter = new Chapter();
        chapter.setName("Metropolitan Nurses");
        chapter.setDistrict("Downtown");

        Chapter savedChapter = chapterRepository.save(chapter);
        assertNotNull(savedChapter.getId());
        assertEquals("Metropolitan Nurses", savedChapter.getName());
    }

    @Test
    public void testMemberCreation() {
        Chapter chapter = new Chapter();
        chapter.setName("Coastal Nurses");
        chapter.setDistrict("Beach District");
        chapterRepository.save(chapter);

        Member member = new Member();
        member.setName("Dr. Sarah Johnson");
        member.setStatus(MemberStatus.ACTIVE);
        member.setRenewalDate(new Date(System.currentTimeMillis() + 86400000 * 30)); // 30 days from now
        member.setChapter(chapter);

        Member savedMember = memberRepository.save(member);
        assertNotNull(savedMember.getId());
        assertEquals("Coastal Nurses", savedMember.getChapter().getName());
    }

    @Test
    public void testChapterWithPresidentAndMembers() {
        // Create chapter first
        Chapter chapter = new Chapter();
        chapter.setName("Northern Nurses");
        chapter.setDistrict("Mountain District");

        // Save chapter first to get an ID
        chapter = chapterRepository.save(chapter);

        // Create president and associate with chapter
        Member president = new Member();
        president.setName("Dr. Michael Chen");
        president.setStatus(MemberStatus.ACTIVE);
        president.setRenewalDate(new Date());
        president.setChapter(chapter);

        // Save president
        president = memberRepository.save(president);

        // Set president back to chapter
        chapter.setPresidentId(president);

        // Create regular members
        Member member1 = new Member("Nurse Jane Smith", MemberStatus.ACTIVE,
                new Date(System.currentTimeMillis() + 86400000 * 60), chapter);
        Member member2 = new Member("Nurse Robert Brown", MemberStatus.LAPSED,
                new Date(System.currentTimeMillis() - 86400000 * 30), chapter);

        // Save members
        member1 = memberRepository.save(member1);
        member2 = memberRepository.save(member2);

        // Set members to chapter
        chapter.setMembersList(List.of(member1, member2, president));

        // Update chapter
        Chapter savedChapter = chapterRepository.save(chapter);

        // Verify
        assertEquals(3, savedChapter.getMembersList().size());
        assertEquals("Dr. Michael Chen", savedChapter.getPresidentId().getName());
        assertTrue(savedChapter.getMembersList().stream()
                .anyMatch(m -> m.getName().equals("Nurse Jane Smith")));
    }

}

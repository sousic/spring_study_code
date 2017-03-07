package com.test.domain;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by sousic on 2017-02-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class JpaTest {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    public EntityManager em;

    @Test
    public void 회원등록() throws Exception
    {
        Member member = new Member();
        member.setUserid("testUser1");

        em.persist(member);

        Long id = 1L;

        assertEquals("회원 key 는 1이다.",id, member.getId());
    }
}

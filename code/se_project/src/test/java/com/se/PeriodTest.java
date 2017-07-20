package com.se;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.Domain.Business.Period;
import com.se.Repository.Jpa.PeriodRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeriodTest {
	@Autowired
	private PeriodRepository periodRepository;
	
	@Test
    public void PeriodTest(){
    	
    	periodRepository.save(new Period(1,new Time((new Date()).getTime()),new Time((new Date()).getTime())));
    	periodRepository.save(new Period(2,new Time((new Date()).getTime()),new Time((new Date()).getTime())));
    	periodRepository.save(new Period(3,new Time((new Date()).getTime()),new Time((new Date()).getTime())));
    	periodRepository.save(new Period(4,new Time((new Date()).getTime()),new Time((new Date()).getTime())));
    	periodRepository.save(new Period(5,new Time((new Date()).getTime()),new Time((new Date()).getTime())));
    	
    	assertEquals(5,periodRepository.findAll().size());
    	
    	assertEquals(3,periodRepository.findOne(3).getId());
    	
    	periodRepository.delete(5);
    	
    	assertEquals(false,periodRepository.exists(5));
    }
}

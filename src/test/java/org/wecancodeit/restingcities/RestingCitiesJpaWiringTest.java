package org.wecancodeit.restingcities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class RestingCitiesJpaWiringTest {

	@Test
	public void shouldSuccessfullyInitializeJpa() {
	}
}

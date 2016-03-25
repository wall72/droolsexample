package droolsexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import droolsexample.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DroolsExampleApplication.class)
public class DroolsExampleApplicationTests {

	@Autowired
	private KieContainer kieContainer;
	
	@Test
	public void testRules() {
		KieSession session = kieContainer.newKieSession("AdultAlcoholSession");

		User tom = new User();
		tom.setName("Tom");
		tom.setAge(19);
		tom.setAdult(false);

		session.insert(tom);

		session.fireAllRules();
	}
	
}

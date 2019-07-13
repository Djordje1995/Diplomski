package bd140657d.diplomski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //generise entitet u bazi od moje klase
public class DiplomskiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiplomskiApplication.class, args);
	}

}

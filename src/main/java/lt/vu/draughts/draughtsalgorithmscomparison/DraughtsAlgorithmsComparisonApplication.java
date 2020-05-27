package lt.vu.draughts.draughtsalgorithmscomparison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class DraughtsAlgorithmsComparisonApplication implements CommandLineRunner {

    @Autowired
    TestAlgorithms testAlgorithms;

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(DraughtsAlgorithmsComparisonApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {
        testAlgorithms.testResult();
        exit(0);
    }
}
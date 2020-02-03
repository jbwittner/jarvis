package fr.jarvis.server.model;

import fr.jarvis.server.TestObjectFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Transactional
public class ModelTest {

    protected TestObjectFactory factory;

    @BeforeEach
    public void init(){
        factory = new TestObjectFactory();
    }

    @AfterEach
    public void reset(){
        this.factory.resetListString();
    }

}

package com.dingxiang;

import com.dingxiang.client.EndpointConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class EndpointConfigTest {

    @Test
    public void load() {
        EndpointConfig endpointConfig = new EndpointConfig();

        try {
            endpointConfig.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

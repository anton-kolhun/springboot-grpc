package com.experiment.grpc.service;
import com.experiment.grpc.client.TestClient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGrpcServiceTest {

  @Test
  public void shouldCreateOrUpdate() {

    TestClient testClient = new TestClient("localhost", 8100);
    String response = testClient.createOrUpdate("key", "value");
    System.out.println(response);



  }

}

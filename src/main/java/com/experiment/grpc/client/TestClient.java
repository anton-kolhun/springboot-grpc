package com.experiment.grpc.client;

import com.experiment.grpc.TestCreateOrUpdateRequest;
import com.experiment.grpc.TestCreateResponse;
import com.experiment.grpc.TestServiceGrpc;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TestClient {

  private final ManagedChannel channel;
  private final TestServiceGrpc.TestServiceBlockingStub blockingStub;

  /**
   * Construct client connecting to HelloWorld server at {@code host:port}.
   */
  public TestClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext()
        .build());
  }

  /**
   * Construct client for accessing HelloWorld server using the existing channel.
   */
  TestClient(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = TestServiceGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  public String createOrUpdate(String key, String value) {
    TestCreateOrUpdateRequest request = TestCreateOrUpdateRequest.newBuilder()
        .setKey(key)
        .setValue(value)
        .build();
    TestCreateResponse testCreateResponse = blockingStub.createOrUpdate(request);
    return testCreateResponse.getMsg();
  }
}

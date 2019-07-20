package com.experiment.grpc.service;

import com.experiment.grpc.TestCreateOrUpdateRequest;
import com.experiment.grpc.TestCreateResponse;
import com.experiment.grpc.TestServiceGrpc;

import org.lognet.springboot.grpc.GRpcService;

import io.grpc.stub.StreamObserver;

@GRpcService
public class TestGrpcService extends TestServiceGrpc.TestServiceImplBase {


  @Override
  public void createOrUpdate(TestCreateOrUpdateRequest request, StreamObserver<TestCreateResponse> responseObserver) {
    //business  logic here
    TestCreateResponse resp =  TestCreateResponse.newBuilder()
        .setMsg("response")
        .build();

    responseObserver.onNext(resp);
    responseObserver.onCompleted();
  }
}

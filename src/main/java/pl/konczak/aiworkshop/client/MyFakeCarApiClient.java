package pl.konczak.aiworkshop.client;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyFakeCarApiClient {
    @GET("/api/cars")
    Call<FakeCarsResponse> getCars();
}

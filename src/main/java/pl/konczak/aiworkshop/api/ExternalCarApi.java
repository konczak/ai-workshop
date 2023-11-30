package pl.konczak.aiworkshop.api;

import pl.konczak.aiworkshop.client.FakeCar;
import pl.konczak.aiworkshop.client.MyFakeCarApiClient;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external-cars")
public class ExternalCarApi {
    private final MyFakeCarApiClient myFakeCarApiClient;

    public ExternalCarApi(final MyFakeCarApiClient myFakeCarApiClient) {
        this.myFakeCarApiClient = myFakeCarApiClient;
    }

    @GetMapping
    public List<FakeCar> getCars() throws IOException {
        return myFakeCarApiClient.getCars()
                .execute()
                .body()
                .cars();
    }
}

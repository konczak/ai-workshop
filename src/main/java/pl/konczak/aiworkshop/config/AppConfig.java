package pl.konczak.aiworkshop.config;

import pl.konczak.aiworkshop.client.MyFakeCarApiClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyFakeCarApiClient myFakeCarApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://myfakeapi.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(MyFakeCarApiClient.class);
    }

}

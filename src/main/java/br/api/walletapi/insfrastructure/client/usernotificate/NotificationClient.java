package br.api.walletapi.insfrastructure.client.usernotificate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "NotificationClient", url = "https://run.mocky.io/v3/9be129e8-a2dd-48e4-a13c-645b18c5900d")
public interface NotificationClient {
    @GetMapping
    NotificateResponse notification();

}

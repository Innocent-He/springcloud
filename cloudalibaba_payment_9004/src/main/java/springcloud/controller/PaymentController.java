package springcloud.controller;

import com.hgy.springcloud.entities.CommonResult;
import com.hgy.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/19 10:16
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    public static Map<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "1144124w3rfw525sdt345"));
        hashMap.put(2L, new Payment(2L, "a2sd312fas2113245325d"));
        hashMap.put(3L, new Payment(3L, "asd1w2fsf34as4dfg135d"));
    }

    @GetMapping("/payment/nacos/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Integer id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from my SQL port:" + serverPort, payment);
        return result;
    }
}

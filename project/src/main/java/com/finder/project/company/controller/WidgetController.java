package com.finder.project.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller("WidgetController")
@RequestMapping("/company")
public class WidgetController {


//     // @RequestMapping(value = "/confirm")
//     // public ResponseEntity<JSONObject> confirmPayment(@RequestBody String jsonBody) throws Exception {

//     //     String orderId;
//     //     String amount;
//     //     String paymentKey;
        
//     //     try {
//     //         // 클라이언트에서 받은 JSON 요청 바디입니다.
//     //         JSONObject requestData = new JSONObject(jsonBody);
//     //         paymentKey = requestData.getString("paymentKey");
//     //         orderId = requestData.getString("orderId");
//     //         amount = requestData.getString("amount");
//     //     } catch (Exception e) {
//     //         throw new RuntimeException(e);
//     //     }

//     //     JSONObject obj = new JSONObject();
//     //     obj.put("orderId", orderId);
//     //     obj.put("amount", amount);
//     //     obj.put("paymentKey", paymentKey);

//     //     // 토스페이먼츠 API는 시크릿 키를 사용자 ID로 사용하고, 비밀번호는 사용하지 않습니다.
//     //     // 비밀번호가 없다는 것을 알리기 위해 시크릿 키 뒤에 콜론을 추가합니다.
//     //     String widgetSecretKey = "test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6";
//     //     Base64.Encoder encoder = Base64.getEncoder();
//     //     byte[] encodedBytes = encoder.encode((widgetSecretKey + ":").getBytes(StandardCharsets.UTF_8));
//     //     String authorizations = "Basic " + new String(encodedBytes);

//     //     // 결제를 승인하면 결제수단에서 금액이 차감돼요.
//     //     URL url = new URL("https://api.tosspayments.com/v1/payments/confirm");
//     //     HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//     //     connection.setRequestProperty("Authorization", authorizations);
//     //     connection.setRequestProperty("Content-Type", "application/json");
//     //     connection.setRequestMethod("POST");
//     //     connection.setDoOutput(true);

//     //     OutputStream outputStream = connection.getOutputStream();
//     //     outputStream.write(obj.toString().getBytes(StandardCharsets.UTF_8));

//     //     int code = connection.getResponseCode();
//     //     boolean isSuccess = code == 200;

//     //     InputStream responseStream = isSuccess ? connection.getInputStream() : connection.getErrorStream();

//     //     // 결제 성공 및 실패 비즈니스 로직을 구현하세요.
//     //     Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
//     //     StringBuilder sb = new StringBuilder();
//     //     char[] buffer = new char[1024];
//     //     int len;
//     //     while ((len = reader.read(buffer)) != -1) {
//     //         sb.append(buffer, 0, len);
//     //     }

//     //     JSONObject jsonObject = new JSONObject(sb.toString());
//     //     responseStream.close();

//     //     return ResponseEntity.status(code).body(jsonObject);
//     // }
}
# Exception Handling

## Http Status Code

보통 웹 요청 처리시 발생하는 미처리 예외(Unhandled Exception)은 500 ERROR 응답. 
하지만, @ResponseStatus를 이용해 커스텀한 예외를 작성 할 수 있다.


Custom Exception Handling
```java
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order") // 404 
public class OrderNotFoundException extends RuntimeException { 
    // ... 
}

```

그리고 Custom Exception을 사용하는 컨트롤러
```java
@GetMapping("/orders/{id}")
 public String showOrder(@PathVariable("id") long id, Model model) {  
    Order order = orderRepository.findOrderById(id); 
    if (order == null) throw new OrderNotFoundException(id); 
    model.addAttribute(order); 
    return "orderDetail"; 
}
```

![1](imgs/1.png)
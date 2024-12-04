package pro.hw_sb.my_spring_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.hw_sb.my_spring_demo.service.CalculatorServiceImpl;



@RestController
@RequestMapping(path = "/calculator")
public class CalculatorCantroler {
    private final CalculatorServiceImpl calculatorService;

    public CalculatorCantroler(CalculatorServiceImpl calculatorService){
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String sayHello(){
        return calculatorService.hello();
    }

    @GetMapping(path = "/plus")
    public String added(@RequestParam("num1") int firstNumber, @RequestParam("num2") int secondNumber){
        return calculatorService.addNumber(firstNumber, secondNumber);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam("num1") int firstNumber, @RequestParam("num2") int secondNumber){
        return calculatorService.deduction(firstNumber, secondNumber);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") int firstNumber, @RequestParam("num2") int secondNumber){
        return calculatorService.multiply(firstNumber, secondNumber);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") int firstNumber, @RequestParam("num2") int secondNumber ) throws IllegalAccessException{
        return calculatorService.divide(firstNumber, secondNumber);
    }
}

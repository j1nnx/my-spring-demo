package pro.hw_sb.my_spring_demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public String hello(){
        return "Добро пожаловать!";
    }

    @Override
    public String addNumber(int number1, int number2) {
        int sum = number1 + number1;
        return number1 + " + " + number2 + " = " + sum;
    }

    @Override
    public String deduction(int number1, int number2) {
        int sum = number1 - number2;
        return number1 + " - " + number2 + " = " + sum;
    }

    @Override
    public String multiply(int number1, int number2) {
        int sum = number1 * number2;
        return number1 + " * " + number2 + " = " + sum;
    }

    @Override
    public String divide(int number1, int number2) throws IllegalAccessException {
        int sum;
        if (number2 == 0){
            throw new IllegalAccessException("Делить на 0 нельзя");
        } else {
            sum = number1 / number2;
        }
        return number1 + " % " + number2 + " = " + sum;
    }
}

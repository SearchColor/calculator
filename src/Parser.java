import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();

    public Parser parseFirstNum(String firstInput) throws Exception {
        // 구현 1.
        // 입력받은 firstInput이  Pattern.matches()로 비교하여 정수인지 확인하고 false면
        // BadInputException의 type에 "정수값" 넣어 에러문장 호출한다.
        if (!Pattern.matches(NUMBER_REG, firstInput)) {
            throw new BadInputException("정수값");
        }

        //입력받은 firstInput을 int로 형변환하고 setFirstNumber를 통하여 FirstNumber로 파싱
        this.calculator.setFirstNumber(Integer.parseInt(firstInput));
        return this;

    }

    public Parser parseSecondNum(String secondInput) throws Exception {
        // 구현 1.
        // 입력받은 secondInput이 Pattern.matches()로 정수인지 확인하고 false면
        // BadInputException의 type에 "정수값" 넣어 에러문장 호출
        if (!Pattern.matches(NUMBER_REG, secondInput)) {
            throw new BadInputException("정수값");
        }
        //입력받은 secondInput을 int로 형변환하고 setSecondNumber를 통하여 SecondNumber로 파싱
        this.calculator.setSecondNumber(Integer.parseInt(secondInput));
        return this;
    }

    public Parser parseOperator(String operationInput) throws Exception {
        // 구현 1.
        // 입력받은 operationInput이 Pattern.matches()로 연산자인지 확인하고 false면
        // BadInputException의 type에 "사칙 연산의 연산자" 넣어 에러문장 호출
        if (!Pattern.matches(OPERATION_REG, operationInput)) {
            throw new BadInputException("사칙 연산의 연산자");
        }


        //입력받은 operationInput 에 따라 연산계산 연결해주기
        switch (operationInput) {
            case "+" -> this.calculator.setOperation(new AddOperation());
            case "-" -> this.calculator.setOperation(new SubstractOperation());
            case "*" -> this.calculator.setOperation(new MultiplyOperation());
            case "/" -> this.calculator.setOperation(new DivideOperation());
        }
        return this;
    }


    public double executeCalculator() {
        return calculator.calculate();
    }
}
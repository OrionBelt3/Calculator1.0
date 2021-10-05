import java.util.HashSet;
import java.util.Stack;


public class Realization {

    Realization(){}

    Realization(String enterStr){
        System.out.println(calculation( enterStr));
    }

    // stack of number
    private Stack<Double> stackNumbers = new Stack<>();
    // stack of symbols ( + - * / )
    private Stack<Character> stackCharacter = new Stack<>();

    public double getUpperNumber(){
        return stackNumbers.pop();
    }
    public void setUpperNumber(double number){
        stackNumbers.push(number);
    }

    public char getUpperCharacter(){
        return stackCharacter.pop();
    }
    public void setUpperCharacter(char character){
        stackCharacter.push(character);
    }

    // add
    public void calcModule(char charUp, double leftValue, double rightValue){
        switch (charUp){
            case '*':
                setUpperNumber(leftValue * rightValue);
                break;
            case '/':
                setUpperNumber(leftValue / rightValue);
                break;
            case '+':
                setUpperNumber(leftValue + rightValue);
                break;
            case '-':
                setUpperNumber(leftValue - rightValue);
                break;
        }

    }

    public String buildEnterStr(String enterStr){
        StringBuilder sb = new StringBuilder();
        sb.append(enterStr);
        sb.append('=');
        int i = 0;
        while(sb.charAt(i) != '='){
            if(sb.charAt(i) == '-'){
                sb.replace(i, i+1, "+0-");
            }
            i++;
        }
        sb.deleteCharAt(i);
        return sb.toString();
    }
    public void calcWithBrackets(){
        char getUp;
        double leftValue; // leftValue (operation) rightValue
        double rightValue;
        while(stackCharacter.peek() != '('){
            getUp = getUpperCharacter();
            rightValue = getUpperNumber();
            leftValue = getUpperNumber();
            calcModule(getUp, leftValue, rightValue); // calculation one a operation
        }

    }

    public void calcStack(){
        char getUp;
        double leftValue; // leftValue (operation) rightValue
        double rightValue;
        while(!stackCharacter.empty()){
            getUp = getUpperCharacter();
            rightValue = getUpperNumber();
            leftValue = getUpperNumber();
            calcModule(getUp, leftValue, rightValue); // calculation one a operation
        }
    }

    public Double calculation(String enterStr){

        HashSet<Character> setOperation = new HashSet<>();
        HashSet<Character> setFirstPriority = new HashSet<>();
        HashSet<Character> setSecondPriority = new HashSet<>();
        HashSet<Character> setThirdPriority = new HashSet<>();
        setFirstPriority.add('+');
        setFirstPriority.add('-');
        setSecondPriority.add('/');
        setSecondPriority.add('*');
        setThirdPriority.add('(');
        setThirdPriority.add(')');

        setOperation.addAll(setFirstPriority);
        setOperation.addAll(setSecondPriority);
        setOperation.addAll(setThirdPriority);

        // if string is empty
        if(enterStr.isEmpty()){
            return 0.0;
        }

        char prevChar = '0';
        int  prevNum = 0;
        int openBrackets = 0;
        int i = 0;
        while(i < enterStr.length()){
            if(setOperation.contains(enterStr.charAt(i))){ // if symbol contains in own set
                if(enterStr.charAt(i) == '('){
                    openBrackets++;
                } else if(enterStr.charAt(i) != '(') {
                    if (prevChar == '-') {
                        setUpperNumber(0 - Double.parseDouble(enterStr.substring(prevNum, i)));
                        getUpperCharacter();
                        setUpperCharacter('+');
                    } else if (setFirstPriority.contains(enterStr.charAt(i)) & (setSecondPriority.contains(prevChar))) {
                        if(i != prevNum){
                            setUpperNumber(Double.parseDouble(enterStr.substring(prevNum, i)));
                        }
                        if (openBrackets == 0) {
                            calcStack();
                        } else {
                            calcWithBrackets();
                        }
                    } else {
                        if(i != prevNum){
                            setUpperNumber(Double.parseDouble(enterStr.substring(prevNum, i)));
                        }
                    }
                }
                if(enterStr.charAt(i) == ')'){
                    calcWithBrackets();
                    getUpperCharacter();
                    if(!stackCharacter.empty()) {
                        prevChar = stackCharacter.peek();
                    } else {
                        prevChar = '0';
                    }
                    openBrackets--;
                    prevNum = i+1;

                } else {
                    setUpperCharacter(enterStr.charAt(i));
                    prevNum = i+1;
                    prevChar = enterStr.charAt(i);
                }
            }
            i++;
        }
        if(prevNum != i){
            setUpperNumber(Double.parseDouble(enterStr.substring(prevNum, i)));
        }
        calcStack();
        return getUpperNumber();
    }
}

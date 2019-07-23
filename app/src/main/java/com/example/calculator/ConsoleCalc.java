package com.example.calculator;

 import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


///////////////////////////////////////////////////////////////////////////////////////////
//evaluate expression value


class PostFixConverter {
    private String infix; // The infix expression to be converted
    private Deque<Character> stack = new ArrayDeque<Character>();
    private List<String> postfix = new ArrayList<String>(); // To hold the postfix expression

    public PostFixConverter(String expression)
    {
        infix = expression;
        convertExpression();
    }

    /* The approach is basically, if it's a number, push it to postfix list
     * else if it's an operator, push it to stack
     */
    private void convertExpression()
    {
        // Temporary string to hold the number
        StringBuilder temp = new StringBuilder();

        for(int i = 0; i != infix.length(); ++i)
        {
            if(Character.isDigit(infix.charAt(i)))
            {
                /* If we encounter a digit, read all digit next to it and append to temp
                 * until we encounter an operator.
                 */
                temp.append(infix.charAt(i));

                while((i+1) != infix.length() && (Character.isDigit(infix.charAt(i+1))
                        || infix.charAt(i+1) == '.'))
                {
                    temp.append(infix.charAt(++i));
                }


                /* If the loop ends it means the next token is an operator or end of expression
                 * so we put temp into the postfix list and clear temp for next use
                 */
                postfix.add(temp.toString());
                temp.delete(0, temp.length());
            }
            // Getting here means the token is an operator
            else
                inputToStack(infix.charAt(i));
        }
        clearStack();
    }


    private void inputToStack(char input)
    {
        if(stack.isEmpty() || input == '(')
            stack.addLast(input);
        else
        {
            if(input == ')')
            {
                while(!stack.getLast().equals('('))
                {
                    postfix.add(stack.removeLast().toString());
                }
                stack.removeLast();
            }
            else
            {
                if(stack.getLast().equals('('))
                    stack.addLast(input);
                else
                {
                    while(!stack.isEmpty() && !stack.getLast().equals('(') &&
                            getPrecedence(input) <= getPrecedence(stack.getLast()))
                    {
                        postfix.add(stack.removeLast().toString());
                    }
                    stack.addLast(input);
                }
            }
        }
    }


    private int getPrecedence(char op)
    {
        if (op == '+' || op == '-')
            return 1;
        else if (op == '*' || op == '/')
            return 2;
        else if (op == '^')
            return 3;
        else return 0;
    }


    private void clearStack()
    {
        while(!stack.isEmpty())
        {
            postfix.add(stack.removeLast().toString());
        }
    }


    public void printExpression()
    {
        for(String str : postfix)
        {
            System.out.print(str + ' ');
        }
    }


    public List<String> getPostfixAsList()
    {
        return postfix;
    }
}


/////////////////////////////////////////////////////////



class PostFixCalculator {

    private int f=0;
    private List<String> expression = new ArrayList<String>();
    private Deque<Double> stack = new ArrayDeque<Double>();

    public PostFixCalculator(List<String> postfix) {expression = postfix;}



        public BigDecimal result ()
        {
            try {


                for (int i = 0; i != expression.size(); ++i) {
                    // Determine if current element is digit or not
                    if (Character.isDigit(expression.get(i).charAt(0))) {
                        stack.addLast(Double.parseDouble(expression.get(i)));
                    } else {
                        double tempResult = 0;
                        double temp;

                        switch (expression.get(i)) {
                            case "+":
                                temp = stack.removeLast();
                                tempResult = stack.removeLast() + temp;
                                break;

                            case "-":
                                temp = stack.removeLast();
                                tempResult = stack.removeLast() - temp;
                                break;

                            case "*":
                                temp = stack.removeLast();
                                tempResult = stack.removeLast() * temp;
                                break;

                            case "/":
                                temp = stack.removeLast();
                                tempResult = stack.removeLast() / temp;
                                break;
                        }
                        stack.addLast(tempResult);
                    }
                }
            }
            catch(Exception e){
                f=1;
            }
            if(f==1){
                return BigDecimal.valueOf(000000);
            }
            else{
                return new BigDecimal(stack.removeLast()).setScale(3, BigDecimal.ROUND_HALF_UP);
            }

        }

}



class ConsoleCalc {

    public String sak (String expression)
    {
        PostFixConverter pc = new PostFixConverter(expression);
        pc.printExpression();
        PostFixCalculator calc = new PostFixCalculator(pc.getPostfixAsList());

        //////////////////////////////////////////////////////
        String ff = (calc.result()).toString();
        return ff;
    }
}

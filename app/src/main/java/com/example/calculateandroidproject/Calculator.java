package com.example.calculateandroidproject;

public class Calculator {
    private int pos = -1, ch;
    private final String str;

    public Calculator(String str){
        this.str = str;
    }

    public String getResult(){
        try {
            return String.valueOf(parse());
        } catch (RuntimeException e) {
            return "NaN";
        }

    }
    private void nextChar() {
        ch = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    private boolean eat(int charToEat) {
        while (ch == ' ') nextChar();
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }

    private double parse() {
        nextChar();
        return parseExpression();
    }

    private double parseExpression() {
        double x = parseTerm();
        for (; ; ) {
            if (eat('+')) x += parseTerm(); // addition
            else if (eat('-')) x -= parseTerm(); // subtraction
            else return x;
        }
    }

    private double parseTerm() {
        double x = parseFactor();
        for (; ; ) {
            if (eat('*')) x *= parseFactor(); // multiplication
            else if (eat('/')) x /= parseFactor(); // division
            else return x;
        }
    }

    private double parseFactor() {
        if (eat('+')) return +parseFactor(); // plus
        if (eat('-')) return -parseFactor(); // minus

        double x = 0;
        int startPos = this.pos;
        if (eat('(')) { // parentheses
            x = parseExpression();
        } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
            x = Double.parseDouble(str.substring(startPos, this.pos));
        } /*else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                    } else {
                        x = parseFactor();
                    }
                    switch (func) {
                        case "sqrt":
                            x = Math.sqrt(x);
                            break;
                        case "sin":
                            x = Math.sin(Math.toRadians(x));
                            break;
                        case "cos":
                            x = Math.cos(Math.toRadians(x));
                            break;
                        case "tan":
                            x = Math.tan(Math.toRadians(x));
                            break;
                    }
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
                 */
        if (eat('%')) x = x / 100 * parseFactor(); // interest

        return x;
    }
}

package folder;
import java.util.Stack;
import javax.swing.JLabel;
public class conversor {
    static void conversion(String infija,JLabel mostrarPro, JLabel mostrarInfi){       
       mostrarPro.setText("Notación POSFIJA: " + infijaAPosifija(infija));
    }
        static int evaluacionSymbolo(char c){
        switch (c){
            case '-':
            case '+':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
               return 3;
        }
        return -1;
    }
    
        static StringBuilder infijaAPosifija(String expression){
       StringBuilder result = new StringBuilder();
       StringBuilder input = new StringBuilder(expression);
       input.reverse();
       Stack<Character> stack = new Stack<>();
       char [] charsExp = new String(input).toCharArray();
       for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i <charsExp.length ; i++) {
            char K = charsExp[i];
            if(evaluacionSymbolo(K)>0){
                while(stack.isEmpty()==false && evaluacionSymbolo(stack.peek())>evaluacionSymbolo(K)){
                    Character dato = stack.pop();
                    result.append(dato);
                                   }
 
                stack.push(K);
            }else if(K==')'){
                char J = stack.pop();
                    while(J!='('){
                    result.append(J);
                    J = stack.pop();
                    }
                }else if(K=='('){
                stack.push(K);
                    }else{
                    result.append(K);
                    }
        }
        for (int i = 0; i <=stack.size()+1 ; i++) {
           Character dato = stack.pop();
            result.append(dato);
        }
        return result.reverse();
    }

}
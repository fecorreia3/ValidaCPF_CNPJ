/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valida_CPF;

/**
 * classe de validação de CPF
 * 
 * a entrada é o numero de cpf inteiro comente os numeros e a saida é um booleano inticando true para valido e false para invalido
 * 
 * Algoritmo de Validação do CPF
 *
 *
 * O algoritmo de validação do CPF calcula o primeiro dígito verificador a partir dos 9 primeiros dígitos do CPF, e em seguida, calcula o segundo dígito verificador a partir dos 9 (nove) primeiros dígitos do CPF, mais o primeiro dígito, obtido na primeira parte.
 *
 * Tomes como exemplo o CPF fictício : 111.444.777-05.
 * 
 * a - Cálculo do primeiro dígito
 *
 * O primeiro passo é calcular o primeiro dígito verificador, e para isso, separamos os primeiros 9 dígitos do CPF (111.444.777) e multiplicamos cada um dos números, da direita para a esquerda por números crescentes a partir do número 2, como no exemplo abaixo:
 *
 * 1	  1	  1	  4	  4	  4	  7	  7	  7
 * 10	  9	  8	  7	  6	  5	  4	  3	  2
 * 10	  9	  8	  28	  24	  20	  28	  21	  14
 * Multiplicamos cada digito do CPF pelo respectivo número e somamos cada um dos resultados : 10+9+8+28+24+20+28+21+14 = 162
 *
 * Pegamos o resultado obtido 162 e dividimos por 11.  Consideramos como quociente apenas o valor inteiro.
 *
 * 162 / 11  =    14  com resto 8   
 *
 * - Se o resto da divisão for menor que 2, então o dígito é igual a 0 (Zero).
 * - Se o resto da divisão for maior ou igual a 2, então o dígito verificador é igual a 11 menos o resto da divisão (11 - resto).
 *
 * No nosso exemplo temos que o resto é 8 então faremos 11-8 = 3
 * 
 * Logo o primeiro dígito verificador é 3. Então podemos escrever o CPF com os dois dígitos calculados :  111.444.777-3X
 * 
 * b - Cálculo do segundo dígito
 * 
 * Para  calcular o segundo dígito vamos usar o primeiro digito já calculado. Vamos montar a mesma tabela de multiplicação usada no cálculo do primeiro dígito. Só que desta vez usaremos na segunda linha os valores 11,10,9,8,7,6,5,4,3,2 já que estamos incluindo mais um digito no cálculo(o primeiro dígito calculado):

1	1	1	4	4	4	7	7	7	3
11	10	9	8	7	6	5	4	3	2
11	10	9	32	28	24	35	28	21	6
Novamente, efetuamos somamos o resultado da multiplicação : 11 + 10 + 9 + 32 + 28 + 24 + 35 + 28 + 21 + 6 = 204

Dividimos o total do somatório por 11 e consideramos o resto da divisão.

204 / 11  =  18  e  resto 6

Após obter o resto da divisão, precisamos aplicar a mesma regra que utilizamos para obter o primeiro dígito:

- Se o resto da divisão for menor que 2, então o dígito é igual a 0 (Zero).
- Se o resto da divisão for maior ou igual a 2, então o dígito é igual a 11 menos o resto da divisão (11 - resto).

11-6= 5   logo 5 é o nosso segundo dígito verificador.

 *Logo o nosso CPF fictício será igual a : 111.444.777-35.
 * 
 * @author fe_li
 */
public class validaCPF {
    
    public validaCPF(){
        
    }
    /**
     * 
     * @param cpf 
     */
    
    public validaCPF(String cpf){
        int soma=0;
        String digito;
        String temp_cpf;
        int n1;
        int n2;
        
        //verifica se o numero do CPF está correto
        if(cpf.length()>11){
            System.out.println("digite o cpf sem ponto e sem traço, somente numeros!!");
            System.exit(1);
        }else if(cpf.length()<11){
            System.out.println("CPF faltando digitos, confira e insira novamente!");
            System.exit(1);
        }
        
        //Separa o digito e coloca na variavel 'digito' o restante do numero sem o digito vai para a variavvel 'temp_cpf'
        digito = cpf.substring(cpf.length()-2, cpf.length());
        temp_cpf = cpf.substring(0, cpf.length()-2);
        
        
        
        //pega o primeiro digito do temp_cpf e multiplica por 10, o segundo por 9 e assim ate o ultimo digito 
        for(int x=1; x<temp_cpf.length()+1;x++){
            soma += Integer.parseInt(temp_cpf.substring(x-1, x)) * (11-x);
        }
        
        if((soma/11)<2){
            n1=0;
        }else{
            n1= 11-(soma%11);
        }
        
        ////segundo digito/////
        
        //coloca o digito encontrado na variavel e zera a variavel soma
        temp_cpf = temp_cpf + "" + n1;
        soma = 0;
        
        
        for(int x=1; x< temp_cpf.length()+1; x++){
             soma += Integer.parseInt(temp_cpf.substring(x-1, x)) * (12-x);
        }
        
        if((soma/11)<2){
            n2=0;
        }else{
            n2= 11-(soma%11);
        }
        
        //agora com os dois digitos é comparado com o digito do cpf indicado
        
        if(digito.endsWith(String.valueOf(n1)+String.valueOf(n2))){
            System.out.println("CPF valido!!!");
        }else{
            System.out.println("CPF invalido!!!");
        }
        
        
    }
    
    
    public static void main (String[] args){
        validaCPF valida = new validaCPF("27500302859");
        valida.toString();
        
    }
    
}

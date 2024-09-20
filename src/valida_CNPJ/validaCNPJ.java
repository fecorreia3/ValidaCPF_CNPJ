/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valida_CNPJ;



import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author fe_li
 */
public class validaCNPJ {
    
    public void valida(String numCNPJ){
        String cnpj = numCNPJ.replace(".", "").replace("/", "").replace("-", "");        
        ArrayList<Integer> peso = new ArrayList(Arrays.asList(6,5,4,3,2,9,8,7,6,5,4,3,2));
        String digito = cnpj.substring(cnpj.length()-2, cnpj.length());
        String temp_cnpj = cnpj.substring(0, cnpj.length()-2);
        int soma =0;
        int digito1=0;
        int digito2=0;
        
        for(int x=1; x<temp_cnpj.length()+1;x++){
           soma += Integer.parseInt(temp_cnpj.substring(x-1, x)) * peso.get(x);
        }        
        if(soma%11<=2){
            digito1=0;
        }else{
        digito1 = 11-(soma%11);
        }
        temp_cnpj = temp_cnpj + digito1;
        
        
        
        //calcula o segundo digito
        soma=0;
         for(int x=1; x<temp_cnpj.length()+1;x++){
           soma += Integer.parseInt(temp_cnpj.substring(x-1, x)) * peso.get(x-1);
        }      
         
         if(soma%11<=2){
            digito2=0;
        }else{
        digito2 = 11-(soma%11);
        }
         
         //valor do cnpj com o digito calculado, para fins de programa que calcula o digito e não só compara
        temp_cnpj = temp_cnpj + digito2;
        
        if(digito.equalsIgnoreCase(digito1+""+digito2)){
            System.out.println("CNPJ valido!!");
        }else{
            System.out.println("CNPJ invalido!!");
        }
        
    }
    
    
    public static void main (String[] args){
        validaCNPJ cnpj = new validaCNPJ();
        cnpj.valida("08.244.943/0004-21");
    }
    
}

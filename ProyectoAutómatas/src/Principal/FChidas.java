/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import rojerusan.RSNotifyAnimated;
import java.util.ArrayList;

/**
 *
 * @author HP15DA0023LA
 */
public class FChidas {
    private String expresionRegular="";
    private ArrayList<Integer> PosParentesis = new ArrayList<Integer>();
    public int esValido(String cadena){
        int contadorParentesis=0;
        int tam= cadena.length();
        if(tam==0)
        {
            return 0;
        }
        for(int i=0; i<tam;i++)
        {
            
            String caracter=cadena.charAt(i)+"";
            char aux= cadena.charAt(i);
            if(i==0 && ((")".equals(caracter))||("|".equals(caracter))||("*".equals(caracter))))
            {
                return 0;
            }
            else if(i==(tam-1) && (("|".equals(caracter))||("(".equals(caracter))))
            {
                return 0;
            }
            if(((!"(".equals(caracter))&&(!")".equals(caracter))&&(!"*".equals(caracter))&&(!"|".equals(caracter)))&&((aux<97)|| (aux>122)))
            {
                return 0;
            }
            //esto es para controlar que no existan más parentesis de cerradura que de entrada
            if(caracter.equals("("))
            {
                String cDes=cadena.charAt(i+1)+"";
                contadorParentesis++;
                if((cDes.equals("*"))||(cDes.equals(")")))
                {
                    return 0;
                }
                
            }
            if(caracter.equals(")"))
            {
                contadorParentesis--;
            }
            if(caracter.equals("|"))
            {
                String cAnt=cadena.charAt(i-1)+"";
                String cDes=cadena.charAt(i+1)+"";
                if((cDes.equals("*"))||(cDes.equals(")"))||(cDes.equals("|"))||(cAnt.equals("("))||(cAnt.equals("|")))
                {
                    return 0;
                }
            }
            if(caracter.equals("*"))
            {
                if(i!=(tam-1))
                {
                    String cDes=cadena.charAt(i+1)+"";
                    if(cDes.equals("*"))
                    {
                        return 0;
                    }
                }
                String cAnt=cadena.charAt(i-1)+"";
            }
            if(contadorParentesis<0)
            {
                return 0;
            }
            if((i==(tam-1))&&(contadorParentesis!=0))
            {
                return 0;
            }
        }
        
        return 1;
    }
    
    public boolean buenaCadena(String cadena){
        return cadena.matches(this.expresionRegular);
    }
    
    public boolean verificarAlfabeto(String caracter){
        for (int i= 0; i<this.expresionRegular.length(); i++)
        {
            String cExp= this.expresionRegular.charAt(i)+"";
            if((cExp.equals(caracter))&&(!cExp.equals("("))&&(!cExp.equals("|"))&&(!cExp.equals(")"))&&(!cExp.equals("*")))
            {
                return true;
            }
        }
        return false;
    }
    
    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }
     
       
    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

import java.io.Serializable;

/**
 *
 * @author Marcos Naves
 */
public class Utilitarios implements Serializable {

    public static boolean calculaCPF(String cpfNum) {
        
        if (cpfNum.length() < 11) {
            return false;
        }

        if (cpfNum != null && !cpfNum.isEmpty()) {
            int[] cpf = new int[cpfNum.length()]; //define o valor com o tamanho da string   
            int resultP = 0;
            int resultS = 0;

            //converte a string para um array de integer   
            for (int i = 0; i < cpf.length; i++) {
                cpf[i] = Integer.parseInt(cpfNum.substring(i, i + 1));
            }

            //calcula o primeiro numero(DIV) do cpf   
            for (int i = 0; i < 9; i++) {
                resultP += cpf[i] * (i + 1);
            }
            int divP = resultP % 11;

            //se o resultado for diferente ao 10 digito do cpf retorna falso   
            if (divP != cpf[9]) {
                return false;
            } else {
                //calcula o segundo numero(DIV) do cpf   
                for (int i = 0; i < 10; i++) {
                    resultS += cpf[i] * (i);
                }
                int divS = resultS % 11;

                //se o resultado for diferente ao 11 digito do cpf retorna falso   
                if (divS != cpf[10]) {
                    return false;
                }
            }

            //se tudo estiver ok retorna verdadeiro   
            return true;

        } else {
            return false;
        }

    }//fim do calcular cpf ==================================================   

    public static boolean calculaCNPJ(String cnpjNum) {
        int[] cnpj = new int[cnpjNum.length()];
        int resultP = 0;
        int resultS = 0;
        int divP = 0;
        int divS = 0;

        //converte string para um array de integer   
        for (int i = 0; i < cnpjNum.length(); i++) {
            cnpj[i] = Integer.parseInt(cnpjNum.substring(i, i + 1));
        }

        int j = 6;
        //calcula o primeiro div   
        for (int i = 0; i < 12; i++) {
            resultP += cnpj[i] * j;

            j++;
            if (j > 9) {
                j = 2;
            }
        }
        divP = resultP % 11;

        if (divP != cnpj[12]) {
            return false;
        } else {
            j = 5;
            //calcula o segundo div    
            for (int i = 0; i < 13; i++) {
                resultS += cnpj[i] * j;

                j++;
                if (j > 9) {
                    j = 2;
                }
            }
            divS = resultS % 11;

            if (divS != cnpj[13]) {
                return false;
            }
        }
        return true;
    }//fim do calcular CNPJ ==================================================   

}

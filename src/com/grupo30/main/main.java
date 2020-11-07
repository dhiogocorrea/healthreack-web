package com.grupo30.main;
 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.grupo30.model.Peso;
import com.grupo30.model.Usuario;

public class main   {

    public static void main(String[] args) throws ParseException {
    	DateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
    	
       //Instanciando a classe usuario 
    	Usuario usuario = new Usuario(1, "Guilherme", "Souza Paulo", 666666666, "M", "guilherBH@gmail.com", "mypass", dtf.parse("05/10/1990"), dtf.parse("05/10/1990"), dtf.parse("05/10/1990"), 999297591);

        Peso peso = new Peso(1,175.5, dtf.parse("25/05/2020"));
        usuario.setPeso(peso); 
       
        System.out.println("UserID: " + usuario.getCodPessoa() +  "\nUsu�rio: " + usuario.getNome()+   "\nCPF:"  + usuario.getCpf());
 		System.out.println("\nDados: \nE-mail: "  + usuario.getEmail() +  "\nSexo: " + usuario.getSexo()+   "\nData Nascimento: "  + usuario.getDtNascimento()+"\n");
    }

}

    
    



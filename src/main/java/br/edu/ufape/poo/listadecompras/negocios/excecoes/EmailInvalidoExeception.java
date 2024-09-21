package br.edu.ufape.poo.listadecompras.negocios.excecoes;

public class EmailInvalidoExeception extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public EmailInvalidoExeception(String email) {
		super("Email inválido.");

		if(!email.contains("@")){
			System.out.println("Email sem '@'.");
		}
		else if(!email.contains(".com")){
			System.out.println("Email sem dominio.");
		}
		else if(!email.contains("gmail") && !email.contains("hotmail") && !email.contains("outlook") && !email.contains("yahoo")){
			System.out.println("Email sem serviço.");
		}
		else if(email.indexOf('@') < 3){
			System.out.println("Email muito curto.");
		}

    }

}

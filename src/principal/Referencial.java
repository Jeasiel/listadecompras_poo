package principal;

/**
 * Classe de exemplo, com javadoc feito em Classe, Método e Campo/Variável.
 * Javadoc são comentários especiais que se usam como documentação, iniciado por barra e dois asteriscos.
 * Comentários normais são escritos com duas barras e comentários de várias linhas são escritos com barra asterisco, tornando possível pular linhas com enter.
 * @author Jeasiel
 */
public class Referencial {
    int numero;
    
    /**
     * Algumas coisas usamos arroba, como para dizer qual é o tipo do retorno e quais são os parâmetros
     * @return retorna o número
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Um exemplo de parâmetro é esse (note que não tem o return, logo não é necessário o return no javadoc)
     * @param numero número para ser adicionado no lugar do número atual
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    //Mais exemplos desses arroba podem ser vistos no livro que mandei
}

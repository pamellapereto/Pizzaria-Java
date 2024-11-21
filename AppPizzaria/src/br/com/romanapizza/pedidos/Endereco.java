package br.com.romanapizza.pedidos;

public class Endereco {
    private String logradouro, complemento, bairro, cidade, estado, cep;
    private int numero;

    public Endereco(String logradouro, String complemento, String bairro, String cidade, String estado, String cep, int numero) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
    }

    private String getLogradouro() {
        return logradouro;
    }

    private String getComplemento() {
        return complemento;
    }

    private String getBairro() {
        return bairro;
    }

    private String getCidade() {
        return cidade;
    }

   private String getEstado() {
        return estado;
    }

    private String getCep() {
        return cep;
    }

    private int getNumero() {
        return numero;
    }

    public void cadastroSucesso() {
        System.out.print("Endereço cadastrado: " + getLogradouro() + "\n"
                + getNumero());
    }
}

package br.com.romanapizza.pedidos;

public class Endereco {
    private String logradouro, complemento, bairro, cidade, estado, cep;
    private int numero;

    public Endereco(String logradouro,int numero, String complemento, String bairro, String cidade, String estado, String cep) {
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
    public String cadastroSucesso() {
        return "\n Rua: " + getLogradouro() + ", " + getNumero() + getBairro()
                + getCidade() + getEstado() + getCep();

    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


}


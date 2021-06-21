package com.listagem.veiculos.DTO;

public class MensagemRespostaDTO<T> {

	String mensagem;
	
	T Data;

    public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}
	
	public MensagemRespostaDTO() {
    }	

	public MensagemRespostaDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

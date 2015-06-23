package pcs;

/**
 *
 * @author riguco
 */
public class Questao {
    int id, tipoquestao, nivel, indiceresposta;
    String pergunta, resposta1, resposta2, resposta3, resposta4, resolucao;

    public Questao(int id, int tipoquestao, int nivel, int indiceresposta, String pergunta, String resposta1, String resposta2, String resposta3, String resposta4, String resolucao) {
        this.id = id;
        this.tipoquestao = tipoquestao;
        this.nivel = nivel;
        this.indiceresposta = indiceresposta;
        this.pergunta = pergunta;
        this.resposta1 = resposta1;
        this.resposta2 = resposta2;
        this.resposta3 = resposta3;
        this.resposta4 = resposta4;
        this.resolucao = resolucao;
    }

    public Questao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoquestao() {
        return tipoquestao;
    }

    public void setTipoquestao(int tipoquestao) {
        this.tipoquestao = tipoquestao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getIndiceresposta() {
        return indiceresposta;
    }

    public void setIndiceresposta(int indiceresposta) {
        this.indiceresposta = indiceresposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta1() {
        return resposta1;
    }

    public void setResposta1(String resposta1) {
        this.resposta1 = resposta1;
    }

    public String getResposta2() {
        return resposta2;
    }

    public void setResposta2(String resposta2) {
        this.resposta2 = resposta2;
    }

    public String getResposta3() {
        return resposta3;
    }

    public void setResposta3(String resposta3) {
        this.resposta3 = resposta3;
    }

    public String getResposta4() {
        return resposta4;
    }

    public void setResposta4(String resposta4) {
        this.resposta4 = resposta4;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }
        
}

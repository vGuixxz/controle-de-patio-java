public class Caminhao {

    private int id;
    private String entrada;
    private String tipo;
    private int frota;
    private String motorista;
    private String container;
    private String plataforma;
    private String situacao;
    private String ocorrencia;
    private String saida;
    private int usuarioId; 


    public Caminhao(int id,
                        String entrada,
                    String tipo,
                        int frota,
                    String motorista,
                        String container,
                    String plataforma,
                        String situacao,
                    String ocorrencia,
                        String saida,
                    int usuarioId) {

                this.id = id;
                    this.entrada = entrada;
                this.tipo = tipo;
                    this.frota = frota;
                this.motorista = motorista;
                    this.container = container;
                this.plataforma = plataforma;
                    this.situacao = situacao;
                this.ocorrencia = ocorrencia;
                    this.saida = saida;
                this.usuarioId = usuarioId;
                                    }

        
            //GET

            public int getId() {
                return id;
            }

            public String getEntrada() {
                return entrada;

            }

            public String getTipo() {
                return tipo;
            }

            public int getFrota() {
                return frota;
            }

    
            public String getMotorista() {
                return motorista;
            }


            public String getContainer() {
                return container;
            }
    

            public String getPlataforma() {
                return plataforma;
            }


            public String getSituacao() {
                return situacao;
            }


            public String getOcorrencia() {
                return ocorrencia;
            }



            public String getSaida() {
                return saida;
            }


            public int getUsuarioId() {
                return usuarioId;
            }


            // SET

            public void setId(int id) {
                this.id = id;
            }

            public void setEntrada(String entrada) {
                this.entrada = entrada;
            }

            public void setTipo(String tipo) {
                this.tipo = tipo;
            }

            public void setFrota(int frota) {
                this.frota = frota;
            }

            public void setMotorista(String motorista) {
                this.motorista = motorista;
            }

            public void setContainer(String container) {
                this.container = container;
            }

            public void setPlataforma(String plataforma) {
                this.plataforma = plataforma;
            }

            public void setSituacao(String situacao) {
                this.situacao = situacao;
            }

            public void setOcorrencia(String ocorrencia) {
                this.ocorrencia = ocorrencia;
            }

            public void setSaida(String saida) {
                this.saida = saida;
            }

            public void setUsuarioId(int usuarioId) {
                this.usuarioId = usuarioId;
            }
            

    public void mostrarDados() {

        System.out.println("ID: " + id);
        System.out.println("ENTRADA: " + entrada);
        System.out.println("TIPO: " + tipo);
        System.out.println("FROTA: " + frota);
        System.out.println("MOTORISTA: " + motorista);
        System.out.println("CONTAINER: " + container);
        System.out.println("PLATAFORMA: " + plataforma);
        System.out.println("SITUACAO: " + situacao);
        System.out.println("OCORRENCIA: " + ocorrencia);
        System.out.println("SAIDA: " + saida);
        System.out.println("USUARIO: " + usuarioId);
        System.out.println("<----------------------->");


    }              


    
}

public class Carga {

    private int id;
    private int caminhaoId;

    private String shipment;   // usado no carregamento
    private String nf;         // usado no descarregamento
    private String referencia; // usado no descarregamento
    private String produto;    // usado no descarregamento

    private int usuarioId;
    private String tipoOperacao;

    // 🔵 CONSTRUTOR PARA CARREGAMENTO
    public Carga(int id, int caminhaoId, String shipment, int usuarioId) {

        this.id = id;
        this.caminhaoId = caminhaoId;
        this.shipment = shipment;
        this.usuarioId = usuarioId;
        this.tipoOperacao = "CARREGAMENTO";

        // campos que não são usados aqui ficam null
        this.nf = null;
        this.referencia = null;
        this.produto = null;
    }

    // 🟢 CONSTRUTOR PARA DESCARREGAMENTO
    public Carga(int id, int caminhaoId,
                 String nf, String referencia,
                 String produto, int usuarioId) {

        this.id = id;
        this.caminhaoId = caminhaoId;
        this.nf = nf;
        this.referencia = referencia;
        this.produto = produto;
        this.usuarioId = usuarioId;
        this.tipoOperacao = "DESCARREGAMENTO";

        // campo que não é usado aqui fica null
        this.shipment = null;
    }

    // ✅ GETTERS

    public int getId() {
        return id;
    }

    public int getCaminhaoId() {
        return caminhaoId;
    }

    public String getShipment() {
        return shipment;
    }

    public String getNf() {
        return nf;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getProduto() {
        return produto;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    // 🔧 SETTERS (opcional, pode remover alguns depois se quiser)

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public void setNf(String nf) {
        this.nf = nf;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    // 📄 Mostrar dados

    public void mostrarDados() {

        System.out.println("=== DADOS DA CARGA ===");
        System.out.println("Tipo: " + tipoOperacao);
        System.out.println("ID: " + id);
        System.out.println("Caminhão ID: " + caminhaoId);

        if (shipment != null) {
            System.out.println("Shipment: " + shipment);
        }

        if (nf != null) {
            System.out.println("NF: " + nf);
        }

        if (referencia != null) {
            System.out.println("Referência: " + referencia);
        }

        if (produto != null) {
            System.out.println("Produto: " + produto);
        }

        System.out.println("Usuário ID: " + usuarioId);
        System.out.println("--------------------------");
    }
}
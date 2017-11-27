package model;




import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "entregas")
public class Entrega {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "feita")
    private boolean feita;

    @OneToOne
    @JoinColumn(unique = true)
    private Destinatario destinatario;

    @OneToOne
    @JoinColumn(unique = true)
    private Entregador entregador;

    @OneToMany(mappedBy = "entrega")
    private List<Produto> produtos;


    @ManyToOne
    private Empresa empresa;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Destinatario getDestinatario() {
		return destinatario;
	}


	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}


	public Entregador getEntregador() {
		return entregador;
	}


	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public boolean isFeita() {
		return feita;
	}


	public void setFeita(boolean feita) {
		this.feita = feita;
	}
	
	



}

package model;



import javax.persistence.*;
import java.util.List;




@Entity
@Table(name = "empresas")
public class Empresa {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Embedded
    private Endereco endereco;
    
    @OneToMany(mappedBy = "empresa")
    private List<Produto> produtos;

    @OneToMany(mappedBy = "empresa", targetEntity = Destinatario.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Destinatario> destinatarios;
  

    @OneToMany(mappedBy = "empresa")
    private List<Entrega> entregases;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public List<Destinatario> getDestinatarios() {
		return destinatarios;
	}


	public void setDestinatarios(List<Destinatario> destinatarios) {
		this.destinatarios = destinatarios;
	}


	public List<Entrega> getEntregases() {
		return entregases;
	}


	public void setEntregases(List<Entrega> entregases) {
		this.entregases = entregases;
	}


    
    

   
    
}

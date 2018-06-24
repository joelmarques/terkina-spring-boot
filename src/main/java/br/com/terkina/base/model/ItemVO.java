package br.com.terkina.base.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ItemVO implements Serializable {

	private static final long serialVersionUID = 5528169621089667271L;
	
	private Long id;
	private String descricao;
	
	public ItemVO() {
		super();
	}
	
	public ItemVO(Number id, String descricao) {
		super();
		this.id = id.longValue();
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id.longValue();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Collection<Long> convert(final List<ItemVO> registros) {
		return registros.stream().map(ItemVO::getId).collect(Collectors.toList());
	}
}
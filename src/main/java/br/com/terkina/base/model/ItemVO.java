package br.com.terkina.base.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ItemVO implements Item {

	private Long id;
	private String descricao;
	
	public ItemVO(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public static Collection<Long> convert(final List<ItemVO> registros) {
		return registros.stream().map(ItemVO::getId).collect(Collectors.toList());
	}
}
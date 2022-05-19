package br.com.senai.manutencaosenaiapi.view.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.manutencaosenaiapi.entity.TipoPeca;
import br.com.senai.manutencaosenaiapi.entity.TipoPeca;

public class TipoPecaTableModel extends AbstractTableModel{
	
	private final int QTDE_COLUNAS = 2;
	
	private List<TipoPeca> tiposPeca;	
	
	public TipoPecaTableModel(List<TipoPeca> tiposPeca) {	
		this.tiposPeca = tiposPeca;
	}
	
	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		}else if (column == 1) {
			return "Descrição";
		}
		throw new IllegalArgumentException("Indice inválido");
	}
	
	public TipoPeca getPor(int rowIndex) {
		return tiposPeca.get(rowIndex);
	}
	
	public void removerPor(int rowIndex) {
		tiposPeca.remove(rowIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if (columnIndex == 0) {
			return tiposPeca.get(rowIndex).getId();
		}else if (columnIndex == 1) {
			return tiposPeca.get(rowIndex).getDescricao();
		}
		
		throw new IllegalArgumentException("Indice inválido");
	}

	@Override
	public int getRowCount() {
		return tiposPeca.size();
	}

}

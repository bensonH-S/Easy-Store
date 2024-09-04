/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cyro
 */
public class ModeloTabelaProduto extends AbstractTableModel{
    
    private ArrayList<ModeloProduto> produto = new ArrayList();

    @Override
    public int getRowCount() {
        
        return produto.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int comlumnIndex) {
        ModeloProduto p = produto.get(rowIndex);
        
        switch(comlumnIndex){
            case 0:
            return p.getNomeProduto();
            case 1:
            return p.getQtdProduto();
            case 2:
            return p.getPrecoVenda();
            
            default:
            return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        
        switch(column){
            
            case 0:
                return "Nome Produto";
            case 1:
                return "Quantidade";
            case 3:
                return "Valor Produto";
            default:
                
                return "";
            
        }
        
    }
    public void adicionar(ModeloProduto p){
        
        produto.add(p);
        fireTableRowsInserted(produto.size() -1, produto.size() -1);
    }
    
    public void remover(ModeloProduto p){
        produto.remove(p);
        fireTableRowsInserted(produto.size() -1, produto.size() -1);
        
    }
}

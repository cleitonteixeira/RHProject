package br.com.nutribemrefeicoescoletivas.model;

import br.com.nutribemrefeicoescoletivas.bean.FuncionarioBean;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TelaCadastroFuncionarioModel extends AbstractTableModel{
     private static final int Nome = 0,
            CPF = 1,
            Cargo = 2,
            Unidade = 3;

    private final  List<FuncionarioBean> lFuncBean;
    
/**
 *
 * @param lFuncBean lFuncBean com dados da classe acervo
 */
    public TelaCadastroFuncionarioModel( List<FuncionarioBean> lFuncBean){
        this.lFuncBean = lFuncBean;
    }

/**
 *
 * @return tamanho da lFuncBean
 */
    @Override
    public int getRowCount() {
        return lFuncBean.size();
    }
    
/**
 *
 * @return quantidade de colunas
 */
    @Override
    public int getColumnCount() {
        return 4;
    }
    
/**
 *
 * @return retorna o nome das colunas
 */
    @Override
    public String getColumnName(int column){
        if (column == Nome)
            return "NOME";
        if (column == CPF)
            return "CPF";
        if (column == Cargo)
            return "CARGO";
        if (column == Unidade)
            return "UNIDADE";
        return "";
    }
    
/** "";
    }
    
/**
 *
     * @param row
     * @param column
 * @return os dados contidos na lFuncBean
 */
    @Override
    public Object getValueAt(int row, int column) {
        FuncionarioBean func = lFuncBean.get(row);
        if (column == Nome)
            return func.getNome();
        if (column == CPF)
            return func.getCPF();
        if (column == Cargo)
            return func.getCargo();
        if (column == Unidade)
            return func.getUnidade();
        
        return "";
    }
    
/**
 *
     * @param aValue
     * @param row
     * @param column

 */
    @Override
   public void setValueAt(Object aValue , int row , int column){
        FuncionarioBean funcl = lFuncBean.get(row);
        if (column == Nome)
            funcl.setNome(aValue.toString());
        if (column == CPF)
           funcl.setCPF((long)aValue.hashCode());
        if (column == Cargo)
            funcl.setCargo(aValue.toString());
        if (column == Unidade)
            funcl.setUnidade(aValue.toString());
    }
   
/**);
    }
   
/**
 *
     * @param column

 * @return retorna sobrecarga na superclasse String
 */
    @Override
   public Class<?> getColumnClass(int column)
    {
        return String.class;
    }
   
/**
 *
     * @param row
     * @param column

 * @return retorna se os dados na tabela são editaveis
 */
    @Override
   public boolean isCellEditable(int row , int column)
    {
        return false;
    }
   
/**
 *
     * @param row

 */
   public void delete(int row)
    {
        lFuncBean.remove(row);
        this.fireTableRowsDeleted(row, row);
    }
   
/**
 *
     * @param sv

 */
   public void add(FuncionarioBean sv)
    {
        lFuncBean.add(sv);
        this.fireTableRowsInserted(lFuncBean.size()-1, lFuncBean.size()-1);
    }
   
/**
 *
     * @param row

 * @return os dados da lFuncBean em linhas
 */
   public FuncionarioBean get(int row)
    {
        return lFuncBean.get(row);
    }   
}

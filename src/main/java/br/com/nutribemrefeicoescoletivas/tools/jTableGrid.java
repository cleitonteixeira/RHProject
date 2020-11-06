package br.com.nutribemrefeicoescoletivas.tools;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class jTableGrid {
    public void FormatarJtable(JTable tabela, int valores[]) {

        if (tabela.getColumnCount() == valores.length) {
            for (int x = 0; x < valores.length; x++) {
                tabela.getColumnModel().getColumn(x).setPreferredWidth(valores[x]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao formatar jTable! \n"
                                                + "Verifique os parâmetros passados!");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfce.teste;

import br.com.samuelweb.certificado.exception.CertificadoException;
import br.com.samuelweb.nfe.Nfe;
import br.com.samuelweb.nfe.dom.ConfiguracoesIniciaisNfe;
import br.com.samuelweb.nfe.exception.NfeException;
import br.com.samuelweb.nfe.util.ConstantesUtil;
import br.inf.portalfiscal.nfe.schema_4.retConsStatServ.TRetConsStatServ;
import static nfce.teste.ConstantesNFCE.iniciaConfiguraçõesA1;

/**
 *
 * @author deivid
 */
public class StatusNFCE {

    public static void main(String[] args) {
        try {
            iniciaConfiguraçõesA1();
            TRetConsStatServ retorno = Nfe.statusServico(ConstantesUtil.NFCE);
            System.out.println("Status:" + retorno.getCStat());
            System.out.println("Motivo:" + retorno.getXMotivo());
            System.out.println("Data:" + retorno.getDhRecbto());
        } catch (CertificadoException | NfeException e) {
            System.err.println(e.getMessage());
        }

    }

}

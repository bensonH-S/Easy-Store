/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfce.teste;

import br.com.samuelweb.certificado.exception.CertificadoException;
import br.com.samuelweb.nfe.Nfe;
import br.com.samuelweb.nfe.dom.Enum.StatusEnum;
import br.com.samuelweb.nfe.exception.NfeException;
import br.com.samuelweb.nfe.util.ConstantesUtil;
import br.inf.portalfiscal.nfe.schema.retConsCad.TRetConsCad;
import static nfce.teste.ConstantesNFCE.iniciaConfiguraçõesA1;

/**
 *
 * @author deivid
 */
public class ConsultaCadastroNFCE {

    public static void main(String[] args) {
        try {
            iniciaConfiguraçõesA1();
            TRetConsCad retorno = Nfe.consultaCadastro(ConstantesUtil.TIPOS.CNPJ, "99999999999999");
            if (retorno.getInfCons().getCStat().equals(StatusEnum.CADASTRO_ENCONTRADO.getCodigo())) {
                System.out.println("Razão Social: " + retorno.getInfCons().getInfCad().get(0).getXNome());
                System.out.println("Cnpj:" + retorno.getInfCons().getInfCad().get(0).getCNPJ());
                System.out.println("Ie:" + retorno.getInfCons().getInfCad().get(0).getIE());
            } else {
                System.err.println(retorno.getInfCons().getCStat() + " - " + retorno.getInfCons().getXMotivo());
            }
        } catch (NfeException | CertificadoException e) {
            System.out.println(e.getMessage());
        }
    }

}
